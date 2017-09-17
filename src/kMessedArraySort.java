import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by anhtran on 9/12/17.
 *
 * [1,4,5,2,3] vs. [1,2,5,4,3]
 *
 * [1,2,4,5,3]
 */
public class kMessedArraySort {
    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[]arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }


    public static int[] sortkMessedArr(int[]arr, int k){
        for(int i = 1; i < arr.length; i++){
            int x = arr[i];
            int j = i -1;
            while(j >= 0 && arr[j] > x){
                swap(arr,j+1,j);
                j--;
            }
            arr[j+1] = x;
        }
        return arr;
    }

    public static void sortArr(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < k+1; i++){
            minHeap.add(arr[i]);
        }
        for(int i = k+1; i < arr.length; i++ ){
            arr[i-(k+1)] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        for(int i = 0; i < k+1; i++){
            arr[arr.length - 1 -k + i] = minHeap.poll();
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int j = 0; j < n; j++){
            arr[j] = sc.nextInt();
        }
        int k = sc.nextInt();
        //sortkMessedArr(arr,k);
        //bubbleSort(arr);
        sortArr(arr,k);
        for(int i: arr){
            System.out.println(i);
        }

    }
}
