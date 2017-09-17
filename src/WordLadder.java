import java.util.*;

/**
 * Created by anhtran on 9/11/17.
 */
public class WordLadder {
    private static class WordNode{
        public String word;
        public int step;
        public WordNode(String word, int step){
            this.word = word;
            this.step = step;
        }
    }

    public static int countStep(String startWord, String endWord, HashSet<String> dict){
        Queue<WordNode> curWords = new LinkedList<WordNode>();
        curWords.add(new WordNode(startWord,1));
        dict.add(endWord);
        //HashSet<String> visited = new HashSet<>();

        while(!curWords.isEmpty()){
            WordNode cur = curWords.poll();
            String curWord = cur.word;
            System.out.println(curWord);
            //visited.add(curWord);

            if(curWord.equals(endWord)){
                System.out.println("executed");
                return cur.step;
            }

            char[] wordArr = curWord.toCharArray();
            for(int i = 0; i < wordArr.length; i++){
                char temp = wordArr[i];
                for(char c = 'a'; c <= 'z'; c++){
                    if(wordArr[i] != c){
                        wordArr[i] = c;
                    }

                    String newWord = new String(wordArr);
                    if(dict.contains(newWord)) {
                        curWords.offer(new WordNode(newWord, cur.step + 1));
                        //visited.add(newWord);
                        dict.remove(newWord);
                    }
                    wordArr[i] = temp; //if dict does not
                                        // contain the new word,
                                        //change back to the current char in the word from queue
                }
            }
        }
        return 0;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String startWord = sc.next();
        String endWord = sc.next();
        HashSet<String> dict = new HashSet<String>();
        while(sc.hasNext()){
            dict.add(sc.next());
        }
        System.out.println(countStep(startWord,endWord,dict));
//        for(String s: dict){
//            System.out.println(s);
//        }
    }

}
