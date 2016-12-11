import java.util.*;

/**
 * Created by rahilvora on 12/5/16.
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 For example,
 Given the following words in dictionary,

 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".

 Algorithm
 1. Create Degree map
    w : 0
    r : 0
    t : 0
    f : 0
    e : 0
 2.Now Compare two words char by char, and when it hits diff char create a set and store it in a map
    t : <f>
    w : <e>
    r : <t>
    e : <r>
    Here, set signifies the char which should be after the key i.e. f should be after t.
    Simultaneously, update degree map. When ever a char is added to set its corresponding degree map count should be increased.
    So, degree map would look like this
    w : 0
    r : 1
    t : 1
    f : 1
    e : 1

 3. Next Step is to create queue and store key with value 0 in degree map

 4. Now, pop values from queue append into result

 5. if Poped values consist of set, decreament the count of each char of set in degree map and when count hits 0 add it to queue

 */
public class AlienOrder {
    public static void main(String[] args){
        String[] words = {"wrtkj", "wrt"};
        System.out.print(new AlienOrder().ao(words));
    }
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        StringBuffer result = new StringBuffer("");
        if (words == null || words.length == 0) return result.toString();
        for(String word: words){
            for (char c:
                 word.toCharArray()) {
                degree.put(c,0);
            }
        }

        for(int i = 0 ; i < words.length - 1; i++){
            String curr = words[i];
            String next = words[i + 1];
            int length  = Math.min(curr.length(), next.length());
            for(int j = 0; j < length; j++){
                char c1 = curr.charAt(j);
                char c2 = next.charAt(j);
                if(c1 != c2){
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(c1)) set = map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for(char c : degree.keySet()){
            if(degree.get(c) == 0){
                queue.add(c);
            }
        }

        while(!queue.isEmpty()){
            char c = queue.remove();
            result.append(c);
            if(map.containsKey(c)){
                for(char character : map.get(c)){
                    degree.put(character, degree.get(character) - 1);
                    if(degree.get(character) == 0)
                        queue.add(character);
                }
            }
        }

        if(result.length() != degree.size()) return "";

        return result.toString();
    }

    public String ao(String[] words){
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
}
