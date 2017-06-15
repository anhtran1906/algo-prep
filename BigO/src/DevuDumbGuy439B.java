import java.util.*;

/**
 * Created by anhtran on 6/2/17.
 */
public class DevuDumbGuy439B {
    private static long findMinHour(ArrayList<Long> chaps, long n, long x) {
        Collections.sort(chaps);
        long curLearn = x;
        long totalLearn = 0;
        for(int i = 0; i < n; i++){
//            curLearn-=i;
//            totalLearn+=chaps[i]*(Math.max(curLearn,1));
            totalLearn+=chaps.get(i)*curLearn;
            curLearn = Math.max(curLearn-1,1);

        }
        return totalLearn;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long x = s.nextLong();
        ArrayList<Long> chaps = new ArrayList<>();
        for(int i = 0; i < n; i++){
            chaps.add(s.nextLong());
        }
        System.out.println(findMinHour(chaps,n,x));
    }
}
