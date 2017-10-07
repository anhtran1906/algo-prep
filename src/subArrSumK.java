import java.util.HashMap;
import java.util.Scanner;

/*
 * Created by anhtran on 9/22/17.
 *
 * // Solution 2:
 sum(i) is a function that return the sum of element is the prefix i of array
 sum (A[0] + A[1] + ... A[i] )
 sum(0) = A[0]
 sum(1) = A[0] + A[1] = sum(0) + A[1]
 sum(2) = A[0] + A[1] + A[2] = sum(1) + A[2]

 => sum(i) = sum(i-1) + A[i]

 sum(i) for all index from [0.. A.size() - 1]

 (i, j) => A[i] + A[i+1] + ... + A[j] = k
 => sum(j) - sum(i - 1) = k



 when I am index j, I will find the  index i such that sum(i) = sum(j) - k
 => update answer with 2 indices : i + 1 and j
 the hash map to store the value of sum


 Time complex : O(n)
 Space : O(n)

 sum(j) - sum(i - 1) = k    <-> sum(j) - k = sum(i-1)


 sum(j) = A[0] + A[1] + ....+ A[i-1] + A[i] + ... + A[j]
 sum(i - 1) = A[0] + A[1] + ... A[i-1]
 sum(j) - sum(i-1) = A[i] + ... A[j]
 assum : i <= j
 sum(j) - sum(j-1) = A[j] if i == j

 #include <iostream>
using namespace std;

int findMaximumSubarray (const vector <int> &A, int B) {
    int n = A.size();    // length of array

    vector <int> sum(n + 1);
    // sum(i) is a function that return the sum of all element that are the prefix i of array
    for (int i = 0; i < n; i++) {
        if (i == 0)
            sum[i] = A[0];
        else
            sum[i] = sum[i-1] + A[i];
    }

    unorder_map M;  // hash set
    M[0] = -1;
    int lengthMax = 0;
    // sum[-1] = 0
    for (int j = 0; j < n; j++) {
        // with each index j, I will find i such that sum[i-1] = sum[j] - B
        int value = sum[j] - B;
        // find the value in unorder map
        if (M.find(value) != -1) {
            // there is index with key = value
            // update answer
            int i = M[value] + 1;
            if (j - i + 1 > lengthMax) {
                lengthMax = j - i + 1;
            }
        }
        // update sum[j] in M
        // check if sum[j] in M
        if (M.find(sum[j]) == -1)
            M[sum[j]] = j;
    }
    return lengthMax;
}






// package whatever; // don't place package name!

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

class myCode
{
    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> prevSumMap = new HashMap<Integer,Integer>();
        int maxLength = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];

            if(sum == k){
                maxLength = Math.max(maxLength,i+1);
            }

            int diff = sum - k;

            if(prevSumMap.containsKey(diff)){
                maxLength = Math.max(maxLength,i - prevSumMap.get(diff));
            }
            if(!prevSumMap.containsKey(sum)){
                prevSumMap.put(sum,i);
            }
        }
        return maxLength;

    }

    public static void main (String[] args) throws java.lang.Exception
    {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] nums = new int[n];

        int[] nums1 = {};
        int k1 = 4;

//         for(int i = 0; i < n; i++){
//             nums[i] = sc.nextInt();
//         }
//         int k = sc.nextInt();


        System.out.println(maxSubArrayLen(nums1,k1));
    }
}



 */
public class subArrSumK {
    public static int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> prevSumMap = new HashMap<Integer,Integer>();
        int maxLength = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];

            if(sum == k){
                maxLength = Math.max(maxLength,i+1);
            }

            int diff = sum - k;

            if(prevSumMap.containsKey(diff)){
                maxLength = Math.max(maxLength,i - prevSumMap.get(diff));
            }
            if(!prevSumMap.containsKey(sum)){
                prevSumMap.put(sum,i);
            }
        }
        return maxLength;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(maxSubArrayLen(nums,k));
    }
}
