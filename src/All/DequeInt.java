package All;

import java.util.Scanner;

/**
 * Created by Alexandr on 21.12.2015.
 */
public class DequeInt {



    int  head=0;
    int  tail=0;
    int buffsize = 10;
    Integer[] buff;
    public DequeInt(){
        this(10);
    }


    private DequeInt(int size){
        buff = new Integer[size];
    }




    private void resizeBack(){
        Integer[] newMass =  new  Integer[buff.length+buffsize];
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
        Integer[] newMass = new  Integer[buff.length+buffsize];
        int lIndex = 0;
        if (tail!=0){ lIndex = tail;} else lIndex=1;
        int rlength = buff.length-head;

        int rIndex = newMass.length-rlength;

        System.arraycopy(buff,0,newMass,0,lIndex);
        System.arraycopy(buff,head,newMass,rIndex,rlength);
        buff = newMass;
        tail = lIndex;
        head = rIndex;
        buff = newMass;
        buff = newMass;
    }
    public void pushBack( Integer item){


        if (buff[tail]==null) {
            if((tail+1)%buff.length!=head) {
                buff[tail]=item;
                tail = (tail+1)%buff.length;
            } else {
                buff[tail]=item;
                resizeBack();
            }
        } else {

            if((tail+1)%buff.length!=head) {
                buff[tail+1]=item;
                tail = (tail+2)%buff.length;
            } else {
                resizeBack();
                buff[tail]=item;
                tail = tail+1;
            }

        }
    }
    public  Integer  popFront(){
        Integer result = null;
        if( head !=tail) {
            result = buff[head];
            buff[head]=null;
            head = (head+1)%buff.length;
            return result;
        }
         if (buff[head]!=null){
             result = buff[head];
             buff[head] = null;
             if (head!=tail) head = head+1;
             }else result=-1;
        return result;


    }


    public void pushFront( Integer item){
        if(head==0&&buff[head]!=null){
            if((buff.length-1)!=tail){
                buff[buff.length-1]= item;
                head = buff.length-1;
            }else {
                buff[buff.length-1]=item;
                resizeFront();
            }
        } else if  (head==0&&buff[head]==null){
            buff[head]=item;

        } else {
            if ((head - 1) != tail) {
                buff[head - 1] = item;
                head = (head - 1);
            } else {
                resizeFront();

                buff[head - 1] = item;
                head = head -1;
            }
        }
    }

    public  Integer  popBack(){
        Integer result =-1;
        if( head !=tail) {
            if(tail == 0){
                tail= buff.length-1;
                result =  buff[buff.length-1];
                buff[buff.length-1] = null;

            }else {
                result = buff[tail - 1];
                buff[tail - 1] = null;
                tail = tail-1;
                return result;
            }
        }
        return result;


    }

    public boolean arrEquals( Integer[][] a ,Integer[][] b) {
        boolean result = false;
        for(int i =0; i<a.length;i++){
            for(int j = 0; j< 2;j++){
                if(a[i][j].compareTo(b[i][j])==0) result = true;
                else return false;
            }

        }
        return result;
    }
    public boolean isEmpty(){
        if (buff[head] == null) return true;
        else return false;
    }




    public static void main(String[] args) {

        DequeInt ex = new DequeInt();

        //1 5, 1 10, 2 5
       /*       AA = 1 - push front,
                AA = 2 - pop front,
                AA = 3 - push back,
                AA = 4 - pop back.*/
/*
        ex.pushFront(5);
        ex.pushBack(3);
        ex.pushFront(6);
        ex.pushBack(4);
        ex.pushFront(7);
        ex.pushBack(8);
        System.out.println(Arrays.toString(ex.buff));
        System.out.println("head "+ ex.head );
        System.out.println(("tail "+ex.tail));
        System.out.println(ex.popFront());
        System.out.println(ex.popBack());
        System.out.println(ex.popFront());
        System.out.println(ex.popBack());
        System.out.println(ex.popFront());
        System.out.println(ex.popBack());
        System.out.println(ex.popBack());*/










   Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Integer[][] buff = new Integer [n][2];
        Integer[][] result = new Integer [n][2];

        for(int i = 0; i<buff.length; i++){
            for (int j = 0;j<2; j++){
               buff[i][j]=scn.nextInt();
            }
            }

/*       AA = 1 - push front,
                AA = 2 - pop front,
                AA = 3 - push back,
                AA = 4 - pop back.*/
        for(int i = 0; i<result.length; i++){
          if(buff[i][0]==1){
             ex.pushFront(buff[i][1]);
              result[i][0]=1;
              result[i][1]=buff[i][1];
          }

            if(buff[i][0]==2){
              result[i][0]=2;
              result[i][1]=ex.popFront();

            }
            if(buff[i][0]==3){
                ex.pushBack(buff[i][1]);
                result[i][0]=3;
                result[i][1]=buff[i][1];

            }

            if(buff[i][0]==4){
                result[i][0]=4;
                result[i][1]=ex.popBack();
            }

        }


        try {
            if (ex.arrEquals(result, buff) == true) {
                System.out.println("YES");


            } else System.out.println("NO");
        } catch (Exception e) {
            throw new RuntimeException(result.toString());
        }


    }


    }

