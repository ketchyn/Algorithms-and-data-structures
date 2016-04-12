package All;

/**
 * Created by Alexandr on 28.03.2016.
 */
public class QueueArray<T> {
    private T[] arr;

    private int total, first, next;

    public QueueArray() {
        arr = (T[]) new Object[2];
    }

    private void resize(int capacity) {
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0; i < total; i++) {
            int index = ((first + i) % arr.length);
            tmp[i] = arr[index];
        }

        arr = tmp;
        first = 0;
        next = total;
    }

    public QueueArray<T> enqueue(T ele) {
        if (arr.length == total) resize(arr.length * 2);
        arr[next++] = ele;
        if (next == arr.length) next = 0;
        total++;
        return this;
    }

    public T dequeue() {
        if (total == 0) throw new java.util.NoSuchElementException();
        T ele = arr[first];
        arr[first] = null;
        if (++first == arr.length) first = 0;
        if (--total > 0 && total == arr.length / 4) resize(arr.length / 2);
        return ele;
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(arr);
    }

    public static void main(String[] args) {
        QueueArray<Integer> a = new QueueArray();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(8);
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
    }
}
