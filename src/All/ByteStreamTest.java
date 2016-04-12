package All;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alexandr on 04.02.2016.
 */
public class ByteStreamTest {
    public static void main(String args[])throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        int c=0;
        char character;
        do {
            character = (char) input.read();
            System.out.print(character + "  ");
        } while (character != 'q');


/*        int c;

        ByteArrayInputStream bInput = new ByteArrayInputStream(b);

        System.out.println("Converting characters to Upper case " );
        for(int y = 0 ; y < 1; y++ ) {
            while(( c= bInput.read())!= -1) {
                System.out.println(Character.toUpperCase((char)c));
            }
            bInput.reset();+
        }*/
    }
}

