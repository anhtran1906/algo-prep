import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

/**
 * Created by anhtran on 5/27/17.
 */
public class Arr224B {

    public static String checkMinIncl(int[] arr, int k) {
        int j = 0;
        int countDistinct = 0;
        int[] freq = new int[(int) Math.pow(10,5) + 1]; //length of freq == max value in arr + 1
        for(int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
            if(freq[arr[i]] == 1){
                countDistinct++;
            }

            while(countDistinct == k){
                freq[arr[j]]--;
                if(freq[arr[j]] == 0) {
                    j++;
                    i++;
                    return j + " " + i;
                }
                j++;
            }
        }
        return "-1 -1";

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(checkMinIncl(arr,k));


    }
}
