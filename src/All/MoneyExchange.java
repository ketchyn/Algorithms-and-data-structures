package All;

/**
 * Created by Alexandr on 20.12.2015.
 */
public class MoneyExchange {

public static int change(int n,  int [] coinArray){
    int best = -1;
    if( n ==0 ){return 0;}


        for (int i = 0; i<coinArray.length;i++){

            if (coinArray[i]<=n) {
                int nextTry = change(n-coinArray[i],coinArray);
                if(best<0||best>nextTry+1){
                    best = nextTry+1;

                }

            }
        }
    return best;
   }

    public static void main(String[] args) {
        int[] coinArray =  {1,4,6,10};
        System.out.println(MoneyExchange.change(15,coinArray));

    }
}
