/**
 * Created by anhtran on 5/16/17.
 */
public class Solution {
    /*
    Question:
     */
    public static void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k - nums.length;
        }
        int[] newArr = new int[nums.length];
        for(int i = 0; i < k; i++){
            newArr[i] = nums[nums.length-k+i];
        }
        for(int j = k; j < newArr.length; j++){
            newArr[j] = nums[j-k];
        }
        System.arraycopy(newArr,0,nums,0,nums.length);
    }
    /*
        This answer gives O(n*k) solution. Takes the idea of bubble sort
     */
    public static void rotate2(int[] nums, int k) {
        if(nums == null || k < 0){
            throw new IllegalArgumentException("Illegal Argument");
        }
        if(k > nums.length){
            k = k - nums.length;
        }
        for(int i = 0; i < k; i++){
            for(int j = nums.length-1; j > 0; j--){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }
    }

    public static void rotate3(int[] nums, int k){
        if(nums == null || k < 0){
            throw new IllegalArgumentException("Illegal Argument");
        }
        if(k > nums.length){
            k = k - nums.length;
        }

        //length of the first part
        int arrLength = nums.length - k;
        reverse(nums,0,arrLength-1);
        reverse(nums, arrLength,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    private static void reverse(int[] nums, int start, int end){
        if(nums == null || nums.length == 1){
            return;
        }
        while(start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }

    }
}