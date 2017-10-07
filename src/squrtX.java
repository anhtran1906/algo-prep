import java.util.Scanner;

/**
 * Created by anhtran on 9/18/17.
 */
public class squrtX {
    public static long mySqrt(int x) {
        return bsSqurt(x,1,x);
    }
    //allow long to be used
//    public static long bsSqurt(int x,long start, long end){
//        if(start > end){
//            return end;
//        }
//        long mid = start + (end-start)/2;
//        if(mid*mid > x){
//            return bsSqurt(x,start,mid-1);
//        }
//        else if(mid*mid < x){
//            return bsSqurt(x,mid+1,end);
//        }
//        else {
//            return mid;
//        }
//    }

    // not allowed long, only int
    public static int bsSqurt(int x,int start, int end){
        if(x == 0){
            return 0;
        }
        if(start > end){
            return end;
        }
        int mid = start + (end-start)/2;
        if(mid > x/mid){ //avoid mid overflow
            return bsSqurt(x,start,mid-1);
        }
        else if((mid+1)*(mid+1) > x){
            return mid;
        }
        else {
            return bsSqurt(x,mid+1,end);
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(mySqrt(x));

    }
}
