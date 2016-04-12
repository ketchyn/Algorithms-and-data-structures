package TreapSecondIml;

/**
 * Created by Alexandr on 27.01.2016.
 */
import java.util.Scanner;
import java.util.Random;
public class Treap2 {

     static class TreapNode {
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
    static class TreapTree
    {
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


}

