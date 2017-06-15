import java.util.Scanner;

/**
 * Created by anhtran on 5/31/17.
 */
public class ProblemBook {

    public static int getMinBook (int[]books, int t, int n) {
        int sum = 0;
        int j = 0;
        int i = 0;
        int maxNum = 0;
        int count = 0;

//        while (i < n) {
//            while (sum > t) {
//                sum -= books[j];
//                j++;
//                count--;
//            }
//
//        sum += books[i];
//        count++;
//        i++;
//        maxNum = Math.max(count,maxNum);
//
//        }
//        return maxNum;

        while (i < n) {
            while (t < books[i]) {
                t+= books[j];
                count--;
                j++;
            }
            t-=books[i];
            count++;
            i++;
            maxNum = Math.max(count,maxNum);
        }
        return maxNum;

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int t = s.nextInt();
        int[] books = new int[n];

        for(int i = 0; i < n; i++){
            books[i] = s.nextInt();
        }
        System.out.println(getMinBook(books,t,n));
    }
}
