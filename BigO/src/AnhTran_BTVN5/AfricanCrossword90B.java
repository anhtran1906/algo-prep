import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by anhtran on 6/9/17.
 */
public class AfricanCrossword90B {
    private static class CrossWord {
        private char c;
        private boolean checked;
        public CrossWord(char c) {
            this.c = c;
            checked = false;

        }
        private void setChar(char c){
            this.c = c;
        }
        private void setChecked(boolean checked){
            this.checked = checked;
        }
        private char getChar(){
            return this.c;
        }
        private boolean check() {
            return this.checked;
        }
    }

    private static String solveWord(CrossWord[][] grid, int n, int m) {
        StringBuilder result = new StringBuilder();
        for(int row = 0; row < n; row++) {
            HashMap<Character, ArrayList<Integer>> crossedOutRow = new HashMap<Character,ArrayList<Integer>>();
            for(int col = 0; col < m; col++) {
                if(crossedOutRow.containsKey(grid[row][col].getChar())){
                    ArrayList<Integer> curIndices = crossedOutRow.get(grid[row][col].getChar());
                    grid[curIndices.get(0)][curIndices.get(1)].setChecked(true);
                    grid[row][col].setChecked(true);
                    crossedOutRow.remove(grid[row][col].getChar());
                    ArrayList<Integer> newIndices = new ArrayList<Integer>();
                    newIndices.add(row);
                    newIndices.add(col);
                    crossedOutRow.put(grid[row][col].getChar(),newIndices);
                }
                else {
                    ArrayList<Integer> indices = new ArrayList<Integer>();
                    indices.add(row);
                    indices.add(col);
                    crossedOutRow.put(grid[row][col].getChar(),indices);
                }
            }

        }

        for(int col = 0; col < m; col++) {
            HashMap<Character, ArrayList<Integer>> crossedOutCol = new HashMap<Character,ArrayList<Integer>>();
            for(int row = 0; row < n; row++) {
                char cur = grid[row][col].getChar();
                if (crossedOutCol.containsKey(cur)) {
                    ArrayList<Integer> curIndices = crossedOutCol.get(cur);
                    grid[curIndices.get(0)][curIndices.get(1)].setChecked(true);
                    grid[row][col].setChecked(true);
                    crossedOutCol.remove(cur);
                    ArrayList<Integer> newIndices = new ArrayList<Integer>();
                    newIndices.add(row);
                    newIndices.add(col);
                    crossedOutCol.put(cur,newIndices);
                }
                else {
                    ArrayList<Integer> indices = new ArrayList<Integer>();
                    indices.add(row);
                    indices.add(col);
                    crossedOutCol.put(cur,indices);
                }
            }
        }

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++) {
                if(!grid[row][col].check()) {
                    result.append(grid[row][col].getChar());
                }
            }
        }
        return result.toString();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        CrossWord[][] grid = new CrossWord[n][m];
        while(sc.hasNext()) {
            for(int row = 0; row < grid.length; row++){
                String line = sc.next();
                for(int col = 0; col < grid[row].length; col++) {
                    grid[row][col] = new CrossWord(line.charAt(col));
                }
            }
        }
        System.out.println(solveWord(grid, n, m));
    }
}