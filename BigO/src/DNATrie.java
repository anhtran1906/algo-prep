import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anhtran on 7/19/17.
 */
public class DNATrie {
    private static class Node {
        private int NUMBER_OF_NUCLE = 4;
        private Node[] children = new Node[NUMBER_OF_NUCLE];;
        private boolean markLeaf;
        private int numWord; //count of visited times of this node (number of words that have this char)

        public Node() {
            markLeaf = false;
            numWord = 0;
            for (int i = 0; i < NUMBER_OF_NUCLE; i++) {
                children[i] = null;
            }
        }
    }

    private static class Trie {
        private static Node root;
        public Trie(){
            root = new Node();
        }
        private int getNodeLevel(char c){
            if(c == 'A') {
                return 0;
            }
            if (c == 'C'){
                return 1;
            }
            if (c == 'G'){
                return 2;
            }
            return 3;
        }

        private static boolean isLeaf(Node node){
            return node.markLeaf;
        }

        private void add(String s) {
            Node temp = root;
            for (int i = 0; i < s.length(); i++) {
                int level = getNodeLevel(s.charAt(i));
                if (temp.children[level] == null) {
                    temp.children[level] = new Node();
                }
                temp = temp.children[level];
                temp.numWord++;
            }
            temp.markLeaf = true;
        }

        private int searchTrie(String s){
            Node temp = root;
            int result = 0;
            for(int i = 0; i < s.length(); i++){
                int level = getNodeLevel(s.charAt(i));
                temp = temp.children[level];
                result=max(temp.numWord*(i+1),result); //i+1 is the number of prefix at temp or depth
            }
            return result;
        }

        private void delete(Node node){
            for(int i = 0; i < node.NUMBER_OF_NUCLE; i++){
                if(node.children[i] != null){
                    delete(node.children[i]);
                }
            }
            delete(node);
        }
    }

    public static class FastInput {
        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastInput(InputStream in)
        {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public long nextLong() throws Exception
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        //reads in the next string
        public String next() throws Exception
        {
            StringBuilder ret =  new StringBuilder();
            byte c = read();
            while (c <= ' ') c = read();
            do
            {
                ret = ret.append((char)c);
                c = read();
            } while (c > ' ');
            return ret.toString();
        }

        public int nextInt() throws Exception
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws Exception
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws Exception
        {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }

    public static int max(int a, int b){
        return a>b? a: b;
    }


    public static void main(String[] args) throws Exception {
        FastInput sc = new FastInput(System.in);
        int tests = sc.nextInt();
        for(int i = 0; i < tests; i++){
            int numDNA = sc.nextInt();
            Trie trie = new Trie();
            String[] list = new String[numDNA];
            int result = 0;
            for(int j = 0; j < numDNA; j++){
                list[j] = sc.next();
            }
            for(String s: list){
                trie.add(s);
            }
            for(String s: list){
                result = max(result,trie.searchTrie(s));
            }
            System.out.println("CASE " + (i+1) + ": " + result);
        }
    }
}
