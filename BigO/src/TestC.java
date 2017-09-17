import java.util.Scanner;

/**
 * Created by anhtran on 6/24/17.
 */
public class TestC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long costFirst = sc.nextInt();
        long initialMoney = sc.nextInt();
        long num = sc.nextLong();

        long i = 1;
        long total = 0;

        while (i <= num) {
            total += i * costFirst;
            i++;
        }

        System.out.println(Math.max(total - initialMoney, 0));
    }
}

