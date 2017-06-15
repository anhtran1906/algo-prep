import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Created by anhtran on 6/9/17.
 */
public class HardWork61B {
//    private static HashSet<String> combine (ArrayList<String> initials) {
//        HashSet<String> res = new HashSet<String>();
//       for(int i = 0; i < initials.size(); i++){
//           String cur = initials.get(i);
//           for(int j = 0; j < initials.size(); j++){
//               if(!cur.equals(initials.get(j))) {
//                   res.add(new StringBuilder(cur).append(initials.get(j)).toString());
//                   res.add(new StringBuilder(initials.get(j)).append(cur).toString());
//               }
//           }
//       }
//       return res;
//    }
//    private static HashSet<String> merge (ArrayList<String> combines, String word) {
//        HashSet<String> res = new HashSet<String>();
//        for(String s: res) {
//            String cs = new StringBuilder(s).append(word).toString();
//            res.add(cs);
//        }
//        return res;
//    }

    private static String trimString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '_' && s.charAt(i) != '-' && s.charAt(i) != ';') {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 3;
        ArrayList<String> initials = new ArrayList<String>();
        HashSet<String> combines = new HashSet<String>();

        while(i > 0) {
            String line = sc.next().toLowerCase();
            line = trimString(line);
            initials.add(line);
            i--;
        }
//        for(String s: initials) {
//            System.out.println(s);
//        }

//        combines = combine(initials);
//        for(String s: combines) {
//            System.out.println(s);
//        }
        String a  = initials.get(0);
        String b = initials.get(1);
        String c = initials.get(2);

        combines.add(a+b+c);
        combines.add(a+c+b);
        combines.add(b+a+c);
        combines.add(b+c+a);
        combines.add(c+a+b);
        combines.add(c+b+a);

        int numStudent = sc.nextInt();
        while (numStudent > 0) {
            String answer = trimString(sc.next()).toLowerCase();
            if(combines.contains(answer)){
                System.out.println("ACC");
            }
            else {
                System.out.println("WA");
            }
            numStudent--;
        }

    }
}
