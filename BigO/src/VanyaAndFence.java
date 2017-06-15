import java.util.Scanner;

/**
 * Created by anhtran on 5/24/17.
 */
public class VanyaAndFence {
    public static int calculateWidth (int num, int height, int[] arr) {
        int width = 0;
        for(int i = 0; i < num; i++) {
            if(arr[i] <= height) {
                width++;
            }
            else {
                width = width + 2;
            }
        }
        return width;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(calculateWidth(n,h,arr));
    }
}
