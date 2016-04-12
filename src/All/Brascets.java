package All;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Alexandr on 02.01.2016.
 */
public class Brascets {
    public static void main(String[] args) throws IOException {
        ArrayDeque<Character> a = new ArrayDeque<>();
        ArrayDeque<Character> s = new ArrayDeque<>();
        String batton = "!";
        Character temp;
        boolean posible=true;
        StringBuilder string = new StringBuilder();

        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            String next = scn.next();
            if (batton.equals(next)) {
                System.in.close();
                break;
            }
            string.append(next);
        }

        for(int i = 0; i<string.length(); i++){
            if ( string.charAt(i) == '(' ||  string.charAt(i) == '[' ||  string.charAt(i) == '{' ){
                s.addLast(string.charAt(i));
            }
            if ( string.charAt(i) == ')' || string.charAt(i) == ']' || string.charAt(i) == '}'){
                if (s.isEmpty()==true){
                    a.addLast(string.charAt(i));
                }else {
                    temp = s.pollLast();
                    if ((string.charAt(i) == ')' && temp != '(') || (string.charAt(i) == ']' && temp != '[') || (string.charAt(i) == '}' && temp != '{')){
                        posible = false;
                        break;
                    }

                }
            }
        }
        if (posible==true){
int i =0;
            while  (a.isEmpty()==false){
                temp = a.pollLast();
                if (temp == ']'){
                    temp = '[';
                }

                if (temp == ')'){
                    temp = '(';
                }

                if (temp == '}'){
                    temp = '{';
                }
                System.out.print(temp);
                System.out.print(string.charAt(i));
                i++;

            }
            for(int j = i+1; i<string.length(); i++){
                System.out.print(string.charAt(j));
            }
            while  (s.isEmpty()==false){
                temp = s.pollLast();
                if (temp == '['){
                    temp = ']';
                }

                if (temp == '('){
                    temp = ')';
                }

                if (temp == '['){
                    temp = '}';
                }

                System.out.print(temp);

            }

        } else System.out.println("IMPOSSIBLE");


    }

}