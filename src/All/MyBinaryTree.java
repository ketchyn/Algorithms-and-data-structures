package All;

/**
 * Created by Alexandr on 03.01.2016.
 */
public class MyBinaryTree<T extends Comparable<T>> {

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
     private  BinaryTreeNode parent=null;
    public boolean contains(T value) {

        return findWithParent(value)!=null;
    }


    private BinaryTreeNode findWithParent( T value) {
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
