import com.sun.jdi.InvalidTypeException;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anhtran on 9/11/17.
 */
public class isomorphic {

    public static boolean isIsomorphic(String s, String t) throws InvalidTypeException {
        if(s == null || t == null){
            throw new InvalidTypeException("Input needs to be a string");
        }
        if(s.length() == 1 && t.length()== 1){
            return true;
        }
//        HashMap<Character, Character> mapS = new HashMap<Character,Character>();
//        HashMap<Character, Character> mapT = new HashMap<Character,Character>();
//        for(int i = 0; i < s.length(); i++){
//            char curS = s.charAt(i);
//            char curT = t.charAt(i);
//            if(!mapS.containsKey(curS) && !mapT.containsKey(curT)){
//                mapS.put(curS,curT);
//                mapT.put(curT,curS);
//            }
//            if(mapS.get(curS) != curT){
//                return false;
//            }
//            if(mapT.get(curT) != curS) {
//                return false;
//            }
//        }
        HashMap<Character, Character> map = new HashMap<Character,Character>();
        for(int i = 0; i < s.length(); i++){
            char curS = s.charAt(i);
            char curT = t.charAt(i);
            if(map.containsKey(curS)){
                if(curS != curT){
                    return false;
                }
            }
            if(map.containsValue(curT)){
                return false;
            }
            map.put(curS,curT);
        }

        return true;

    }
    public static void main(String[] args) throws InvalidTypeException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        System.out.println(isIsomorphic(s, t));
    }
}
