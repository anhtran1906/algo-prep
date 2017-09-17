import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by anhtran on 6/17/17.
 */
public class MiceMaze {

    private static class Pair<K,V> {
        private K first;
        private V second;
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
        public K getFirst() {
            return this.first;
        }
        public V getSecond() {
            return this.second;
        }

    }

    private static void dijkstra (int source, int destination, Pair[][] graph, int[] distance) {
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<Pair<Integer,Integer>>();
        queue.offer(new Pair(0,source));
        distance[source] = 0;
        int[] path = new int[500];
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> top = queue.poll();
            int dest = top.getSecond();
            int dist = top.getFirst();

            for(int i = 0; i < graph[dest].length; i++ ){
                Pair<Integer, Integer> neighbor = graph[dest][i];
                if (dist + neighbor.getSecond() < distance[neighbor.getFirst()]) {
                    distance[neighbor.getFirst()] = dist + neighbor.getSecond();
                    queue.add(new Pair(distance[neighbor.getFirst()], neighbor.getFirst()));
                    path[neighbor.getFirst()] = dest;
                }
            }
        }

    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int t = sc.nextInt();
        int m = sc.nextInt();

//        List<Pair<Integer,Integer>>[][] graph = new List<Pair<Integer,Integer>>[505][505];
//
//        while (m > 0){
//            for(int i = 0; i < graph.length; i++) {
//                for(int j = 0; j < graph[0].length; j++) {
//                    int a = sc.nextInt();
//                    int b = sc.nextInt();
//                    int w = sc.nextInt();
//                    graph[a][j] = new ArrayList<>().add(new Pair(b,w));
//
//                }
//            }
//            m--;
//        }
    }
}
