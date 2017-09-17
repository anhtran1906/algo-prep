import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by anhtran on 9/16/17.
 */
public class knapsackProblem {
    private static class Item {
        public int weight;
        public int value;
        public Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }
    public static long ks(int itemsLeft, int capacity, ArrayList<Item> list){
        long leaveValue = 0;
        long takeValue = 0;

        if(itemsLeft == 0){
            return 0;
        }
        if(capacity - list.get(itemsLeft-1).weight >= 0){
            leaveValue = ks(itemsLeft -1, capacity,list);
            takeValue = list.get(itemsLeft -1).value +
                    ks(itemsLeft -1, capacity -list.get(itemsLeft-1).weight,list);

        }
        return Math.max(takeValue, leaveValue);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numItem = sc.nextInt();
        int capacity = sc.nextInt();
        ArrayList<Item> list = new ArrayList<>();
        for(int i = 0; i < numItem; i++){
            list.add(new Item(sc.nextInt(), 0));
        }
        for(int i = 0; i < numItem; i++){
            list.get(i).value = sc.nextInt();
        }
        System.out.println(ks(numItem, capacity,list));

    }

}
