import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by anhtran on 9/18/17.
 */

// s = "Nguyen Khoi Dinh " => 3 words
// s = "Nguyen Khoi1 Dinh" => 2 words

// s="NguyenKhoiDing" => 1
// s="nguyenkhoidinh!" => 0

// - hashset of alphabet chars from a-z
// count = 0;
// - loop thru the string
//   if curChar not contain in map
//     skip
//   else
//     if charAt(i) == ' ' and i != s.lengt()-1
//       count++

//     if i == s.length()-1
//       if !charAt(i) == ' ' {count++}

//   return count


class WordInString {
    public static int countWords(String s) {
        s = s.trim();
        HashSet<Character> table = new HashSet<Character>();
        for (char i = 'a'; i <= 'z'; i++) {
            table.add(i);
        }
        int count = 0;
        int countBlank = 0;
        boolean flag = true;
        int j = 0;
        while (j < s.length()) {
            if(!table.contains(s.charAt(j)) && s.charAt(j) != ' ') {
                flag = false;
            }
            if(s.charAt(j) != ' '){
                countBlank = 0;
            }
            if(s.charAt(j) == ' ' && flag){
                countBlank++;
                if(countBlank == 1){
                    count++;
                }
            }
            if(j == s.length()-1 && flag) {
                count++;
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuffer input = new StringBuffer();
        while (sc.hasNext()) {
            input.append(sc.nextLine());
        }
        System.out.println(countWords(input.toString()));
    }
}
