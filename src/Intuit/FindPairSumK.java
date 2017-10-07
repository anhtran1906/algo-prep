package Intuit;

import java.io.*;
import java.util.*;


/*
 * Created by anhtran on 9/23/17.
 *
 * Given a set of numbers and another number, find all pairs in the set that add up to given number.

*/
public class FindPairSumK {
    private static class Pair {
        public int firstElem;
        public int secondElem;

        public Pair(int firstElem, int secondElem){
            this.firstElem = firstElem;
            this.secondElem = secondElem;
        }

        public void printPair() {
            System.out.println("[" + this.firstElem + ", " + this.secondElem + "]");
        }
    }
    public static ArrayList<Pair> findPairSumK(int[] nums, int k){
        ArrayList<Pair> result = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;

        while(left <= right) {
            System.out.println(left);
            System.out.println(right);
            long sum = nums[left] + nums[right];
            if (sum < k){
                left++;
            }
            else if(sum > k){
                right--;
            }
            else {
                result.add(new Pair(nums[left], nums[right]));
                left++;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {1,-1,2,3};
//        int k = 5;
//        ArrayList<Pair> result = findPairSumK(arr,k);
//        for(Pair pair: result){
//            pair.printPair();
//        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        ArrayList<Pair> result = findPairSumK(nums,k);
        for(Pair pair: result){
            pair.printPair();

        }
    }

}
