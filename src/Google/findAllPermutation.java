package Google;

import java.util.ArrayList;

/**
 * Created by anhtran on 10/9/17.
 */
public class findAllPermutation {
    public static ArrayList<String> permute(String s) {
        ArrayList<String> perms = new ArrayList<>();
        if(s.length() <= 1) {
            perms.add(s);
            return perms;
        }
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String noCh = s.substring(0,i) + s.substring(i+1);
            ArrayList<String> subPerms = permute(noCh);
            for(String sP: subPerms) {
                perms.add(new String(ch+sP));
            }
        }
        return perms;
    }
    public static void main(String[] args) {
        ArrayList<String> perms = permute("123");					// Line 2
        for (String s : perms) {
            System.out.println(s);
        }
    }
}
