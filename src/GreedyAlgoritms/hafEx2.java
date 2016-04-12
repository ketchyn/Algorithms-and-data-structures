package GreedyAlgoritms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Alexandr on 07.03.2016.
 */
public class hafEx2 {

class Pair {
    Character c;
    int end;
    InternalNode node;
    public Pair(Character c, int end, InternalNode node) {
        this.c = c;
        this.end = end;
        this.node = node;

    }
}
    private InternalNode node;

    public void addCode(char latter, String code) {
        if (this.node == null) {
            this.node = new InternalNode(latter, code, "");
        } else node.findPlaceForCode(code, latter, "", 0);
    }


    public String deCode(String siq) {
        int start = 0;
        int end = 1;
        StringBuilder result = new StringBuilder("");
        Pair pair = new Pair(null, 0, this.node);
        while (end <= siq.length()) {
                Pair pair1    = this.deCode(siq, pair.node, start, end);
            Character res = pair1.c;
            if ((res == null)) {
                end=++pair1.end;
                pair.node = pair1.node;
                continue;
            } else {
                pair.node = this.node;
                start = pair1.end;
               end =++pair1.end;
            }
            result.append(res);
            res = null;

        }
        return result.toString();


    }

    private Pair deCode(String siq, InternalNode nodeInternal, int start, int end) {
        String subseq = "";

        subseq = siq.substring(start, end);

        if (!subseq.equals(nodeInternal.code)) {

            if (nodeInternal.left != null) {

                if (subseq.equals(nodeInternal.left.current)) {
                    return deCode(siq, nodeInternal.left, start, end);
                }
            }
            if (nodeInternal.right != null) {

                if (subseq.equals(nodeInternal.right.current)) {
                    return deCode(siq, nodeInternal.right, start, end
                    );
                }
            }

        } else {
            return new Pair(nodeInternal.latter,end,nodeInternal);
             /*  start=end;
               if (end<=siq.length()) {
                   end++;
               }
              return deCode(siq,node,start,end);*/
        }
        ;
          /* if (end<=siq.length()) {
               end++;
           }*/
        //}
        return new Pair(null, end,nodeInternal);
    }

    public hafEx2() {

    }

    class InternalNode {
        InternalNode left;
        InternalNode right;
        char latter;
        String current;
        String code;


        public InternalNode(char latter, String code, String current) {
            this.current = current;

            this.findPlaceForCode(code, latter, current, 0);
        }

        public void findPlaceForCode(String code, char latter, String currenrt, int i) {
            if (code.equals(current)) {
                this.code = code;
                this.latter = latter;
            } else {

                while (i < code.length()) {
                    String substring = code.substring(0, ++i);
                    if (substring.equals(currenrt + "0")) {

                        if (left == null) {
                            left = new InternalNode(latter, code, current + "0");
                        } else left.findPlaceForCode(code, latter, currenrt + "0", i);

                    }
                    if (substring.equals(current + "1")) {
                        if (right == null) {
                            right = new InternalNode(latter, code, current + "1");
                        } else right.findPlaceForCode(code, latter, currenrt + "1", i);

                    }
                }


            }


        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Map<Character, String> charToCode = new HashMap<>();
        Scanner scn = new Scanner(new File("input.txt"));
        int amount = scn.nextInt();
        char a;
        int codeLength = Integer.parseInt(scn.next());
        for (int i = 0; i < amount; i++) {
            String buff = scn.next();
            a = buff.charAt(0);
            String value = scn.next();
            charToCode.put(a, value);

        }
        String res = scn.next();
        //System.out.println(charToCode);

        hafEx2 ex = new hafEx2();
        for (Map.Entry<Character, String> entry : charToCode.entrySet()) {
            ex.addCode(entry.getKey(), entry.getValue());

        }


        String result = ex.deCode(res);

        System.out.println(result);


    }
}
