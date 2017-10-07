package Palantir;
import java.io.*;
import java.util.*;

/*
// Given a list of tickets (a ticket is represented as a [source, destination]), find the complete itinerary.
// Input: [[SFO, JFK], [LGA, ORD], [JFK, LGA], [JFK,LAX]]
// Output: [SFO, JFK, LGA, ORD]
// Conditions: The tickets are guaranteed to form one valid itinerary. No loops
    /*
    - path is valid and 1 path

    loop through the array
        for each sub array
            check if the source is in the map
                add the path to the result
            check if the destination is in the map
                 add the path to the result
    -
     add the path to the result:
 * Created by anhtran on 10/2/17.
 */
    public class tixSystem {

    public static ArrayList<String> findPath(String[][] input) {
        HashMap<String, String> sourceDest = new HashMap<>();
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < input.length; i++) {
            String[] cur = input[i];
            String curSource = cur[0];
            String curDest = cur[1];
            if (curSource != null && !sourceDest.containsKey(curSource)) {
                sourceDest.put(curSource, curDest);
            }
        }

        //sfo-> jfk, lga-> ord, jfk->lga,

        for (String key : sourceDest.keySet()) {
            System.out.println("key is" + key);
            String curDest = sourceDest.get(key);
            if (sourceDest.containsKey(curDest)) {
                if(!result.contains(key) && !result.contains(curDest) && !result.contains(sourceDest.get(curDest))){
                    result.add(key);
                    result.add(curDest);
                    result.add(sourceDest.get(curDest));
                }
            }
            if (result.size() > 0 && sourceDest.containsKey(result.get(result.size() - 1))) {
                result.add(sourceDest.get(result.get(result.size() - 1)));
            }
        }

        return result;
    }


    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] input = new String[n][2];
        int i = 0;

        while(i < n && sc.hasNext()) {
            String[] cur = new String[2];
            cur[0] = sc.next();
            cur[1] = sc.next();
            input[i] = cur;
            i++;
        }
        System.out.println(findPath(input));
    }
}