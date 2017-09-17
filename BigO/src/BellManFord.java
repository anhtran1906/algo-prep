import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 7/4/17.
 */
public class BellManFord {
    private static class Edge<S,E,W> {
        private S startV;
        private E endV;
        private W weight;

        public Edge(S startV, E endV, W weight) {
            this.startV = startV;
            this.endV = endV;
            this.weight = weight;
        }
        public S getStartV() {
            return this.startV;
        }
        public E getEndV() {
            return this.endV;
        }
        public W getWeight() { return this.weight; }
        public void printEdge () {
            System.out.println(startV + " --> " + endV + " : " + weight);
        }
    }

    public static boolean bellmanFord(ArrayList<Edge<Integer,Integer,Integer>> list, int start, int[] dist, int[] path, int m) {
        dist[start] = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < list.size(); j++){
                Edge cur = list.get(j);
                int startV = (int) cur.getStartV();
                int endV = (int) cur.getEndV();
                int weight = (int) cur.getWeight();
                if(dist[startV] != Integer.MAX_VALUE  && dist[endV] > dist[startV] + weight) {
                    dist[endV] = dist[startV] + weight;
                    path[endV] = startV;
                }
            }
        }

        for(int j = 0; j < list.size(); j++){
            Edge cur = list.get(j);
            int startV = (int) cur.getStartV();
            int endV = (int) cur.getEndV();
            int weight = (int) cur.getWeight();
            if(dist[startV] != Integer.MAX_VALUE  && dist[endV] > dist[startV] + weight) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while(tests > 0){
            int n = sc.nextInt(); //star systems-vertices
            int m = sc.nextInt(); //wormholes-edges
            ArrayList<Edge<Integer,Integer,Integer>> edgeList = new ArrayList<Edge<Integer,Integer,Integer>>();
            int[] dist;
            int[] path;
            if(n > m) {
                dist = new int[n];
                path = new int[n];
            }
            else {
                dist = new int[m];
                path = new int[m];
            }
            Arrays.fill(dist,Integer.MAX_VALUE);
            Arrays.fill(path,-1);
            int j = 1;
            while (j <= m){
                Edge e = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
                edgeList.add(e);
                j++;
            }
//            for(int i = 0; i < edgeList.size(); i++){
//                edgeList.get(i).printEdge();
//            }

            if(bellmanFord(edgeList,0,dist,path,m)){
                System.out.println("not possible");
            }
            else {
                System.out.println("possible");
            }
            tests--;
        }

    }
}
