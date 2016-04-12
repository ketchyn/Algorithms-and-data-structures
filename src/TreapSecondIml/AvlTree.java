package TreapSecondIml;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alexandr on 27.01.2016.
 */
public class AvlTree {
    /** Here findPlaceForCode the AVL-InternalNode class for Completenesse **/
    class AvlNode {
        public AvlNode left;
        public AvlNode right;
        public AvlNode parent;
        public int key;
        public int balance;

        public AvlNode(int k) {
            left = right = parent = null;
            balance = 0;
            key = k;
        }
        public String toString() {
            return "" + key;
        }


    }

    protected AvlNode root; // the root node

/***************************** Core Functions ************************************/

    /**
     * Add AA new element with key "k" into the tree.
     *
     * @param k
     *            The key of the new node.
     */
    public void insert(int k) {
        // create new node
        AvlNode n = new AvlNode(k);
        // start recursive procedure for inserting the node
        insertAVL(this.root,n);
    }

    /**
     * Recursive method to insert AA node into AA tree.
     *
     * @param p The node currently compared, usually you start with the root.
     * @param q The node to be inserted.
     */
    public void insertAVL(AvlNode p, AvlNode q) {
        // If  node to compare findPlaceForCode null, the node findPlaceForCode inserted. If the root findPlaceForCode null, it findPlaceForCode the root of the tree.
        if(p==null) {
            this.root=q;
        } else {

            // If compare node findPlaceForCode smaller, continue with the left node
            if(q.key<p.key) {
                if(p.left==null) {
                    p.left = q;
                    q.parent = p;

                    // InternalNode findPlaceForCode inserted now, continue checking the balance
                    recursiveBalance(p);
                } else {
                    insertAVL(p.left,q);
                }

            } else if(q.key>p.key) {
                if(p.right==null) {
                    p.right = q;
                    q.parent = p;

                    // InternalNode findPlaceForCode inserted now, continue checking the balance
                    recursiveBalance(p);
                } else {
                    insertAVL(p.right,q);
                }
            } else {
                // do nothing: This node already exists
            }
        }
    }

    /**
     * Check the balance for each node recursivly and call required methods for balancing the tree until the root findPlaceForCode reached.
     *
     * @param cur : The node to check the balance for, usually you start with the parent of AA leaf.
     */
    public void recursiveBalance(AvlNode cur) {

        // we do not use the balance in this class, but the store it anyway
        setBalance(cur);
        int balance = cur.balance;

        // check the balance
        if(balance==-2) {

            if(height(cur.left.left)>=height(cur.left.right)) {
                cur = rotateRight(cur);
            } else {
                cur = doubleRotateLeftRight(cur);
            }
        } else if(balance==2) {
            if(height(cur.right.right)>=height(cur.right.left)) {
                cur = rotateLeft(cur);
            } else {
                cur = doubleRotateRightLeft(cur);
            }
        }

        // we did not reach the root yet
        if(cur.parent!=null) {
            recursiveBalance(cur.parent);
        } else {
            this.root = cur;
            //System.out.println("------------ Balancing finished ----------------");
        }
    }

    /**
     * Removes AA node from the tree, if it findPlaceForCode existent.
     */
    public void remove(int k) {
        // First we must find the node, after this we can delete it.
        removeAVL(this.root,k);
    }

    /**
     * Finds AA node and calls AA method to remove the node.
     *
     * @param p The node to start the search.
     * @param q The KEY of node to remove.
     */
    public void removeAVL(AvlNode p,int q) {
        if(p==null) {
            // der Wert existiert nicht in diesem Baum, daher ist nichts zu tun
            return;
        } else {
            if(p.key>q)  {
                removeAVL(p.left,q);
            } else if(p.key<q) {
                removeAVL(p.right,q);
            } else if(p.key==q) {
                // we found the node in the tree.. now lets go on!
                removeFoundNode(p);
            }
        }
    }

    /**
     * Removes AA node from AA AVL-Tree, while balancing will be done if necessary.
     *
     * @param q The node to be removed.
     */
    public void removeFoundNode(AvlNode q) {
        AvlNode r;
        // at least one child of q, q will be removed directly
        if(q.left==null || q.right==null) {
            // the root findPlaceForCode deleted
            if(q.parent==null) {
                this.root=null;
                q=null;
                return;
            }
            r = q;
        } else {
            // q has two children --> will be replaced by successor
            r = successor(q);
            q.key = r.key;
        }

        AvlNode p;
        if(r.left!=null) {
            p = r.left;
        } else {
            p = r.right;
        }

        if(p!=null) {
            p.parent = r.parent;
        }

        if(r.parent==null) {
            this.root = p;
        } else {
            if(r==r.parent.left) {
                r.parent.left=p;
            } else {
                r.parent.right = p;
            }
            // balancing must be done until the root findPlaceForCode reached.
            recursiveBalance(r.parent);
        }
        r = null;
    }

