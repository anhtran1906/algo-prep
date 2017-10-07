import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by anhtran on 9/18/17.
 */
public class longestSubStringWithKDupChar {
    private static class CharFrequen implements Comparable<CharFrequen>{
        public int freq;
        public char charac;
        public CharFrequen(int freq, char charac){
            this.freq = freq;
            this.charac = charac;
        }

        @Override
        public int compareTo(CharFrequen o) {
            return o.freq - this.freq;
        }
    }
//    public int longestSubstring(String s, int k) {
//        PriorityQueue<CharFrequen> maxHeap = new PriorityQueue<>();
//        for(int j = 0; j < s.length(); j++){
//            CharFrequen c = new CharFrequen(j,s.charAt(j));
//
//            if(maxHeap.contains())
//        }
//
//        return 0;
//    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<CharFrequen> maxHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            //CharFrequen c = new CharFrequen(sc.nextInt(),i);
            //maxHeap.add(c);
        }
        while(!maxHeap.isEmpty()){
            System.out.println(maxHeap.poll().freq);
        }
    }
}
