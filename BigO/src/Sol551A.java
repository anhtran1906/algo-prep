import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anhtran on 5/31/17.
 */
public class Sol551A {

//    public static int[] findRating (int[] arr) {
//
//    }

//    private static HashMap<Integer,Integer> findRating (int[] arr, int n) {
//        int count = 0;
//        int[] sorted = Arrays.copyOf(arr, n);
//        Arrays.sort(sorted);
//
//        HashMap<Integer,Integer> res = new HashMap<Integer,Integer>();
//        int[] freq = new int[2000+1];
//        for(int i = 0; i < n; i++) {
//            freq[arr[i]]++;
//            if(freq[arr[i]] == 1){
//                count++;
//            }
//        }
////        for (int i = n-1; i >= 0; i--){
////            int curVal = freq[arr[i]];
////            res.put()
////            count-=curVal;
////
////        }
//
//
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

    }
}
