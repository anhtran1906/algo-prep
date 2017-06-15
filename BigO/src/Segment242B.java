import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

/**
 * Created by anhtran on 5/26/17.
 */
public class Segment242B {

    private static class Pair {
        private int start;
        private int end;

        public Pair(int start,int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart(){
            return start;
        }
        public int getEnd() {
            return end;
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = MAX_VALUE;
        int end = 0;
        int count = 0;
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        while (n > 0) {
            int curStart = sc.nextInt();
            int curEnd = sc.nextInt();
            start = Math.min(start,curStart);
            end = Math.max(end,curEnd);
            pairs.add(new Pair(curStart, curEnd));
            n--;
        }

        Pair segment = new Pair(start,end);

        for(int i = 0; i < pairs.size(); i++) {
            if(segment.getStart() == pairs.get(i).getStart() && segment.getEnd() == pairs.get(i).getEnd()) {
                count = i+1;
                System.out.println(i+1);
            }
        }
        if(count==0) {
            System.out.println("-1");
        }
    }
}
