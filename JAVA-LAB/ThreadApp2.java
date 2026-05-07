class EvenThread extends Thread {

    public void run() {

        System.out.println("Even Numbers:");

        for (int i = 1; i <= 20; i++) {

            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }
}

class OddThread extends Thread {

    public void run() {

        System.out.println("Odd Numbers:");

        for (int i = 1; i <= 20; i++) {

            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
    }
}

public class ThreadApp2 {

    public static void main(String[] args) {

        EvenThread t1 = new EvenThread();

        OddThread t2 = new OddThread();

        t1.start();

        t2.start();
    }
}