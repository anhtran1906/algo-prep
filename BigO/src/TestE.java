import java.util.*;

/**
 * Created by anhtran on 6/24/17.
 */
public class TestE {
    private static class Pair<K,V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
    }

    private static class PairComparator implements Comparator<Pair<Integer,Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            return o1.getKey() -o2.getKey();
        }
    }
    private static class AdjacencyList {
        private LinkedList<Pair<Integer, Integer>> [] adjacencyList;
        public AdjacencyList(int vertices) {
            adjacencyList = (LinkedList< Pair<Integer, Integer> >[]) new LinkedList[vertices];
            for (int i = 0; i < adjacencyList.length; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int startV, int endV, int weight) {
            adjacencyList[startV].add(new Pair<>(endV,weight));
        }
        public int getNumVertices() {
            return adjacencyList.length;
        }
        public int getNumEdgesFromVertex(int startV) {
            return adjacencyList[startV].size();
        }
        public LinkedList<Pair<Integer,Integer>> getEdgesFromVertex(int startVertex) {
            LinkedList<Pair<Integer,Integer>> edgeList
                    = (LinkedList<Pair<Integer,Integer>>) new LinkedList(adjacencyList[startVertex]);
            return edgeList;
        }
        public void printList() {
            int i = 0;
            for (LinkedList<Pair<Integer, Integer>> list : adjacencyList) {
                System.out.println("adjacencyList[" + i + "] -> ");
                for (Pair<Integer, Integer> edge : list) {
                    System.out.println(edge.getKey() + "(" + edge.getValue() + ")");
                }
                i++;
                System.out.println();
            }
        }
    }

    private static void dijkstra (int source, AdjacencyList graph, int[] distance, int[] path) {
        PairComparator comparator = new PairComparator();
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<Pair<Integer,Integer>>(10, comparator);
        queue.offer(new Pair(0,source));
        distance[source] = 0;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> top = queue.poll();
            int dest = top.getValue();
            int dist = top.getKey();
            for(int i = 0; i < graph.getNumEdgesFromVertex(dest); i++ ){
                Pair<Integer, Integer> neighbor = graph.getEdgesFromVertex(dest).get(i);
                if (dist + neighbor.getValue() < distance[neighbor.getKey()]) {
                    distance[neighbor.getKey()] = dist + neighbor.getValue();
                    queue.offer(new Pair(distance[neighbor.getKey()], neighbor.getKey()));
                    path[neighbor.getKey()] = dest;
                }
            }
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int i = 1;

        while (i <= tests) {
            System.out.println("Case " + i + ":");
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            int[] path = new int[n];
            Arrays.fill(path, -1);

            AdjacencyList graph = new AdjacencyList(n); //num of vertices

            while (m > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int fee = sc.nextInt();
                graph.addEdge(u, v, fee);
                graph.addEdge(v, u, fee);
                m--;
            }

            int source = sc.nextInt();
            dijkstra(source,graph, distance, path);

            for(int j: distance) {
                if (j == Integer.MAX_VALUE) {
                    System.out.println("Impossible");
                }
                else {
                    System.out.println(j);
                }
            }
            i++;
        }
    }
}
