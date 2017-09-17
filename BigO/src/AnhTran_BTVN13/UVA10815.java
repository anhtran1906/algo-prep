import java.util.*;

/**
 * Created by anhtran on 7/7/17.
 */
public class UVA10815 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String line,cur;
        cur = "";
        line="";
        Set<String> dictionary = new HashSet<String>();
        ArrayList<String> list = new ArrayList<String>();
        //sc.useDelimiter(",|\n");
        while(sc.hasNext()){
            line = sc.nextLine();
            for(int i = 0; i < line.length();i++){
                char c = line.charAt(i);
                if(Character.isLetter(c)){
                    cur+=c;
                }
                else if(Character.isSpaceChar(c)){
                    dictionary.add(cur.toLowerCase());
                    cur="";
                }
                else if(c == '\n') {
                    dictionary.add(cur.toLowerCase());
                    cur="";
                }
                else {
                    if(cur.length() > 0){
                        dictionary.add(cur.toLowerCase());
                    }
                    cur="";
                }
            }
            if(cur.length() > 0){
                dictionary.add(cur.toLowerCase());
                cur = "";
            }
        }
        sc.close();
        list.addAll(dictionary);
        Collections.sort(list);
        for(String s: list){
            System.out.println(s);
        }

    }
}
