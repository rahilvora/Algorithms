import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rahilvora on 7/26/16.
 */
public class AllPermutationsOfString {
    public static void main(String args[]){
        AllPermutationsOfString obj = new AllPermutationsOfString();
        obj.permute("AABC".toCharArray()).forEach(s -> System.out.println(s));
    }

    public List<String> permute(char[] input){
        Map<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < input.length; i++){
            if(map.containsKey(input[i])){
                map.put(input[i],map.get(input[i]) + 1);
            }
            else {
                map.put(input[i],1);
            }
        }

        int[] count = new int[map.size()];
        char[] str = new char[map.size()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char[] result = new char[input.length];

        permuteUtil(str, count, result,0,resultList);
        return resultList;
    }
    public void permuteUtil(char[] str, int[] count, char[] result, int level,List<String> resultList){
        if(level == result.length){
            resultList.add(new String(result));
            return;
        }
        for(int i = 0; i < str.length; i++){
            if(count[i] == 0){
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level+1, resultList);
            count[i]++;
        }
    }
}
