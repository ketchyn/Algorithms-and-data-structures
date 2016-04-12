package InnerClasses;

import java.io.ByteArrayOutputStream;

/**
 * Created by Alexandr on 14.03.2016.
 */
 class OuterClass2 {

public static  void  printMessage() {
        System.out.println("Outer class ");
    }

    class InnerClass1 {
        public void printMessage() {
            System.out.println("Name of inner class1 " + this.getClass().getName());
        }
    }

    class $b{

    }

    public void InmethodExMetgod() {
        class InnerClass2 {
            public void prinmessage() {
                System.out.println("Name of innerclass2 " + this.getClass().getName());
            }

        }
        InnerClass2 a = new InnerClass2();
        a.prinmessage();
    }

    public static OuterClass2 annonimExMetgod() {
      /*  OuterClass2 AA = new OuterClass2(){
            @Override
            public void printMessage() {
                System.out.println("anonim Class " + this.getClass().getName());
            }

        };*/
       // return AA;
        return null;

        }

    private static final class InnerClass3 extends OuterClass2 {

    }


    public static void main(String[] args) {


        //InnerClass3.prinMessage();
        printMessage();



    }

}




