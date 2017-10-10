package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anhtran on 10/9/17.
 *
 * Given a smaller string s and a bigger string b, design an algorithm
 * to find all permutations of the shorter string within the longer one.
 * Print the location of each permutation.

 */
public class findPermInLongerString {
    public static ArrayList<Integer> findPerm(String s, String b) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < b.length()-s.length(); i++) {
            String cur = b.substring(i,i+s.length());
            if (isPermutationOfS(cur,s)) {
                list.add(i);
            }
        }
        String cur = b.substring(b.length()-4,b.length());
        if (isPermutationOfS(cur,s)) {
            list.add(b.length()-s.length());
        }
        return list;
    }
    //s = abbc   cur=abbc
    //a hashmapS to store each char with its frequency
    //go through each key in mapCur
    //
    //
    private static boolean isPermutationOfS(String cur, String s) {
        if(cur.length() != s.length()) {
            return false;
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapCur = new HashMap<>();
        setMap(mapS, s);
        setMap(mapCur, cur);
        for(Character key: mapS.keySet()) {
            if (!mapCur.containsKey(key) || mapCur.get(key) != mapS.get(key)) {
                return false;
            }
        }
        return true;
    }

    private static void setMap(HashMap<Character, Integer> map, String s) {
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String b = sc.next();
        ArrayList<Integer> list = findPerm(s,b);
        for(int i: list) {
            System.out.println(i);
        }
    }


}
