package All;

/**
 * Created by Alexandr on 01.02.2016.
 */
public class ssiml implements ss {
    public static void main(String[] args) {
        char b = 0xbeef;
        char c = 064770;
        char d = '\uface';
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        try {
            int x = 0;
            int y = 5/x;
        }


        catch (Exception e) {
            System.out.println("Arifmetic exeption");
        }
        System.out.println("all fine");
    }

}
