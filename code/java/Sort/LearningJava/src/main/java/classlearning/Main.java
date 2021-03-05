package classlearning;

interface Animal {
    void makeNoise(String theAnimalNoise);
}

class Unicorn implements Animal {

    @Override
    public void makeNoise(String theAnimalNoise) {
        System.out.println("A Unicorn Noise");
    }
}

public class Main {
    public static void main(String[] args)  {

        /*
        System.out.println("hi");

        Unicorn stary = new Unicorn();
        stary.makeNoise("A quiet noise");

         */
    }
}

