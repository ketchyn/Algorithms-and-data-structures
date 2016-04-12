package All;

/**
 * Created by Alexandr on 18.12.2015.
 */
public class Stack<T> {

    private class node{
         T data;
         node next;
        public node (T data, node next){
            this.data = data;
            this.next = next;
        }

    }

    private node top = null;
    private int count = 0;

    public void push(T item){
        top = new node (item,top);
        count++;
    }
    public T pop (){
        T result = top.data;
        top = top.next;
        count --;
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> ex = new Stack<>();
        ex.push(5);
        ex.push(6);
        ex.push(7);
        ex.push(10);

        System.out.println(ex.pop());
        System.out.println(ex.pop());
        System.out.println(ex.pop());
        System.out.println(ex.pop());
        System.out.println(ex.pop());
    }

}
