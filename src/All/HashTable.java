package All;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alexandr on 28.12.2015.
 */
public class HashTable<Tkey,Tvalue> {
    List<Tkey> buff = new LinkedList<>();

    private class heshItem<T,V>{

        T key;
        V value;
        public V getValue() {
            return value;
        }

        public T getKey() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            heshItem<?, ?> heshItem = (heshItem<?, ?>) o;

            if (!key.equals(heshItem.key)) return false;
            return value.equals(heshItem.value);

        }

        @Override
        public int hashCode() {
            int result = key.hashCode();
            result = 31 * result + value.hashCode();
            return result;
        }



        @Override
        public String toString() {
            return "heshItem{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public heshItem(T key, V value) {
            this.key = key;
            this.value = value;



        }


    }

    private int loadfactor(){
        return size/capasity;
    }

    private  void resize(){
        LinkedList<heshItem<Tkey,Tvalue>>[] oldArr=mass;
        size = 0;
        mass = new LinkedList[capasity*2];
        capasity=capasity*2;
        for( LinkedList<heshItem<Tkey,Tvalue>> i:oldArr ){
            if (i!=null){
              for(heshItem<Tkey,Tvalue> j:i){
                  if (j!=null) {
                      this.add(j.getKey(), j.getValue());
                  }
              }
            }
        }
    }

    private LinkedList<heshItem<Tkey,Tvalue>>[] mass;
    private  int capasity;
    private int size;

    public HashTable(int capasity ) {
        this.capasity= capasity;
        mass = (LinkedList<heshItem<Tkey, Tvalue>>[]) new  LinkedList [capasity];
    }
        private int hash(Tkey key ){
        return Math.abs(key.hashCode())%capasity;
    }
    private  boolean containKey(LinkedList<heshItem<Tkey,Tvalue>>list, Tkey key ) {
        Iterator<heshItem<Tkey,Tvalue>> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next().getKey().equals(key)) return true;

        }
        return false;

    }


    public void add(Tkey key, Tvalue value){
        int index = hash(key);
        heshItem<Tkey, Tvalue> heshItem = new heshItem<Tkey, Tvalue>(key, value);
        if (mass[index]==null) {mass[index] = new LinkedList<heshItem<Tkey, Tvalue>>();
        mass[index].add(heshItem);}

        else if(!containKey(mass[index],key)){
            mass[index].add(heshItem);

        size++;
        }
        else throw new IllegalArgumentException("Such key allready exists");



        if(loadfactor()>0.75){
            resize();
        }
    }

    public Tvalue get(Tkey key) {
        int index = hash(key);
               if (mass[index]==null){
                   return null;
               }
        for(heshItem<Tkey,Tvalue> i:mass[index]){
            if (i.getKey().equals(key)) {
                return i.getValue();
            }
        }
        return null;
    }

    public boolean remove(Tkey key){
     int index = hash(key);
        if (mass[index]==null) return false;
        Iterator iter  = mass[index].iterator();
        for( heshItem<Tkey,Tvalue> i:mass[index]){
            if(i.getKey().equals(key)){
                mass[index]=null;
                return true;
            }

        }

        return  false;

        }

    @Override
    public String toString() {
        return "HashTable{" +
                "mass=" + Arrays.toString(mass) +

                '}';
    }


    public static void main(String[] args) {
        HashTable<Integer, String> ex = new HashTable<>(10);
        ex.add(1,"AA");
        ex.add(2,"b");
        ex.add(2,"c");
        ex.add(4,"d");
        ex.add(5,"DD");
        ex.add(6,"Cd");
        ex.add(7,"Cd");
       ex.add(8,"q");

       // ex.add(5,"q");
        System.out.println(ex.toString());
        System.out.println(ex.get(5));
        System.out.println(ex.get(6));
        System.out.println(ex.get(7));


        //System.out.println(ex.toString());
    }

}





