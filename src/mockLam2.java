///**
// * Created by anhtran on 9/14/17.
// */
//public class mockLam2 {
//    // package whatever; // don't place package name!
//
///*
//Given an integer n, return the number of trailing zeroes = continous zero
//in n!
//
//
//100 -> 2
//// 1020 -> 1
//
//1001000 -> 3
//
//
//n!
//n: o(n)
//n! = 1*2*...*n
//
//
//len(number1) * len(number2)  = O(n)
//
//123
// 45
//
//x / 10
//x / 2  and x / 5
//
//
//
//if(n!  // 2 && n! // 5){
//
//}
//
//[1,2,......,n]
//
//1*2*3*4*5*6*7*10
//
//In this range,
//1) find numbers that divide 2 and 5 (this means it divides 10 ) arr[i] % 2 && arr[5] % 5 = 0
//2) return ^,
//
//
//
//1) find n! -> save it in a string
//2) find max number of trailing zeroes in n!
//
//
//
//   num2 = 0
//   num5 = 0
//1) for i=1->n
//    while arr[i] % 2 == 0  && arr[i] >=1
//        num2++
//        arr[i] = arr[i]/2
//    same for 5
//
//    return min(num2,num5)
//
//    O(n* (log2(n) + log5(n)))
//*/
//
//
//
//    long long x = 5;
//    int countZero = 0;
//    while (x <= A) {
//        countZero += A / x;
//        x*= 5;
//    }
//    return countZero;
//
//    public static int countTrailingZero(int n){
//        int num2 = 0;
//        int num5 = 0;
//
//        // n = 5
//
//        for(int i = 1; i <= n; i++){
//            // i = 2
//
//            int cur = i;
////             while(i % 2 == 0 && i >= 2) {
////                 num2++;
////                 i= i/2;// i= i/ 2= 1
////             }
//            while(i % 5 == 0 && i >= 5) {
//                num5++;
//                i= i/5;
//            }
//            i = cur;
//        }
//
//        return Math.min(num2,num5);
//    }
//
//    int res = 0;
//    int i = 1;
//
//while(i <= log5(n))
//    res += n/(5^i)
//    i++;
//
//return res;
//
//
//        public static void main (String[] args) throws java.lang.Exception
//        {
//            System.out.println("Hello Java");
//        }
//    }
//}
//
//// package whatever; // don't place package name!
///*
//
//
//1 2 3 4 5 6
//1 1 1 1 1 1
//  11   11  11
//
//    111 .  111
//
//
//
//*/
//
//        import java.io.*;
//
//        2 4 5
//        2/2
//        1
//
//        int res  = 0;
//        while(x >= 1){
//        x/2
//        res
//        }
//
//        a
//        a^2 = x
//
//        a^2 = a * a
//        2^a = 2 * 2 * 2 ... * 2
//
//
//        the number largest i such that i * i <= x
//
//
//        1 2 3 4
//
//        1 1 1... 2
///*
//printlnImplement int sqrt(int x).
//
//Compute and return the square root of x.
//
//If x is not a perfect square, return floor(sqrt(x))
//*/
//        [0..x]
//        6 => 2^2
//
//        bs(x){
//        start = 1
//        end = x //
//        long mid = start + (end-start)/2   // mid = (1 + MAX_INT) (1 + MAX_INT)  / 4
//        if(mid*mid > x){
//        bs(x,start,mid-1)
//        }
//        else {
//        bs (x,mid+1,end)
//
//        }
//        if (mid * mid == x) return mid;
//        else
//        return mid
//
//        }
//
//
//public int findSurt(int x){ //O(sqrt(x))
//        int i = 1;
//        while(i*i <= x){
//        i++;
//        }
//        return i-1;
//
//
//        }
