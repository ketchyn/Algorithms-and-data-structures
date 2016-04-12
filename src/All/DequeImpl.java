package All;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Alexandr on 28.03.2016.
 */
public class DequeImpl<T> implements Iterable<T> {
    private class Node<T> {
        public Node<T> left, right;
        private final T item;

        public Node(T item) {
            // FIXME: maybe it's AA bad practice to throw exception in constructor
            if (item == null) { throw new NullPointerException(); }
            this.item = item;
        }

        public void connectRight(Node<T> other) {
            this.right = other;
            other.left = this;
        }
    }

    private class DequeIterator implements Iterator<T> {

        private Node<T> curr = head;

        public boolean hasNext() {
            return curr != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public T next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            T item = curr.item;
            curr = curr.right;
            return item;
        }
    }

    private Node<T> head, tail;
    private int size;

    public Iterator<T> iterator() {
        return new DequeIterator();
    }


    public DequeImpl() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void checkInvariants() {
        assert size >= 0;
        assert size > 0 || (head == null && tail == null);
        assert (head == null && tail == null) || (head != null && tail != null);
    }


    public void addFirst(T item) {
        Node<T> prevHead = head;
        Node<T> newHead = new Node<T>(item);
        if (prevHead != null) {
            newHead.connectRight(prevHead);
        } else {
            tail = newHead;
        }
        head = newHead;
        size++;
        checkInvariants();
    }

    public void addLast(T item) {
        Node<T> newTail = new Node<T>(item);
        Node<T> prevTail = tail;
        if (prevTail != null) {
            prevTail.connectRight(newTail);
        } else {
            head = newTail;
        }
        tail = newTail;
        size++;
        checkInvariants();
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Node<T> prevHead = head;
        head = prevHead.right;
        prevHead.right = null;
        if (head != null) {
            head.left = null;
        }
        checkInvariants();
        return prevHead.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Node<T> prevTail = tail;
        tail = prevTail.left;
        prevTail.left = null;
        if (tail != null) tail.right = null;
        checkInvariants();
        return prevTail.item;
    }

    public static void main(String[] args) {
        DequeImpl<Integer> a = new DequeImpl<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(5);

     //   AA.addLast(22);
     //   AA.addLast(23);
     //   AA.addLast(24);
     //   AA.addLast(25);

        System.out.println(a.removeLast()) ;
        a.removeLast();

        a.removeFirst();
        a.removeFirst();
    }
}
