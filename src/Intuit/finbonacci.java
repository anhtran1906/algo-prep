package Intuit;

/**
 * Created by anhtran on 9/23/17.
 */
public class finbonacci {
    public static long fin(int n){
        if(n == 0){
       return 0;
      }
     if(n == 1){
       return 1;
     }

     int[] arr = new int[n+1];
     arr[0] = 0;
     arr[1] = 1;

     for(int i = 2; i < n+1; i++) {
       arr[i] = arr[i-1] + arr[i-2];
     }
     return arr[n];
   }

    public static void main(String[] args) {
        System.out.println(fin(5));
    }

}
