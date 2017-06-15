import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

/**
 * Created by anhtran on 5/26/17.
 */
public class NicholasAndPermutation676A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        int min = MAX_VALUE;
        int minIn = 0;
        int maxIn = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIn = i;
            }
            if (arr[i] > max){
                max = arr[i];
                maxIn = i;
            }
        }

        //int curDis = Math.abs(maxIn - minIn);
        int maxDis = 0;
        if (maxIn <= minIn) {
            int dist1 = Math.abs(0 - minIn);
            int dist2 = Math.abs(maxIn - (n - 1));
            maxDis = Math.max(dist1, dist2);
        } else {
            int dist1 = Math.abs(0 - maxIn);
            int dist2 = Math.abs(minIn - (n - 1));
            maxDis = Math.max(dist1, dist2);
        }
        System.out.println(maxDis);
    }
}
