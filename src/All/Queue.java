package All;

/**
 * Created by Alexandr on 18.12.2015.
 */
public class Queue<T> {
   private Node tail ;
    private  Node head;
    public Queue(){
        head=tail=null;
    }


    private class Node {
        Node next;
        T data;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

        public void enqueue(T item){
            if (tail==null){
                head =  tail = new Node (item,null);

            }else {
                tail.next =  new Node (item,null);
                tail=tail.next;
            }
        }
        public T dequeue(){

            T result = head.data;
            head = head.next;
            return result;
        }
    public static void main(String[] args) {
        Queue<Integer> ex = new Queue<>();
        ex.enqueue(5);
        ex.enqueue(7);
        ex.enqueue(8);
        ex.enqueue(9);
        System.out.println(ex.dequeue());
        System.out.println(ex.dequeue());
        System.out.println(ex.dequeue());
        System.out.println(ex.dequeue());
    }

}



