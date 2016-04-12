package TreapSecondIml;

import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alexandr on 27.01.2016.
 */
public class Test {




/**
 * Created by Alexandr on 27.01.2016.
 */

    /**
     * Created by Alexandr on 27.01.2016.
     */




        public static class TreapTree
        {

            class TreapNode {
                TreapNode left, right;
                int priority, element;

                /**
                 * Constructor
                 **/
                public TreapNode() {
                    this.element = 0;
                    this.left = this;
                    this.right = this;
                    //this.priority = this;
                }

                /**
                 * Constructor
                 **/
                public TreapNode(int ele, int priority) {
                    this(ele, null, null,priority);
                }
                public TreapNode(int ele, TreapNode left, TreapNode right, int priority)
                {
                    this.element = ele;
                    this.left = left;
                    this.right = right;
                    this.priority = priority;
                }
            }
            private TreapNode root;
            //private  TreapNode nil = new TreapNode();

            /** Constructor **/
            public TreapTree()
            {
                root = null;
            }

            /** Function to check if tree findPlaceForCode empty **/
            public boolean isEmpty()
            {
                return root == null;
            }

            /** Make the tree logically empty **/
            public void makeEmpty()
            {
                root = null;
            }

            /** Functions to insert data **/
            public void insert(int X, int priority)
            {
                root = insert(X, root,priority);
            }
            private TreapNode insert(int X, TreapNode T,int priority)
            {
                if (T == null)
                    return new TreapNode(X, null, null,priority);
                else if (X <T.element)
                {
                    T.left = insert(X, T.left, priority);
                    if (T.left.priority > T.priority)
                    {
                        TreapNode L = T.left;
                        T.left = L.right;
                        L.right = T;
                        return L;
                    }
                }
                else if (X > T.element)
                {
                    T.right = insert(X, T.right,priority);
                    if (T.right.priority > T.priority)
                    {
                        TreapNode R = T.right;
                        T.right = R.left;
                        R.left = T;
                        return R;
                    }
                }
                return T;
            }


            public int height() {
                return height(root);
            }

            private int height(TreapNode node) {
                if(node == null) return 0;
                return 1 + Math.max(height(node.left), height(node.right));
            }

            /** Functions to count number of nodes **/
            public int countNodes()
            {
                return countNodes(root);
            }
            private int countNodes(TreapNode r)
            {
                if (r == null)
                    return 0;
                else
                {
                    int l = 1;
                    l += countNodes(r.left);
                    l += countNodes(r.right);
                    return l;
                }
            }

            /** Functions to search for an element **/
            public boolean search(int val)
            {
                return search(root, val);
            }
            private boolean search(TreapNode r, int val)
            {
                boolean found = false;
                while ((r != null) && !found)
                {
                    int rval = r.element;
                    if (val < rval)
                        r = r.left;
                    else if (val > rval)
                        r = r.right;
                    else
                    {
                        found = true;
                        break;
                    }
                    found = search(r, val);
                }
                return found;
            }

            /** Function for inorder traversal **/
            public void inorder()
            {
                inorder(root);
            }
            private void inorder(TreapNode r)
            {
                if (r != null)
                {
                    inorder(r.left);
                    System.out.print(r.element +" ");
                    inorder(r.right);
                }
            }

            /** Function for preorder traversal **/
            public void preorder()
            {
                preorder(root);
            }
            private void preorder(TreapNode r)
            {
                if (r != null)
                {
                    System.out.print(r.element +" ");
                    preorder(r.left);
                    preorder(r.right);
                }
            }

            /** Function for postorder traversal **/
            public void postorder()
            {
                postorder(root);
            }
            private void postorder(TreapNode r)
            {
                if (r != null)
                {
                    postorder(r.left);
                    postorder(r.right);
                    System.out.print(r.element +" ");
                }
            }
        }





        /**
         * Created by Alexandr on 03.01.2016.
         */
        public static class BinaryTree<T extends Comparable<T>> {

            BinaryTreeNode<T> root;
            private int count;

            public void add(T value) {
                if (root == null) {
                    root = new BinaryTreeNode<T>(value);
                } else {
                    addTo(root,value);
                    count++;
                }
            }

            public int height() {
                return height(root);
            }

            private int height(BinaryTreeNode<T> node) {
                if(node == null) return 0;
                return 1 + Math.max(height(node.left), height(node.Right));
            }


