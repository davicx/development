package simple;

public class SimpleInheritance {
    public static void main(String[] args) {
        Hero frodo = new Hero("hobbit", "frodo");
        frodo.sayHi();
        frodo.practiceArchery();
    }
}

class Person {
    protected String race;

    public Person(String type) {
        this.race = race;
    }

    public void sayHi() {
        System.out.println("hi from the person!");
    }
}

class  Hero extends Person {
    private String userName;

    public Hero(String race, String userName) {
        super(race);
        this.userName = userName;
    }

    public void sayHi() {
        System.out.println("hi but now I am a hero!");
    }

    public void practiceArchery() {
        System.out.println("Shoot my bow!");
    }

}
