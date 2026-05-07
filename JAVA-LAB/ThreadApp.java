/*
Name: Pranav Shailesh Landge
Class: SY-A
Roll_no: 41
Subject: JPL
Assignment-10-Write a Java program to implement a producer-consumer problem using the
wait() and notify() methods for thread synchronization.
*/

class Buffer {
    private int product;
    private boolean isProduced = false;

    public synchronized void produce(int product) throws InterruptedException {
        while (isProduced) {
            wait();
        }
        this.product = product;
        isProduced = true;
        System.out.println("Produced: " + product);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!isProduced) {
            wait();
        }
        System.out.println("Consumed: " + product);
        isProduced = false;
        notify();
    }
}

class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(1000); // Simulating time to produce a product
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(1500); // Simulating time to consume a product
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ThreadApp {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
