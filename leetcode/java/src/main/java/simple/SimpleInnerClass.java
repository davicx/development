package simple;

public class SimpleInnerClass {
    public static void main(String[] args) {
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.innerClass + myOuter.outerClass);
        System.out.println(OuterClass.StaticInnerClass.sayHi("frodo"));

    }
}

class OuterClass {
    public String outerClass = "outerClass";

    class InnerClass {
        public String innerClass = "innerClass";
    }

    class StaticInnerClass {
        private String staticInnerClass;

        //Constructor
        public StaticInnerClass(String staticInnerClass) {
            this.staticInnerClass = staticInnerClass;
        }

        //Getter and Setter
        public String getStaticInnerClass() {
            return staticInnerClass;
        }

        public void setStaticInnerClass(String staticInnerClass) {
            this.staticInnerClass = staticInnerClass;
        }

        //Method
        public static String sayHi (String yourName) {
            String greeting = "hello " + yourName;

            return greeting;
        }


    }
}

