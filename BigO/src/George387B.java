import java.util.Scanner;

/**
 * Created by anhtran on 5/30/17.
 */
public class George387B {

    public static int getMinProbNum(int n, int m, int[] require, int[] prep) {
//        int[] freq = new int[3000+1];
//        for(int i = 0; i < prep.length; i++){
//            freq[prep[i]]++;
//        }
//        int i = 0;
//        while (i < n){
//            for(int j = 0; j < m; j++){
//                if (require[i] == prep[j]){
//                    j+=freq[prep[j]];
//                    i++;
//                    if(j >= m) {
//                        return 0;
//                    }
//                }
//            }
//            if(i <= n) {
//                return n-i;
//            }
//            else {
//                i++;
//            }
//
//        }
//        return n-i;
        int count = 0;
        int i = 0; //require
        int j = 0; //prep
        while (j < m && i < n) {
            if (prep[j] >= require[i]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return n-count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] require = new int[n];
        int[] prep = new int[m];

        for(int i = 0; i < n; i++){
            require[i] = s.nextInt();
        }

        for(int i = 0; i < m; i++){
            prep[i] = s.nextInt();
        }

        System.out.println(getMinProbNum(n,m,require,prep));
    }
}