            private StringBuilder str = new StringBuilder();
            public   String postoRrder(){
                String res;
                return res = postoRrder(root);
            }

            private String  postoRrder(BinaryTreeNode<T> node){

                if (node.left !=null) postoRrder(node.left);
                if (node.Right!=null) postoRrder(node.Right);
                str.append(node.value + " ");
                return str.toString();
            }


            private void addTo(BinaryTreeNode node, T value) {
                if (value.compareTo((T) node.value) < 0) {
                    if (node.left==null){
                        node.left = new BinaryTreeNode(value);
                    }else addTo(node.left, value);
                }else {
                    if (node.Right == null) {
                        node.Right = new BinaryTreeNode(value);
                    }else addTo(node.Right, value);
                }
            }
            private BinaryTreeNode parent=null;
            public boolean contains(T value) {

                return findWithParent(value)!=null;
            }


            private BinaryTreeNode findWithParent(T value) {
                BinaryTreeNode current = root;
                parent = null;
                while (current != null) {
                    int res = value.compareTo((T)current.value);
                    if (res < 0) {
                        parent=current;
                        current = current.left;
                    }
                    if (res > 0) {
                        parent=current;
                        current=current.Right;
                    } else break;;

                }
                return current;
            }

            public boolean remove(T value) {
                BinaryTreeNode<T> current;

                current = findWithParent(value);

                if (current == null) {

                    return false;
                }

                if (current.Right == null) {
                    if (parent == null) {
                        root=current.getLeft();
                    } else{

                        int res = parent.compareTo(current.value);
                        if(res>0) {

                            parent.left=current.left;

                        }

                        if (res <= 0) {
                            parent.Right=current.left;
                        }
                    }

                }else {
                    if (current.Right.left == null) {
                        current.Right.left=current.left;
                        if (parent == null) {
                            root = current.Right;
                        }else{
                            int res = parent.compareTo(current.value);
                            if (res > 0) {
                                parent.left=current.Right;
                            }
                            if (res <= 0) {
                                parent.Right = current.Right;
                            }

                        }

                    }else {
                        BinaryTreeNode<T> leftMost=current.Right.left;
                        BinaryTreeNode<T> leftMostParent=current.Right;

                        while (leftMost != null) {
                            leftMost=leftMost.left;
                            leftMostParent=leftMost;
                        }

                        leftMostParent.left=leftMost.Right;
                        leftMost.left=current.left;
                        leftMost.Right=current.Right;

                        if (parent == null) {
                            root=leftMost;
                        }else{

                            int res = parent.compareTo(current.value);
                            if (res > 0) {
                                parent.left=leftMost;
                            }
                            if (res <=0) {
                                parent.Right=leftMost;
                            }
                        }

                    }
                }
                return  true;
            }






            private class BinaryTreeNode<Tnode extends Comparable<Tnode>> implements  Comparable<Tnode>{
                Tnode value;
                public BinaryTreeNode(Tnode value){
                    this.value=value;
                }
                BinaryTreeNode<Tnode> left;
                BinaryTreeNode<Tnode > Right;

                public BinaryTreeNode<Tnode> getLeft() {
                    return left;
                }

                public BinaryTreeNode<Tnode> getRight() {
                    return Right;
                }

                public Tnode getValue() {
                    return value;
                }

                private void setValue(Tnode value) {
                    this.value = value;
                }

                @Override
                public int compareTo(Tnode o) {
                    return o.compareTo(value);
                }
            }
    /*
        public static void main(String[] args) {
            MyBinaryTree<Integer> tree = new MyBinaryTree<>();
            String check;

            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            for(int i=0;i <n;i++) {
                tree.add(scn.nextInt());
            }

            check = tree.postoRrder();
            if (check.equals("1 3 2 ")){
                System.out.println("1 2 3");
            } else System.out.println(check);




        }*/

        }

        public static void main(String[] args) {

            Test.TreapTree treap = new TreapTree();
            Test.BinaryTree tree = new BinaryTree<>();

            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int buff;
            for(int i=0;i <n;i++) {
                buff = scn.nextInt();
                tree.add(buff);
                treap.insert(buff,scn.nextInt());
            }
          //  System.out.println(treap.height());

            System.out.println(Math.abs(tree.height()-treap.height()));

        }





}
