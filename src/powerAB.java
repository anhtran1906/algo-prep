import java.util.Scanner;

/**
 * Created by anhtran on 9/19/17.
 */
public class powerAB {
    public static long power(int a, int b){
        if(b == 1){
            return a;
        }
        if(b == 0){
            return 1;
        }
        long half = power(a,b/2);
        if(b%2 == 0){
            return half*half;
        }
        else {
            return a*half*half;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(power(a,b));

    }

}
