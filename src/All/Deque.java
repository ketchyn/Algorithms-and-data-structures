package All;

import java.util.Arrays;

/**
 * Created by Alexandr on 19.12.2015.
 */
public class Deque<T> {
    int  head=0;
    int  tail=0;
    int buffsize = 10;
    T[] buff;
    public Deque(){
        this(10);
    }
private Deque(int size){
    buff = (T[]) new Object[size];
}
    private void resizeBack(){
        T[] newMass = (T[]) new Object[buff.length+buffsize];
        int lIndex = head;
        int rIndex = newMass.length-buff.length+head;
        int length = buff.length-lIndex;
        System.arraycopy(buff,0,newMass,0,lIndex);
        System.arraycopy(buff,lIndex,newMass,rIndex,length);
        buff = newMass;
        tail = lIndex;
        head = rIndex;
        buff = newMass;
    }
    private void resizeFront(){
        T[] newMass = (T[]) new Object[buff.length+buffsize];
        int lIndex = tail;
        int rIndex = newMass.length-((buff.length)-lIndex);
        int length = buff.length-lIndex;
        System.arraycopy(buff, 0, newMass, 0, lIndex);
        System.arraycopy(buff, lIndex, newMass, rIndex, length);
        buff = newMass;
        tail = lIndex;
        head = rIndex;
        buff = newMass;
        buff = (T[])newMass;
    }
    public void pushBack(T item){

        if ((tail + 1) % buff.length != head) {

            buff[tail] = item;
            tail = (tail + 1) % buff.length;

        } else {
            buff[tail] = item;
            resizeBack();
        }
    }
    public T  popFront(){
        if( head !=tail) {
            T result = buff[head];
          buff[head]=null;
            head = (head+1)%buff.length;
            return result;
        }
       return null;
    }


    public void pushFront(T item){
        if(head==0){
            if((buff.length-1)!=tail){
            buff[buff.length-1]= item;
                head = buff.length-1;
            }else {
                buff[buff.length-1]=item;
                resizeFront();
            }
        }
        if((head-1)!=tail) {
            buff[head-1]=item;
            head = (head-1);
        } else {
            buff[head-1]=item;
            resizeFront();
        }
    }

    public T  popBack(){
        if( head !=tail) {
            if(tail == 0){ return buff[buff.length-1];
            }else {
                T result = buff[tail - 1];
                buff[tail - 1] = null;
              tail = tail-1;
                return result;
            }
        }
        return null;
    }





    public static void main(String[] args) {
        Deque<Integer> ex = new Deque<>();
        ex.pushBack(4);
        ex.pushBack(5);
        ex.pushBack(6);
        ex.pushBack(7);
        ex.pushBack(8);
        System.out.println(Arrays.toString(ex.buff));

        System.out.println( (Object)ex.buff.length);












    }
}
