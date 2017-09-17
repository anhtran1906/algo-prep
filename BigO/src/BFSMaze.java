import java.util.Scanner;

/**
 * Created by anhtran on 6/15/17.
 */
public class BFSMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int width = sc.nextInt();
        int height = sc.nextInt();
        String[][] maze = new String[width][height];
        int numTest = 0;
        while (numTest < tests && sc.hasNext()) {
            for(int row = 0; row < maze.length; row++) {
                for(int col = 0; col < maze[row].length; col++) {
                    maze[row][col] = sc.next();
                }
            }
            numTest++;
        }

        System.out.println(maze.toString());
    }
}
