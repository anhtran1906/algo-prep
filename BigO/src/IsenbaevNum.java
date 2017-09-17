import java.util.*;

/**
 * Created by anhtran on 7/8/17.
 */
public class IsenbaevNum {

    static class Teammate implements Iterable {
        static String name;
        static boolean visited;
        static int count;
        static Set<String> teammates;

        public Teammate() {
            this.name = "";
            this.count = -1;
            this.visited= false;
            this.teammates = new HashSet<String>();
        }

        public void setVisited(){
            this.visited = true;
        }
        public void addTeammate(String s){
            teammates.add(s);
        }
        @Override
        public Iterator<String> iterator() {
            return teammates.iterator();
        }
    }

    public static int findMax(Map<String,Integer> map){
        int max =0;
        for(Map.Entry<String, Integer> teammate: map.entrySet()){
            if(teammate.getValue() > max){
                max = teammate.getValue();
            }
        }
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numTeam = sc.nextInt();
        Map<String,Teammate> map = new TreeMap<>();
        ArrayList<Set<String>> listTeammate = new ArrayList<>();


        for(int i = 0; i < numTeam; i++){
            String[] teammates = sc.nextLine().split(" ");
            for(String s: teammates){
                map.put(s,new Teammate());
            }
        }

//        for(Map.Entry<String, Integer> teammate: map.entrySet()){
//            if(teammate.getKey().equals("Isenbaev")){
//                teammate.setValue(0);
//            }
//        }

    }
}
