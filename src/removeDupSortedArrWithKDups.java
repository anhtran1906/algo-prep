/**
 * Created by anhtran on 9/18/17.
 */
public class removeDupSortedArrWithKDups {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums,nums.length,2);
    }

    public int removeDuplicates(int[] nums, int n, int k) {
        if (n <= k) {
            return n;
        }
        int i = 1;
        int j = 1;
        int count = 1;
        while (j < n) {
            if (nums[j] != nums[j - 1]) {
                count = 1;
                i++;
                nums[i] = nums[j];
            } else {
                if (count < k) {
                    i++;
                    nums[i] = nums[j];
                    count++;
                }
            }
            j++;
        }
        return i;
    }
}
