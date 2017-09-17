import java.util.Scanner;

/**
 * Created by anhtran on 9/7/17.
 */
public class ReverseWordsInString {

    static void reverse(String input, int i , int j){
        char[] chars = input.toCharArray();
        while(i<j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        input = String.valueOf(chars);
        System.out.println(input);
    }
    static void reverseWords(String input){
        int i = 0; //keep track of the first index of each word
        int j = 0; //keep track of the each index in the input string

        while(j < input.length()){ //does not reverse the last word
            if(Character.isWhitespace(input.charAt(j))) {
                reverse(input, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(input,i, input.length()-1);
        reverse(input, 0, input.length()-1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        reverseWords(input);
        System.out.println(input);
    }
}
