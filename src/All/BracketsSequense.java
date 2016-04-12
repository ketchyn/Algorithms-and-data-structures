package All;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Alexandr on 28.12.2015.
 */
public class BracketsSequense {
    public static Boolean isRight(Character chr) {
        if (chr == '{' || chr == '[' || chr == '(') return true;
        if (chr == '}' || chr == ']' || chr == ')') return  false;
        return  null;
    }

    public static boolean verse(Character chr, Character chr1){
        if (chr =='}'&&chr1=='{'){
            return  true;
        }
        if (chr ==')'&&chr1=='('){
            return  true;
        }
        if (chr ==']'&&chr1=='['){
            return  true;
        }
        return  false;
    }


    public static void main(String[] args) throws IOException {
        int squareleft = 0;
        int roundleft = 0;
        int figureleft = 0;
        int squareRight = 0;
        int roundRight = 0;
        int figureRight = 0;
        char prevFigure = ' ';
        char prevSquare = ' ';
        char prevRound = ' ';
        int direction = 0;
        char prev = ' ';
        String imp;
        int cauntLeft=0;
        int cauntRight=0;



        boolean neadClose = false;
        StringBuilder string = new StringBuilder();
        String batton = "!";
        ArrayDeque<Character> dequeOrig = new ArrayDeque<>();
        ArrayDeque<Character> dequeClose = new ArrayDeque<>();
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            String next = scn.next();
            if (batton.equals(next)) {
                System.in.close();
                break;
            }
            string.append(next);
        }
       // System.out.println(string);
       for(int i = 0;i<string.length();i++){
            if (i==0&&  (isRight(string.charAt(i))==false)){

                dequeClose.add('a'); break;

            }else {
                if (isRight(string.charAt(i)) == true) {
                    dequeClose.addLast(string.charAt(i));
                } else if (dequeClose.isEmpty() == false) {
                    if (verse(string.charAt(i), dequeClose.peekLast()) == true) {
                        dequeClose.pollLast();
                    }

                } else  {dequeClose.add('a'); break;}
            }

        }

        if(dequeClose.isEmpty()==true){
            System.out.println("IMPOSSIBLE");
        }
        else {
            dequeClose.clear();


            for (int i = 0; i < string.length(); i++) {

                if (string.charAt(i) == '}') {
                    cauntLeft++;
                    dequeOrig.addLast('}');
                    figureleft++;
                    if (figureRight > 0&&dequeClose.isEmpty()==false) {
                        dequeClose.pollLast();
                        figureleft--;
                    } else {
                        dequeClose.addLast('{');
                        figureRight++;

                    }
                }

                if (string.charAt(i) == '{') {
                    cauntRight++;
                    dequeOrig.addLast('{');
                    figureRight++;

                    dequeClose.addLast('}');
                    figureleft++;


                }

                if (string.charAt(i) == ')') {
                    cauntLeft++;
                    dequeOrig.addLast(')');
                    roundleft++;
                    if (roundRight > 0&&dequeClose.isEmpty()==false) {
                        dequeClose.pollLast();
                        roundleft--;
                    } else {
                        dequeClose.addLast('(');
                        roundRight++;

                    }
                }

                if (string.charAt(i) == '(') {
                    cauntRight++;
                    dequeOrig.addLast('(');
                    roundRight++;
                    dequeClose.addLast(')');
                    roundleft++;


                }

                if (string.charAt(i) == ']') {
                    cauntLeft++;
                    dequeOrig.addLast(']');
                    squareleft++;
                    if (squareRight > 0&&dequeClose.isEmpty()==false) {
                        dequeClose.pollLast();
                        squareleft--;
                    } else {
                        dequeClose.addLast('[');
                        squareRight++;

                    }
                }

                if (string.charAt(i) == '[') {
                    cauntRight++;
                    dequeOrig.addLast('[');
                    squareRight++;
                    dequeClose.addLast(']');
                    squareleft++;


                }
            }



        }



            while(dequeClose.isEmpty()==false){
                if (isRight(dequeClose.peek())==true){
                    if(dequeOrig.size()<=1000000000)
                    dequeOrig.addFirst(dequeClose.pollFirst());

                }else {
                    if(dequeOrig.size()<=1000000000)
                    dequeOrig.addLast(dequeClose.pollLast());
                }
        }
       // System.out.println(dequeOrig.toString());
      //  System.out.println(squareRight + " "+ squareRight);



            StringBuilder res = new StringBuilder();
           Iterator iter =  dequeOrig.iterator();

            while (iter.hasNext()){
                res.append(iter.next());
            }

            dequeClose.clear();
        //System.out.println(res.toString());

            for(int i = 0;i<res.length();i++){
                if (isRight(res.charAt(i))==true){
                    dequeClose.addLast(res.charAt(i));
                }else if (dequeClose.isEmpty()==false){
                    if(verse(res.charAt(i),dequeClose.peekLast())==true){
                        dequeClose.pollLast();
                    }

                } else System.out.println("IMPOSSIBLE");

            }

            if(dequeClose.isEmpty()==true)
            {
                System.out.println(res.toString());
            }else System.out.println("IMPOSSIBLE");


        }


}

