import java.util.Scanner;

/**
 * Created by anhtran on 9/10/17.
 */
public class checkMatrix {
    public static boolean check(int[][] input, int n){
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                if(input[i][j] != input[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] input = new int[n][n];
        for(int row = 0; row < input.length; row++){
            for(int col = 0; col < input[row].length; col++){
                input[row][col] = sc.nextInt();
            }
        }
        System.out.println(check(input, n));
    }
}
