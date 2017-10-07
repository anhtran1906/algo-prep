package Intuit;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class intuit {

    /*Anh Tran- Dickinson College graduating in May 2018
    Applying for full-time positions
    */
    public static List<List<Integer>> groupByNumberOfParents(List<List<Integer>> parentChildPairs) {
        // IMPLEMENTATION GOES HERE

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(List<Integer> list: parentChildPairs){
            int parent = list.get(0);
            int child = list.get(1);
            if(!map.containsKey(child)){
                map.put(child,0);
            }
            if(!map.containsKey(parent)){
                map.put(parent,0);
            }
            map.put(child,map.get(child)+1);
        }

        ArrayList<Integer> zeroPar = new ArrayList<Integer>();
        ArrayList<Integer> onePar = new ArrayList<Integer>();
        ArrayList<Integer> twoPar = new ArrayList<Integer>();

        for(int key: map.keySet()){
            if(map.get(key) == 0){
                zeroPar.add(key);
            }
            if(map.get(key) == 1){
                onePar.add(key);
            }
            if(map.get(key) == 2){
                twoPar.add(key);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(zeroPar);
        Collections.sort(onePar);
        Collections.sort(twoPar);
        result.add(zeroPar);
        result.add(onePar);
        result.add(twoPar);

        return result;
    }

  /* START TEST CASES
   * You can add test cases below. Each test case input/expected output
   * should correspond to the same index in the respective lists returned.
   */

    static List<List<List<Integer>>> testInputs = Arrays.asList(
            Arrays.asList(
                    Arrays.asList(1, 3),
                    Arrays.asList(2, 3),
                    Arrays.asList(3, 6),
                    Arrays.asList(5, 6),
                    Arrays.asList(5, 7),
                    Arrays.asList(4, 5),
                    Arrays.asList(4, 8),
                    Arrays.asList(8, 9)
            ),
            Arrays.asList(
                    Arrays.asList(1, 3),
                    Arrays.asList(2, 3)
            )
    );

    static List<List<List<Integer>>> testOutputs = Arrays.asList(
            Arrays.asList(
                    Arrays.asList(1, 2, 4),
                    Arrays.asList(5, 7, 8, 9),
                    Arrays.asList(3, 6)
            ),
            Arrays.asList(
                    Arrays.asList(1, 2),
                    Arrays.asList(),
                    Arrays.asList(3)
            )
    );

  /* END TEST CASES */

    // DO NOT MODIFY BELOW THIS LINE

    public static boolean equalOutputs(List<List<Integer>> a, List<List<Integer>> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            List<Integer> a1 = a.get(i);
            List<Integer> b1 = b.get(i);
            a1.sort(null);
            b1.sort(null);
            if (!a1.equals(b1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < testInputs.size(); i++) {
            List<List<Integer>> expectedOutput = testOutputs.get(i);
            List<List<Integer>> actualOutput = groupByNumberOfParents(testInputs.get(i));
            if (equalOutputs(expectedOutput, actualOutput)) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
        }
    }
}
