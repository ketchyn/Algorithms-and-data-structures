package Company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Alexandr on 02.04.2016.
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Manager[] man =  {
            new Manager("vasy"), new Manager("pety")};
        /*Emploee<Integer>[] emp = new Emploee[5];
        emp[0] = new Emploee<>(5);
        Object[] AA = emp;
        AA[0] = "Hello";*/

  /*      Emploee<Integer>[] emp =(Emploee<Integer>[]) new Emploee<?>[5];
        Emploee<String> str = new Emploee<>("sss");
        emp[0] = str;
        Object[] AA = emp;
        AA[0] = "Hello";*/


        Emploee<Integer> emp = new Emploee<>(5);
        System.out.println(emp.getName());
        Emploee emp1 = emp;
        emp1.setName(new Scanner(new File("input.txt")));
        System.out.println(emp.getName());
        emp1.getName();



      //  Object[] AA = emp;
       // AA[0] = "Hello";



        //emp[0] = new Emploee("kolya");



    }
}
