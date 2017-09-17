import java.util.Scanner;

/**
 * Created by anhtran on 9/13/17.
 */
public class lightOnOff {
    public static long countOn(double n){
        long x = 2;
        long count = 0;
        if(n == 1){
            return 1;
        }
        while(n >= 1){
            x = (long)Math.sqrt(n);
            System.out.println("x is" + x);
            if((x+1)*(x+1) <= n){
                x++;
            }
            if(x*x == n){
                count++;
            }
            n--;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        System.out.println(countOn(n));
    }
}
