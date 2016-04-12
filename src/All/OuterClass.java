package All;

public class OuterClass {
    public static void method() {
        byte b = 127;
        b += 129;
        System.out.println(b);



    }


    public class InnerClass {
        public void method() {

        }

        public void anotherMethod() {
            method();
            throw null;
        }
    }

    public static void main(String[] args) {
        OuterClass.method();


    }
}