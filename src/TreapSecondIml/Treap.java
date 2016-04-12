package TreapSecondIml;

import java.util.Random;

/**
 * Created by Alexandr on 27.01.2016.
 */

    /**
     * TreapSecondIml.Treap.Treap。参照：<AA href="http://ja.wikipedia.org/wiki/Treap">http://ja.wikipedia.org/wiki/Treap</AA>
     * <p/>
     * {@link java.util.TreeSet} に合わせている
     */
     class Treap<T extends Comparable> {
        private static final Random rand = new Random();
        private Node<T> root;
        public  int priority;

        public void add(T data, int priority) {
            root = add(root, data,priority);
        }


        public int height() {
            return height(root);
        }

        private int height(Node<T> node) {
            if(node == null) return 0;
            return 1 + Math.max(height(node.left), height(node.right));
        }

        private Node<T> add(Node<T> node, T data, int priority) {
            if (node == null)
                return new Node<T>(data,priority);

            int compare = data.compareTo(node.data);
            if (compare < 0) {
                node.left = add(node.left, data,priority);
                if (node.priority > node.left.priority)
                    return rotateRight(node);
            } else if (compare > 0) {
                node.right = add(node.right, data,priority);
                if (node.priority > node.right.priority)
                    return rotateLeft(node);
            }
            return node;
        }

        private Node<T> rotateRight(Node<T> node) {
            Node<T> lnode = node.left;
            node.left = lnode.right;
            lnode.right = node;
            return lnode;
        }

        private Node<T> rotateLeft(Node<T> node) {
            Node<T> rnode = node.right;
            node.right = rnode.left;
            rnode.left = node;
            return rnode;
        }

        public void remove(T data) {
            root = remove(root, data);
        }

        private Node<T> remove(Node<T> node, T data) {
            if (node != null) {
                int compare = data.compareTo(node.data);
                if (compare < 0) {
                    node.left = remove(node.left, data);
                } else if (compare > 0) {
                    node.right = remove(node.right, data);
                } else {
                    if (node.left == null) {
                        return node.right;
                    } else if (node.right == null) {
                        return node.left;
                    } else {
                        node.data = first(node.right);
                        node.right = remove(node.right, node.data);
                    }
                }
            }
            return node;
        }

        public boolean contains(T data) {
            Node<T> node = root;
            while (node != null) {
                int compare = data.compareTo(node.data);
                if (compare < 0) node = node.left;
                else if (compare > 0) node = node.right;
                else return true;
            }
            return false;
        }

        public T first() {
            return first(root);
        }

        private T first(Node<T> searchNode) {
            Node<T> node = searchNode;
            while (node.left != null) node = node.left;
            return node.data;
        }

        @Override
        public String toString() {
            return "TreapSecondIml.Treap.Treap{" +
                    "root=" + root +
                    '}';
        }

        private static class Node<T extends Comparable> {
            public Node<T> right, left;
            public  int priority;
            public T data;

            public Node(T data,int priority) {
                this.data = data;
                this.priority=priority;
            }

            @Override
            public String toString() {
                return "InternalNode{" +
                        "item=" + data +
                        ", priority=" + priority +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
        }
    }

