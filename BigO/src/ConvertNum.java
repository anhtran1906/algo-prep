import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 9/5/17.
 */
public class ConvertNum {
    static long convertNum(long num){
        char[] chars =  Long.toString(num).toCharArray();
        char[] newChars = new char[chars.length];
        int i = 0;
        int j = chars.length-1;
        while(i < chars.length && j >=0){
            newChars[i] = chars[j];
            i++;
            j--;
        }
        String s = new String(newChars);
        return Long.parseLong(s);
    }

//    static long convertNum(long input){
//        long reversedNum = 0;
//        while(input != 0){
//            long lastDigit = input%10;
//            reversedNum = reversedNum*10+lastDigit;
//            input = input/10;
//        }
//        return reversedNum;
//    }

    static long solve(long[] arr){
        for(int i = )
        Arrays.sort(arr);
        return convertNum(arr[arr.length-1]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(solve(arr));

    }
}
