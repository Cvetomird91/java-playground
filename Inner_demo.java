class Outer_demo {

    private int num = 175;
    public static String id = "class id";

    public class Inner_Demo {
        public int getNum() {
            System.out.println("getNum method of inner class");
            return num;
        }
    }

    static class StaticInnerClass {
        public StaticInnerClass() {
            System.out.println("from static inner class");
            System.out.println(id);
        }
    }
}

public class Inner_demo {
    public static void main(String[] args) {
        Outer_demo outer = new Outer_demo();

        // Instantiating the inner class
        Outer_demo.Inner_Demo inner = outer.new Inner_Demo();
        System.out.println(inner.getNum());

        class MethodInnerClass {
            MethodInnerClass() {
                System.out.println("method inner class");
            }
        }

        new MethodInnerClass();

        Outer_demo.StaticInnerClass staticInner = new Outer_demo.StaticInnerClass();
    }
}
