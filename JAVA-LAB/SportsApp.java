/*
Write a Java program to create an interface Playable with a method play()
that takes no arguments and returns void. Create three classes Football,
Volleyball, and Basketball that implement the Playable interface and
override the play() method to play the respective sports
*/

interface Playable {
    void play();
}

class Football implements Playable {

    public void play() {
        System.out.println("Playing Football");
    }
}

class Volleyball implements Playable {

    public void play() {
        System.out.println("Playing Volleyball");
    }
}

class Basketball implements Playable {

    public void play() {
        System.out.println("Playing Basketball");
    }
}

public class SportsApp {

    public static void main(String[] args) {

        Playable p1 = new Football();
        Playable p2 = new Volleyball();
        Playable p3 = new Basketball();

        p1.play();
        p2.play();
        p3.play();
    }
}