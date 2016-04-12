package All;

/**
 * Created by Alexandr on 18.12.2015.
 */
public class Dynemiclist<T> {
    public T[] data;
    private int count = 0;

    public Dynemiclist() {
        this(4);
    }

    private Dynemiclist(int size) {
        //data = new T[size]
       data = (T[]) new Object[size];
        count = 0;
    }
    private void resize(){
        int capacity = data.length==0? 4:data.length*2;
        T[] newArr = (T[]) new Object[capacity];
        System.arraycopy(data,0,newArr,0,data.length);
        data = newArr;
    }
    public boolean isFull(){
        return data.length == count;
    }

    public void add(T value){
        if (isFull() == true){
            resize();
        }
        data[count++] = value;
    }
    public T get(int index){
        return data[index];
    }

public void insert (T item, int index){
    if (index > count) return;
    if (isFull() == true){
        resize();
    }
    System.arraycopy(data,index,data,index+1,count-index);
    data[index]= item;
    count++;
}

    public void deleteAt(int index){
        int start = index+1;
        if (start<count){
            System.arraycopy(data,start,data,index,count-start);
            data[count] =null;
            count--;
        }
    }
     public String toString(){
         String A = "";
        for (int i = 0; i<=count-1; i++){
           A+=  i + " "+ data[i]+ " ";
        }
         return A;
    }

    public static void main(String[] args) {
        Dynemiclist<Integer> mass = new Dynemiclist<>();
        mass.add(5);
        mass.add(10);
        mass.add(11);
        mass.add(14);
        mass.add(16);
        mass.insert(15,3);
        System.out.println(mass.toString());
       mass.deleteAt(3);
        System.out.println(mass.toString());


    }

}




