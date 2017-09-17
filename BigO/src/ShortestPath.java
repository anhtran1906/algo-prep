import java.util.*;

/**
 * Created by anhtran on 6/21/17.
 */
public class ShortestPath {
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

        private LinkedList<Pair<Pair<String,Integer>, Integer>> [] adjacencyList;

        public AdjacencyList(int vertices) {
            adjacencyList = (LinkedList<Pair<Pair<String, Integer>, Integer>>[]) new LinkedList[vertices];
            for (int i = 0; i < adjacencyList.length; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int startV, String name, int endV, int weight) {
            Pair<String, Integer> keyMap = new Pair(name,endV);
            adjacencyList[startV].add(new Pair<>(keyMap,weight));
        }
        public int getNumVertices() {
            return adjacencyList.length;
        }
        public int getNumEdgesFromVertex(int startV) {
            return adjacencyList[startV].size();
        }
        public  LinkedList<Pair<Pair<String,Integer>, Integer>> getEdgesFromVertex(int startVertex) {
            LinkedList<Pair<Pair<String,Integer>, Integer>> edgeList
                    = (LinkedList<Pair<Pair<String,Integer>, Integer>>) new LinkedList(adjacencyList[startVertex]);
            return edgeList;
        }
        public void printList() {
            int i = 0;
            for (LinkedList<Pair<Pair<String,Integer>, Integer>> list : adjacencyList) {
                System.out.println("adjacencyList[" + i+1 + "] -> ");
                for (Pair<Pair<String,Integer>, Integer> edge : list) {
                    System.out.println("name: " + edge.getKey().getKey() + "endV " + edge.getKey().getValue()  + "(" + edge.getValue() + ")");
                }
                i++;
                System.out.println();
            }
        }
    }

//    private static void dijkstra (int source, AdjacencyList graph, int[] distance, int[] path) {
//        PairComparator comparator = new PairComparator();
//        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<Pair<Integer,Integer>>(10, comparator);
//        queue.offer(new Pair(0,source));
//        distance[source] = 0;
//
//        while (!queue.isEmpty()) {
//            Pair<Integer, Integer> top = queue.poll();
//            int dest = top.getValue();
//            int dist = top.getKey();
//            for(int i = 0; i < graph.getNumEdgesFromVertex(dest); i++ ){
//                Pair<Integer, Integer> neighbor = graph.getEdgesFromVertex(dest).get(i);
//                if (dist + neighbor.getValue() < distance[neighbor.getKey()]) {
//                    distance[neighbor.getKey()] = dist + neighbor.getValue();
//                    queue.offer(new Pair(distance[neighbor.getKey()], neighbor.getKey()));
//                    path[neighbor.getKey()] = dest;
//                }
//            }
//        }
//
//    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        int numCities = sc.nextInt();
        int[] distance = new int[505];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int[] path = new int[numCities];
        Arrays.fill(path,-1);

        AdjacencyList graph = new AdjacencyList(10005);
        int startV = 1;
        while (numTest > 0) {
            String name = sc.next();
            int numNeighbors = sc.nextInt();
            int endV = sc.nextInt();
            int fee = sc.nextInt();
            Pair<String, Integer> keyMap = new Pair(name,endV);
            graph.addEdge(startV,name,endV,fee);
            graph.addEdge(endV,name,startV,fee);
            numTest--;
        }

        graph.printList();


//        int source = sc.nextInt();
//        int queries = sc.nextInt();
//
//        dijkstra(source,graph, distance, path);
//        while (queries > 0) {
//            int dest = sc.nextInt();
//            if (distance[dest] == Integer.MAX_VALUE) {
//                System.out.println("NO PATH");
//            }
//            else {
//                int result = distance[dest];
//                System.out.println(result);
//            }
//            queries--;
//
//        }

    }
}
