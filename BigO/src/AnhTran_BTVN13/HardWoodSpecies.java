import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by anhtran on 7/7/17.
 */
public class HardWoodSpecies {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());
        TreeMap<String,Integer> list = new TreeMap<String,Integer>();
        for(int i = 0; i < tests; i++){
            String line;
            int count = 0;
            while((line= br.readLine()) != null) {
                if (line.length() == 0) {
                    line = br.readLine();
                }
                if (!list.containsKey(line)) {
                    list.put(line, 1);
                } else {
                    int cur = list.get(line);
                    list.put(line, cur + 1);
                }
                count++;
            }

            for(Map.Entry<String, Integer> map: list.entrySet()) {
                System.out.println(count);
                double result = (double)map.getValue()*100/count;
                String percent = String.format("%.4f", result);
                System.out.println(map.getKey().toLowerCase() + " " + percent);
            }
            System.out.println();
        }
    }
}
