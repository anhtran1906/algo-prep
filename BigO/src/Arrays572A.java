/**
 * Created by anhtran on 5/26/17.
 */
import java.util.Scanner;
public class Arrays572A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nA = sc.nextInt();
        int nB = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int[] arrA = new int[nA];
        int[] arrB = new int[nB];
        boolean res = false;
        for (int i = 0; i < nA; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < nB; i++) {
            arrB[i] = sc.nextInt();
        }

        if(arrA[k-1] < arrB[nB-m]) {
            res = true;
        }

        if(res) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
