/**
 * Created by anhtran on 5/16/17.
 */
public class Solution {
    /*
    Question: Rotate an array to the right by k steps
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

    /*
        Question: Reverse a string. Example: "hello" into "olleh"
        String is immutable in Java => need to parse into a chaArray then pass it back to a String
        toCharArray()
        String.valueOf(charArray)
     */
    public String reverseString(String s) {
        return reverseString(s, 0, s.length() -1);
    }
    private static String reverseString(String s, int start, int end) {
        if(s == null || s.length() == 1){
            return s;
        }
        char[] tempS = s.toCharArray();
        while(start < end){
            char temp = tempS[end];
            tempS[end] = tempS[start];
            tempS[start]  = temp;
            start++;
            end--;
        }
        s = String.valueOf(tempS);
        return s;
    }

    /*
        Question: Reverse words in String
        Example: "the cat is cute" --> "cute is cat the"
     */
    public static String reverseWords(String input) {
        char[] s = input.toCharArray();
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);
                i=j+1;
            }
        }

        reverse(s, i, s.length-1);
        reverse(s, 0, s.length-1);
        return s.toString();
    }

    public static String reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
        return s.toString();
    }

    /*
        this doesn't work with " 1" since it will return "1 " instead of "1"
     */
    public static String reverseWords2(String s) {
        String[] sArr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for(int i = sArr.length-1; i >= 0; i--){
            builder.append(sArr[i]);
            if(i != 0){
                builder.append(" ");
            }
        }
        return  builder.toString();
    }
}