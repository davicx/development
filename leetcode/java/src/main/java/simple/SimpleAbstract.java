package simple;

public class SimpleAbstract {
    public static void main(String[] args) {
        WoodElf legolas = new WoodElf("legolas");
        legolas.sayHello();
    }
}

abstract class Elf {
    public abstract void sayHello();

    //Regular method
    public void sleep() {
        // Say hi
        System.out.println("I am sleeping!");
    }
}

class WoodElf extends Elf {
    public String userName;

    public WoodElf(String inputUserName) {
        this.userName = inputUserName;
    }


    public void woodElfFight() {
        // Fight
        System.out.println("I use a bow!");
    }

    @Override
    public void sayHello() {
        // Say hi
        System.out.println("Hi I am a woodelf!");
    }
}

