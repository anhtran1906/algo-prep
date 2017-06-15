import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 6/7/17.
 */
public class PashaAndTea {

    private static float getMaxWater(int[] cups, int n, int w) {
        Arrays.sort(cups);
        float capGirl = cups[0];
        float capBoy = cups[n];
        float sum = 0;

        float ratio = capBoy/capGirl;

        if(ratio >= 2) {
            sum = capGirl*n + capGirl*2*n;
        }
        else {
            sum = capBoy*n + (capBoy/2)*n;
        }

        return sum>w? w: sum;

    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] cups = new int[2*n];
        for(int i = 0; i < cups.length; i++){
            cups[i] = sc.nextInt();
        }

        System.out.println(getMaxWater(cups,n,w));

    }
}
