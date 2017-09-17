import java.util.Scanner;

/**
 * Created by anhtran on 7/7/17.
 */
public class BSTMonk {
    private static class Node {
        static int data;
        static Node left;
        static Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class BinarySearchTree {
        public static Node root;
        public BinarySearchTree(){
            this.root = null;
        }
        public boolean find(int data) {
            Node cur = root;
            while(cur!= null){
                if(cur.data == data ){
                    return true;
                }
                else if(cur.data < data){
                    cur=cur.left;
                }
                else{
                    cur=cur.right;
                }
            }
            return false;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if(root==null){
                root = newNode;
                return ;
            }
            Node current = root;
            Node parent = null;
            while(true){
                parent = current;
                if(data < current.data){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                    }
                    return ;
                }
                else {
                    current = current.right;
                    if(current==null){
                        parent.right = newNode;
                    }
                    return ;
                }
            }
        }
        public void display(Node root){
            if(root!=null){
                display(root.left);
                System.out.print(" " + root.data);
                display(root.right);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        while(tests > 0){
            int inClassNum = sc.nextInt();
            int comingNum = sc.nextInt();
            BinarySearchTree tree = new BinarySearchTree();
            while(inClassNum > 0){
                tree.add(sc.nextInt());
                inClassNum--;
            }
            //tree.display();
            while(comingNum > 0){
                if(tree.find(sc.nextInt())){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
                comingNum--;
            }
            tests--;
        }

    }

}
