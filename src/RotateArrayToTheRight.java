import java.util.Scanner;

/**
 * Created by anhtran on 9/4/17.
 */
public class RotateArrayToTheRight {
    public static void rotate(int[] arr,int n, int k){
//        int[] newArr = new int[arr.length];
//        if(k > n){
//            k = k-n;
//        }
//        int j = 0;
//        for(int i = n-k; i < n; i++){
//            newArr[j] = arr[i];
//            j++;
//        }
//        for(int i = 0; i < n-k; i++){
//            newArr[j] = arr[i];
//            j++;
//        }
//        System.arraycopy(newArr,0,arr,0,arr.length);
        if(arr == null || k < 0){
            throw new IllegalArgumentException("Inputs are invalid");
        }
        if(k > n){
            k = k-n;
        }
        for(int i = 0; i < k; i++){
            for(int j = n-1; j > 0; j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

//    public static void rotate(int[] nums, int k){
//        if(nums == null || k < 0){
//            throw new IllegalArgumentException("Illegal Argument");
//        }
//        if(k > nums.length){
//            k = k - nums.length;
//        }
//
//        //length of the first part
//        int arrLength = nums.length - k;
//        reverse(nums,0,arrLength-1);
//        reverse(nums, arrLength,nums.length-1);
//        reverse(nums,0,nums.length-1);
//    }
//
//    private static void reverse(int[] nums, int start, int end){
//        if(nums == null || nums.length == 1){
//            return;
//        }
//        while(start < end){
//            int temp = nums[end];
//            nums[end] = nums[start];
//            nums[start] = temp;
//            start++;
//            end--;
//        }
//
//    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        rotate(arr,n,k);
        for(int i: arr){
            System.out.print(i);
        }
    }

}
