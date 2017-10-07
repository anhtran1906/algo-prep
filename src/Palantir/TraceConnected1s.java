//package Palantir;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * Created by anhtran on 10/1/17.
// *
// * nxn of 0s and 1s. Find the max connected 1s
// *
// */
//public class TraceConnected1s {
//
//    public static long countAll(int[][] matrix){
//        long result = 0;
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                if(matrix[i][j] == 1){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//
//    public static boolean isFullyConnected(int[][] matrix){
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(matrix[0][0]);
//        while(!queue.isEmpty()){
//            int cur = queue.poll();
//
//        }
//
//    }
//
//}
