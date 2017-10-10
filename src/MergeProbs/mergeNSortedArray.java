package MergeProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 10/7/17.
 *
 * arr1 = [1,2,3]
 * arr2=[2,3,4]
 *
 * -> result = [1,2,3,4]
 *
 * does not handle duplicate inputs
 *
 */
public class mergeNSortedArray {
    public static int[] mergeSortedArr(int[] arr1, int[] arr2) {
        int[] result  = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int indexToAdd = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                result[indexToAdd] = arr1[i];
                i++;
                indexToAdd++;
            }
            else if(arr1[i] > arr2[j]){
                result[indexToAdd] = arr2[j];
                j++;
                indexToAdd++;
            }
            else {
                result[indexToAdd] = arr2[j];
                i++;
                j++;
                indexToAdd++;
            }
        }

        while(i < arr1.length) {
            result[indexToAdd] = arr1[i];
            i++;
            indexToAdd++;
        }
        while(j < arr2.length) {
            result[indexToAdd] = arr2[j];
            j++;
            indexToAdd++;
        }
        int trimIndex = 0;
        while(trimIndex < result.length && result[trimIndex] != 0) {
            trimIndex++;
        }
        result = Arrays.copyOf(result,trimIndex);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for(int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }

        int[] res = mergeSortedArr(arr1,arr2);
        for(int i: res){
            System.out.println(i);
        }
    }
}
