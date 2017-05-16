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
}