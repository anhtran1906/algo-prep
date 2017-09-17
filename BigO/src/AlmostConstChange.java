import java.util.*;

/**
 * Created by anhtran on 7/22/17.
 */
public class AlmostConstChange {
    public static int getMax(int[]arr, int n){
        int maxRange = 0;
        PriorityQueue<Integer> track = new PriorityQueue<Integer>();
        for(int i =0; i < n-1; i++){
            int j = i+1;
            int curRange = 1;
            if(track.isEmpty()){
                track.offer(arr[i]);
            }
            while(j < n) {
                track.offer(arr[j]);
                if(arr[j] - track.peek() <=1) {
                    curRange++;
                    j++;
                }
                else {
                    while(arr[j] - track.peek() > 1) {
                        track.poll();


                        
                    }
                }
            }
            maxRange=Integer.max(curRange,maxRange);
        }
        return maxRange;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(getMax(arr,n));
    }
}
