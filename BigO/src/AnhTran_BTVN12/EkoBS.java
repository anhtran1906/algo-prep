import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 7/6/17.
 */
public class EkoBS {

    private static int binarySearchFirstLarger (long[] arr, int start, int end,long x){
        if (start > end) {
            return -1;
        }
        int mid = start + (end-start)/2;
        if ((mid==0 || arr[mid-1] <= x) && arr[mid] > x ) {
            return mid;
        }
        else if (arr[mid] > x) {
            return binarySearchFirstLarger(arr,start,mid-1,x);
        }
        else {
            return binarySearchFirstLarger(arr,mid+1,end,x);
        }
    }

    public static long findH(long[] trees, int numTree, long x){
        int i = binarySearchFirstLarger(trees,0,numTree-1,x);
        if (i == -1) {
            i = (numTree)/2;
        }
        long H = trees[i];
        long curSum = 0;
        while(i < numTree-1 && curSum < x){
            long diff = trees[i+1] - H;
            curSum+=diff;
            i++;
        }
        if (H == x) {
            return H;
        }
        else {
            return H+=(curSum-x);
        }

    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int numTree = sc.nextInt();
        long x = sc.nextLong();
        long[] trees = new long[numTree];
        int i = 0;
        while (i < numTree){
            trees[i] = sc.nextLong();
            i++;
        }
        Arrays.sort(trees);
        //System.out.println(binarySearchFirstLarger(trees,0,numTree-1,x));
        System.out.println(findH(trees,numTree,x));
    }
}
