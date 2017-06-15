/**
 * Created by anhtran on 5/24/17.
 */

import java.util.Scanner;
public class FashionInBerland {

    public static String checkTshirt (int[] arr) {
        if(arr.length == 1 && arr[0] == 0) {
            return "NO";
        }
        else if(arr.length == 1 && arr[0] == 1) {
            return "YES";
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) {
                count++;
            }
            if(count > 1) {
                return "NO";
            }
        }
        if(count == 0) {
            return "NO";
        }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(checkTshirt(arr));
    }
}
