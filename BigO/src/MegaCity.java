import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by anhtran on 7/10/17.
 */
public class MegaCity {
    public static final int MEGA_CITY_POP = 1000000;
    private static class Coordinates {
        static double x;
        static double y;
        public Coordinates(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double distance(double x, double y){
        double sum = Math.pow(x,2) + Math.pow(y,2);
        return Math.sqrt((sum));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int loc = sc.nextInt();
        int pop = sc.nextInt();
        Map<Coordinates,Integer> locatons = new TreeMap<>();
        for(int i = 0; i < loc; i++){
            Coordinates c = new Coordinates(sc.nextDouble(), sc.nextDouble());
            locatons.put(c,sc.nextInt());
        }

        //System.out.println(distance(Math.pow(x,y),Math.pow(z,w)));
    }
}
