import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 5/31/17.
 */
public class SortTheArrayB {
//
//    find the first position that the array starts decreasing from start: L
//    find the first position that the array starts increasing from end: R
//
//    swap this segment [L,R] => resulted segment


//    public static int[] findLeftRight (int[] arr, int n) {
//        int left = 0;
//        int right = n-1;
//
//        while(left < n-1 && right >= 1) {
//            if(arr[left] < arr[left+1]){
//                left =  left+1;
//            }
//            else if(arr[left] >= arr[left+1]) {
//                left++;
//            }
//            if(arr[right] > arr[right-1]) {
//                right = right -1;
//            }
//            if(arr[right] <= arr[right-1]) {
//                right--;
//            }
//
//        }
//        int[] res = new int[2];
//        res[0] = left+1;
//        res[1] = right+1;
//        return res;
//    }

//    public static int[] findLeftRight (int[] arr, int n) {
//        int[] question =
//        int left;
//        int right;
//
////        have a temp array to whole the sorted list;
////        go through each elem in each arr; find the first left diff pos and first right diff pos; swap elems at left and right and comapre a
//
//        while(left < right) {
//            int temp = arr[left];
//            arr[left]= arr[right];
//            arr[right] = temp;
//        }
//    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        for(int i: findLeftRight(arr,n)) {
//            System.out.println(i);
//        }
    }
}
