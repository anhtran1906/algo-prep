import java.util.ArrayList;

/**
 * Created by anhtran on 9/16/17.
 */
public class longestPathConsec {
    /*
Problem 1: Given a n by n table containing distinct numbers in range [1, n^2].
Find the longest path containing consecutive numbers.

Example:
n = 4

7 8 9
6 5 4
1 2 3

10 15  2  3
11  8  5  4
 1  7  6  9
12 13 14 16

1)

->  2 3 4 5 6 7 8
-> length = 7
*/
/*
1) start at the first row find the smallest val
2) try possible directions and move to the consecutive pos
*/


//    public int computeLongestConsecutivePath(ArrayList<ArrayList<Integer>> table) {
//        int min = table.size() * table.size() +1;
//        ArrayList<Integer> row = table[0];
//        for(int i = 0; i < row.size(); i++){
//            min = Math.min(row.get(i), min);
//        }
//
//    }
//
//    public int findIndexOfConsecutive(ArrayList<Integer> row,) {
//
//    }
}
