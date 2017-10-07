package Palantir;

import java.util.Scanner;

/**
 * Created by anhtran on 9/30/17.
 */
public class SingleNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int result = 0;
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            System.out.println(result ^= nums[i]);
        }
    }
}
