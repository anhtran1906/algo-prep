import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anhtran on 5/31/17.
 */
public class ChoresA {

    public static int getX (int[] chores, int choreNum, int pNum, int vNum) {
        Arrays.sort(chores);
        if(chores[vNum] - chores[vNum-1] < 0) {
            return 0;
        }
        else {
            return chores[vNum] - chores[vNum-1];

        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int choreNum = s.nextInt();
        int pNum = s.nextInt();
        int vNum = s.nextInt();
        int[] chores = new int[choreNum];

        for(int i = 0; i < choreNum; i++){
            chores[i] = s.nextInt();
        }
        System.out.println(getX(chores,choreNum,pNum,vNum));
    }
}
