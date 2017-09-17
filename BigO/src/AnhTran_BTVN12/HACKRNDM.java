import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 7/4/17.
 */
public class HACKRNDM {
//    public static int countPairDiff(int[] arr, int start, int end, int k){
//        int count = 0;
//        if(arr[end] == arr[start] && k!= 0 ){
//            return count;
//        }
//        while (start < end && end < arr.length ){
//            if(arr[end]-arr[start] == k) {
//                count++;
//                start++;
//                end++;
//            }
//            else if(arr[end] - arr[start] > k) {
//                start++;
//            }
//            else {
//                end++;
//            }
//        }
//        return count;
//    }
//    private static int binarySearch(int[] arr, int start, int end, int diff){
//        if (start > end) {
//            return -1;
//        }
//        int mid = start + (end-start)/2;
//        if (arr[mid] == diff ) {
//            return mid;
//        }
//        else if(arr[mid] > diff) {
//            return binarySearch(arr,start, mid-1,diff);
//        }
//        else {
//            return binarySearch(arr,mid+1,end,diff);
//        }
//    }
//    private static int binarySearch(int[] arr, int start, int end, int diff){
//        while(start <= end) {
//            int mid = start+ (end-start)/2;
//            if(arr[mid] == diff) {
//                return mid;
//            }
//            else if(arr[mid] > diff) {
//                end = mid -1;
//            }
//            else {
//                start = mid+1;
//            }
//        }
//        return -1;
//    }
    public static int countPairDiff(int[]arr, int k){
        int count = 0;
        try {
            for(int i = 0; i < arr.length; i++) {
                if (Arrays.binarySearch(arr,i+1,arr.length,arr[i]+k)  >= 0){
                    count++;
                }
            }
            return count;
        }
        catch (IllegalArgumentException e) {
            return count;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(countPairDiff(arr, k));
    }
}