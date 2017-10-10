package Coursera;

import java.util.Scanner;

/**
 * remove
 * replace
 * insert
 *
 * a
 * ab
 *
 *
 * ""
 * ""
 * [m][n] = 0
 * return arr[m][n]
 *
 * "" -> m = 0
 * a -> n = 1
 * [m][n] = n
 * return arr[m][n]
 *
 * a
 * ""
 * [m][n] = m
 * return arr[m][n]
 *
 * ab
 * ab
 * if(charAt(m) == charAt(n))
 *  [m][n] = [m-1][n-1]
 * else
 *  [m][n] = min([m-1][n], [m][n-1], [m-1][n-1])
 *
 *
 *
 *
 *
 *
 * Created by anhtran on 10/7/17.
 */
public class editDistance {
    public static int findMin(int a, int b, int c) {
        int[] result = new int[3];
        if(a < b && a < c) {
           return a;

        }
        else if(b < a && b < c){
           return b;
        }
        else {
           return c;
        }
    }


    public static int getMinDist(String word1, String word2) {
        return getMinDist(word1,word2,word1.length(),word2.length());
    }
    private static int getMinDist(String word1, String word2, int m , int n) {
        if(m == 0) {
           return n;
        }
        if(n == 0) {
            return m;
        }

        else if(word1.charAt(m-1) == word2.charAt(n-1)){
            return getMinDist(word1,word2,m-1,n-1);
        }
       return 1 + findMin(
                    getMinDist(word1,word2,m,n-1), //insert to word1
                    getMinDist(word1,word2,m-1,n), //remove from word1
                    getMinDist(word1,word2,m-1,n-1) //replace word1 with word2 char
            );
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
//        word1 = "a";
//        word2="";
        System.out.println(getMinDist(word1,word2));
    }
}
