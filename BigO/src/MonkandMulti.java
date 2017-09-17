import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by anhtran on 7/22/17.
 */
public class MonkandMulti {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<Long>(10, Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            queue.add(sc.nextLong());
            if(queue.size() < 3){
                System.out.println(-1);
            }
            else {
                long first = queue.poll();
                long second = queue.poll();
                long third = queue.poll();
                long result = first*second*third;
                System.out.println(result);
                queue.add(first);
                queue.add(second);
                queue.add(third);
            }
        }
    }
}
