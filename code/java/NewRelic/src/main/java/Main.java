import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args)  {

        /*
        Map<Integer, Integer> numbersMap = new HashMap<>();
        int currentNumber;

        //Put 1
        for (int i = 0; i < 1; i++) {
            currentNumber = 1;
            numbersMap.put(currentNumber, numbersMap.getOrDefault(currentNumber, 0)+ 1);
        }

        //Put 2
        for (int i = 0; i < 2; i++) {
            currentNumber = 2;
            numbersMap.put(currentNumber, numbersMap.getOrDefault(currentNumber, 0)+ 1);
        }

        //Put 3
        for (int i = 0; i < 3; i++) {
            currentNumber = 3;
            numbersMap.put(currentNumber, numbersMap.getOrDefault(currentNumber, 0)+ 1);
        }

        //Put 4
        for (int i = 0; i < 4; i++) {
            currentNumber = 4;
            numbersMap.put(currentNumber, numbersMap.getOrDefault(currentNumber, 0)+ 1);
        }
        //System.out.println(numbersMap);
        */
        //Random
        Random rand = new Random();
        int currentNumber;
        Map<Integer, Integer> numbersMapLoop = new HashMap<Integer, Integer>();

        for (int j = 0; j<50; j++) {
            currentNumber = rand.nextInt(10) + 1;
            System.out.println(currentNumber);
            numbersMapLoop.put(currentNumber, numbersMapLoop.getOrDefault(currentNumber, 0)+ 1);

        }

        System.out.println(numbersMapLoop);


    }

}

/*
int numberOne = 1;
int numberTwo = 3;
int numberThree = 1;
int numberFour = 1;
int numberFive = 2;
numbersMap.put(numberOne, numbersMap.getOrDefault(numberOne, 0)+ 1);
System.out.println(numbersMap);
numbersMap.put(numberTwo, numbersMap.getOrDefault(numberTwo, 0)+ 1);
System.out.println(numbersMap);
numbersMap.put(numberThree, numbersMap.getOrDefault(numberThree, 0)+ 1);
System.out.println(numbersMap);
numbersMap.put(numberFour, numbersMap.getOrDefault(numberFour, 0)+ 1);
System.out.println(numbersMap);
numbersMap.put(numberFive, numbersMap.getOrDefault(numberFive, 0)+ 1);
System.out.println(numbersMap);

System.out.println("_______________");
*/