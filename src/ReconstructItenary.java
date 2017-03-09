import java.util.*;

/**
 * Created by rahilvora on 1/17/17.
 */
public class ReconstructItenary {

    public List<String> findItinerary(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        if(tickets.length == 0) return answer;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(int i = 0; i < tickets.length; i++){
            PriorityQueue<String> queue = new PriorityQueue<>();
            if(map.containsKey(tickets[i][0])){
                queue = map.get(tickets[i][0]);
            }
            queue.add(tickets[i][1]);
            map.put(tickets[i][0],queue);
        }
        String source = "JFK";
        answer.add(source);
        while(!map.isEmpty()){
            if(map.containsKey(source)){
                String Newsource = map.get(source).poll();
                answer.add(Newsource);
                if(map.get(source).size() == 0){
                    map.remove(source);
                }
                if(map.containsKey(Newsource))
                    source = Newsource;
            }

        }
        return answer;
    }

    public List<String> findItineraryII(String[][] tickets){
        List<String> route = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(int i = 0; i < tickets.length; i++){
            PriorityQueue<String> queue = new PriorityQueue<>();
            if(map.containsKey(tickets[i][0])){
                queue = map.get(tickets[i][0]);
            }
            queue.add(tickets[i][1]);
            map.put(tickets[i][0],queue);
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
    public static void main(String args[]){
        String[][] cities = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};

        new ReconstructItenary().findItineraryII(cities);
    }
}