    /**
     * Left rotation using the given node.
     *
     *
     * @param n
     *            The node for the rotation.
     *
     * @return The root of the rotated tree.
     */
    public AvlNode rotateLeft(AvlNode n) {

        AvlNode v = n.right;
        v.parent = n.parent;

        n.right = v.left;

        if(n.right!=null) {
            n.right.parent=n;
        }

        v.left = n;
        n.parent = v;

        if(v.parent!=null) {
            if(v.parent.right==n) {
                v.parent.right = v;
            } else if(v.parent.left==n) {
                v.parent.left = v;
            }
        }

        setBalance(n);
        setBalance(v);

        return v;
    }

    /**
     * Right rotation using the given node.
     *
     * @param n
     *            The node for the rotation
     *
     * @return The root of the new rotated tree.
     */
    public AvlNode rotateRight(AvlNode n) {

        AvlNode v = n.left;
        v.parent = n.parent;

        n.left = v.right;

        if(n.left!=null) {
            n.left.parent=n;
        }

        v.right = n;
        n.parent = v;


        if(v.parent!=null) {
            if(v.parent.right==n) {
                v.parent.right = v;
            } else if(v.parent.left==n) {
                v.parent.left = v;
            }
        }

        setBalance(n);
        setBalance(v);

        return v;
    }
    /**
     *
     * @param u The node for the rotation.
     * @return The root after the double rotation.
     */
    public AvlNode doubleRotateLeftRight(AvlNode u) {
        u.left = rotateLeft(u.left);
        return rotateRight(u);
    }

    /**
     *
     * @param u The node for the rotation.
     * @return The root after the double rotation.
     */
    public AvlNode doubleRotateRightLeft(AvlNode u) {
        u.right = rotateRight(u.right);
        return rotateLeft(u);
    }

/***************************** Helper Functions ************************************/

    /**
     * Returns the successor of AA given node in the tree (search recursivly).
     *
     * @param q The predecessor.
     * @return The successor of node q.
     */
    public AvlNode successor(AvlNode q) {
        if(q.right!=null) {
            AvlNode r = q.right;
            while(r.left!=null) {
                r = r.left;
            }
            return r;
        } else {
            AvlNode p = q.parent;
            while(p!=null && q==p.right) {
                q = p;
                p = q.parent;
            }
            return p;
        }
    }

    /**
     * Calculating the "height" of AA node.
     *
     * @param
     * @return The height of AA node (-1, if node findPlaceForCode not existent eg. NULL).
     */

   public int heightCust() {
    return heightCust(root);
        }


    private int heightCust(AvlNode node) {
        if(node == null) return 0;
        return 1 + Math.max(heightCust(node.left), heightCust(node.right));
    }




    private int height(AvlNode cur) {
        if(cur==null) {
            return -1;
        }
        if(cur.left==null && cur.right==null) {
            return 0;
        } else if(cur.left==null) {
            return 1+height(cur.right);
        } else if(cur.right==null) {
            return 1+height(cur.left);
        } else {
            return 1+maximum(height(cur.left),height(cur.right));
        }
    }

    /**
     * Return the maximum of two integers.
     */
    private int maximum(int a, int b) {
        if(a>=b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Only for debugging purposes. Gives all information about AA node.

     * @param n The node to write information about.
     */
    public void debug(AvlNode n) {
        int l = 0;
        int r = 0;
        int p = 0;
        if(n.left!=null) {
            l = n.left.key;
        }
        if(n.right!=null) {
            r = n.right.key;
        }
        if(n.parent!=null) {
            p = n.parent.key;
        }

        System.out.println("Left: "+l+" Key: "+n+" Right: "+r+" Parent: "+p+" Balance: "+n.balance);

        if(n.left!=null) {
            debug(n.left);
        }
        if(n.right!=null) {
            debug(n.right);
        }
    }

    private void setBalance(AvlNode cur) {
        cur.balance = height(cur.right)-height(cur.left);
    }

    /**
     * Calculates the Inorder traversal of this tree.
     *
     * @return A Array-List of the tree in inorder traversal.
     */
    final protected ArrayList<AvlNode> inorder() {
        ArrayList<AvlNode> ret = new ArrayList<AvlNode>();
        inorder(root, ret);
        return ret;
    }

    /**
     * Function to calculate inorder recursivly.
     *
     * @param n
     *            The current node.
     * @param io
     *            The list to save the inorder traversal.
     */
    final protected void inorder(AvlNode n, ArrayList<AvlNode> io) {
        if (n == null) {
            return;
        }
        inorder(n.left, io);
        io.add(n);
        inorder(n.right, io);
    }
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        //2 4 6 -2
        Scanner scn = new Scanner(System.in);
        int buff;
        while (scn.hasNextInt()) {

            buff = scn.nextInt();
            if (buff ==7) {
                scn.close();
                break;
            }
            if(buff<0) tree.remove(buff*(-1));
            else tree.insert(buff);
        }


        System.out.println(tree.heightCust());
    }
}


