package All;

/**
 * Created by Alexandr on 26.03.2016.
 */
public class newStackImpl<T> {


    private int total;

    private Node first;

    private class Node {
        private T ele;
        private Node next;
    }

    public newStackImpl() { }

    public newStackImpl<T> push(T ele)
    {
        Node current = first;
        first = new Node();
        first.ele = ele;
        first.next = current;
        total++;
        return this;
    }

    public T pop()
    {
        if (first == null) new java.util.NoSuchElementException();
        T ele = first.ele;
        first = first.next;
        total--;
        return ele;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            sb.append(tmp.ele).append(", ");
            tmp = tmp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        newStackImpl<Integer> a = new newStackImpl<>();
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);

        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}
