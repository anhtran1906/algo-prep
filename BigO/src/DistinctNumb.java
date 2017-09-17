import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by anhtran on 7/7/17.
 */
public class DistinctNumb {
    public static String checkDistinct( ArrayList<Integer> arr,int x){
        Set<Integer> set = new HashSet<Integer>();
        set.addAll(arr);
        if (set.size() == x) {
            return "Good";
        }
        else if (set.size() < x) {
            return "Bad";
        }
        else {
            return "Average";
        }
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while(tests > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            ArrayList<Integer> arr = new  ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                arr.add(i,sc.nextInt());
            }
            System.out.println(checkDistinct(arr,x).toString());
            tests--;
        }

    }
}
