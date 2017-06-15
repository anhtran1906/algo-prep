import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 6/2/17.
 */
public class TowersA {

    public static int[] findTower (int[] bars, int n) {
        int count = 0;
        int[] res = new int[2];
        int[] freq = new int[1000+1];
        for(int i = 0; i < n; i++){
            freq[bars[i]]++;
            if(freq[bars[i]] == 1){
                count++;
            }
        }
        Arrays.sort(freq);
        int maxHeight = freq[freq.length-1];
        res[0] = maxHeight;
        res[1] = count;
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] bars = new int[n];
        for(int i = 0; i < n; i++){
            bars[i] = s.nextInt();
        }
        int[] res = findTower(bars,n);
        System.out.println(res[0]+ " " + res[1]);
    }

}
