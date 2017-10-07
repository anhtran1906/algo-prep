package Intuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by anhtran on 9/25/17.
 */
public class groupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();

        if(strs.length == 0 || strs == null){
            return result;
        }

        HashMap<String,List<String>> map = new HashMap<String,List<String>>();

        for(String s: strs){
            char[] cur = s.toCharArray();
            Arrays.sort(cur);
            String key = String.valueOf(cur);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
            List<String> val = map.get(key);

            map.put(key,val);
        }

        for(String key: map.keySet()){
            result.add(map.get(key));
        }

        return result;

    }
}
