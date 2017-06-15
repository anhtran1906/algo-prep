
/**
 * Created by anhtran on 5/24/17.
 */
import java.util.Scanner;
public class BearAndGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+2];
        for (int i = 1; i < arr.length-1; i++) {
            arr[i] = sc.nextInt();
        }
        arr[0] = 0;
        arr[arr.length-1] = 90;
        System.out.println(arr);

        if (n == 1) {
            if (arr[0] > 15) {
                System.out.println(15);
            } else {
                System.out.println(arr[0]);
            }
        }
        else {
            for (int i = 1; i < n-1; i++) {
               if(arr[i] - arr[i-1] < 15 ) {
                   System.out.println(arr[i] + 15);
               }
            }
            System.out.println(90);

        }
    }
}
