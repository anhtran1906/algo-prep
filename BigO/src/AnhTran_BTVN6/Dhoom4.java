package AnhTran_BTVN6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by anhtran on 6/13/17.
 */
public class Dhoom4 {

    private static long getMinStep(long[] inputKey, long samKey, long requireKey) {
        Queue<Long> keys = new LinkedList<Long>();
        long[] steps = new long[100000];
        Arrays.fill(steps,-1);
        long curSamKey = samKey;
        keys.offer(curSamKey);
        steps[(int) curSamKey] = 0;
        long result = -1;

        while(!keys.isEmpty()) {
            long cur = keys.poll();
            if (cur == requireKey) {
                result = steps[(int) requireKey];
                break;
            }
            for (int i = 0; i < inputKey.length; i++) {
                long curInput = inputKey[i];
                curInput = (curInput * cur)%100000;
                if (steps[(int)curInput] == -1) {
                    steps[(int)curInput] = steps[(int) cur] + 1;
                    keys.offer(curInput);
                }
            }
        }
        return result;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long samKey = sc.nextInt();
        long requireKey = sc.nextInt();
        int n = sc.nextInt();
        long[] inputKey = new long[n];
        for(int i = 0; i < inputKey.length; i++) {
            inputKey[i] = sc.nextInt();
        }

        System.out.println(getMinStep(inputKey, samKey, requireKey));
    }
}
