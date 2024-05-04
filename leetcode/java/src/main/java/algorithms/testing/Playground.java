package algorithms.testing;

public class Playground {
    public String playgroundName;

    public Playground(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    //Method
    public Integer sum(Integer num1, Integer num2) {
        //System.out.println("sum: I was called!! ");
        Integer answer = num1 + num2;

        return answer;
    }
}


/*
package myPlayground;

public class Playground {
    public String playgroundName;

    public Playground(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    public Integer sum(Integer num1, Integer num2) {
        //System.out.println("sum: I was called!! ");
        Integer answer = num1 + num2;

        return answer;
    }

    public String whenLearning(String sayWhen) {
        return sayWhen;
    }

    public String learnVerify(String stringToSend) {
        System.out.println("Step 1: Learn Verify was called");
        calledByLearnVerify(stringToSend);
        return "Step 3: learnVerify return output";
    }

    public void calledByLearnVerify(String cameFromLearnVerify) {
        System.out.println("Step 2: The method calledByLearnVerify was called from learnVerify with this input " + cameFromLearnVerify);
    }

}


 */