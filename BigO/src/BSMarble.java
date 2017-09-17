import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 7/1/17.
 */
public class BSMarble {
    public static int BS_first (int[] arr, int start, int end, int x){
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
            return mid;
        } else if (x > arr[mid]) {
            return BS_first(arr, mid + 1, end, x);
        } else {
            return BS_first(arr, start, mid - 1, x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int j = 1;
        while(n != 0 && q!= 0){
            int[] arr = new int[n];
            int i = 0;
            while(n > 0){
                arr[i] = sc.nextInt();
                i++;
                n--;
            }
            Arrays.sort(arr);
            System.out.println("CASE# " + j + ":");
            while(q > 0){
                int x = sc.nextInt();
                int result = BS_first(arr,0,arr.length,x);
                if (result != -1) {
                    result +=1;
                    System.out.println(x + " found at " + result);
                }
                else {
                    System.out.println(x + " not found");
                }
                q--;
            }
            j++;
            n = sc.nextInt();
            q = sc.nextInt();
        }
    }
}
