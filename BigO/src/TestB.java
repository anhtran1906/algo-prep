import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by anhtran on 6/24/17.
 */
public class TestB {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Character,Integer> chars = new HashMap<Character,Integer>();
        for(char c: alphabet.toCharArray()){
            chars.put(c,0);
        }
        boolean result = true;

        int numChar = sc.nextInt();
        char[] arr = sc.next().toLowerCase().toCharArray();
        int i = 0;
        while(i < arr.length){
            if(chars.containsKey(arr[i])) {
                chars.put(arr[i],1);
            }
            i++;
        }
        for(int val: chars.values()){
            if (val==0){
                result=false;
                break;
            }
        }

        if (result){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        };

    }
}
