package Intuit;

/**
 * Created by anhtran on 9/25/17.
 */
public class anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //true if all chars in s are in t and same frequency
//       HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
//       HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();

//       for(int i =0; i < s.length(); i++){
//         if(!mapS.containsKey(s.charAt(i))) {
//           mapS.put(s.charAt(i),0);
//         }
//         if(!mapT.containsKey(t.charAt(i))){
//             mapT.put(t.charAt(i),0);
//         }
//         mapS.put(s.charAt(i),mapS.get(s.charAt(i)) + 1);
//         mapT.put(t.charAt(i),mapT.get(t.charAt(i)) + 1);
//     }

//       for(Character c: mapS.keySet()){
//         if(!mapT.containsKey(c) || mapT.get(c) != mapS.get(c)){
//           return false;
//         }
//       }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
