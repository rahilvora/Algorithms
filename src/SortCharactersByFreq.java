import java.util.*;

/**
 * Created by rahilvora on 11/8/16.
 */
public class SortCharactersByFreq {
    public static void main(String[] args){
        System.out.print(new SortCharactersByFreq().frequencySort("abaccadeeefaafcc"));
    }
    public String frequencySort(String s) {
        Map<Character, Integer> alphabet = new HashMap<>();
        for (char letter : s.toCharArray()) {
            alphabet.put(letter, alphabet.getOrDefault(letter, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(alphabet.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());
        StringBuilder sorted = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sorted.append(entry.getKey());
            }
        }
        return sorted.toString();
    }
}
