import java.util.Scanner;

/**
 * Created by anhtran on 8/20/17.
 */
public class exampleOfCS {
    public static int findMax(int a, int b){
        if(a < b){
            return b;
        }
        else {
            return a;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findMax(a,b));
    }
}
