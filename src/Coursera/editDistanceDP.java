package Coursera;

import java.util.Scanner;

/**
 * Created by anhtran on 10/7/17.
 */
public class editDistanceDP {
    public static int getMinDist(String word1, String word2) {
        return getMinDist(word1,word2,word1.length(),word2.length());
    }
    private static int getMinDist(String word1, String word2, int m , int n) {
        int[][] minArr = new int[m + 1][n + 1];

//        int i = 0;
//        int j = 0;
//
//        if(i == 0) {
//            minArr[i][j] = j;
//        }
//        else if(j == 0){
//            minArr[i][j] = i;
//        }

        for(int  i = 0 ; i <= m; i++){
            for(int j = 0; j <= n; j++) {
                if(i == 0) {
                    minArr[i][j] = j;
                }
                else if(j == 0) {
                    minArr[i][j] = i;
                }
                else if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    //return getMinDist(word1,word2,m-1,n-1);
                    minArr[i][j] = minArr[i-1][j-1];
                }
                else {
                    int minResult = editDistance.findMin(
                            minArr[i-1][j],
                            minArr[i][j-1],
                            minArr[i-1][j-1]);
                    minArr[i][j] = 1 + minResult;
                }
            }
        }

        return minArr[m][n];
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
//        word1 = "";
//        word2="";
        System.out.println(getMinDist(word1,word2));
    }
}
