package GreedyAlgoritms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Alexandr on 06.03.2016.
 */
class HafmanEx {
     public static  class Node implements Comparable<Node>{


         final int sum;
         String code;
        public Node( int sum) {
            this.sum = sum;

        }
         public String buildCode(String code){
             this.code = code;
             return code;

         }

        @Override
        public  int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }

    }
   static  class InternalNode extends Node {
        Node left;
        Node right;

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;

        }

       @Override
       public String buildCode(String code) {
           super.buildCode(code);
           left.buildCode(code+ 0);
           right.buildCode(code+ 1);
           return code;
       }
   }
    static class LeafNode extends Node {
        char letter;

        public LeafNode(char c, int count) {
            super(count);
            letter=c;
        }

        @Override
        public String buildCode(String code) {

            super.buildCode(code);
            System.out.println(letter+ ": "+ code);
            return code;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Scanner scn = new Scanner( new File("input.txt")/*System.in*/);
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, String> map1 = new HashMap<>();
        String s = null;
        while (scn.hasNext()) {
            s = scn.next();
        }

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        Map<Character, Node> resultMap = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            resultMap.put(entry.getKey(), node);
            queue.add(node);
        }



        int sum=0;

        while (queue.size() > 1) {
            Node first = queue.poll();
            Node second= queue.poll();
            InternalNode node = new InternalNode(first, second);
            queue.add(node);
            sum += node.sum;

        }
        if(count.size()==1) {

            sum = s.length();
        }
            System.out.println(count.size()+ " "+ sum);

        Node root = queue.poll();
        if (count.size()==1) {
            root.code = "0";
            root.buildCode("0");

        } else {
            root.buildCode("");
        }

        StringBuilder codeResult = new StringBuilder("");



        for(int i = 0; i<s.length();i++) {
            char c = s.charAt(i);
            String code = resultMap.get(c).code;
            codeResult.append(code);
        }
        System.out.println(codeResult);


        /*System.out.println(sum);
        System.out.println(queue.toString());
        System.out.println(map.toString());*/



    }
}
