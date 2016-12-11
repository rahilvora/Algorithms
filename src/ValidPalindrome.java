import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rahilvora on 8/31/16.
 */
public class ValidPalindrome {
    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("invest");
        list.add("in");
        list.add("the");
        list.add("peanut");
        list.add("butter");
        list.add("industry");
        //System.out.print(new ValidPalindrome().restoreSpaces("investinthepeanutbutterindustry", list));
        System.out.print(new ValidPalindrome().maxDepth("(((3)))"));
    }
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        s = s.replaceAll("([^a-zA-Z0-9]|\\s)+", "");
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static void rotate(List<List<Character>> matrix) {
        int n = matrix.size();
        int f = (int) Math.floor(n/2);
        int c = (int) Math.ceil(n/2);

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {

                char temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(n-1-j).get(i));
                matrix.get(n - 1 -j).set(i, matrix.get(n-1-i).get(n-1-j));
                matrix.get(n-1-i).set(n-1-j, matrix.get(j).get(n-1-i));
                matrix.get(j).set(n-1-i, temp);
            }
        }
    }

    static String restoreSpaces(String inputString, List<String> dictionary) {
        int len = 1, i=0;
        StringBuffer sb = new StringBuffer("");
        while(i < inputString.length()) {
            if(dictionary.contains(inputString.substring(i, i + len))) {
                sb.append(inputString.substring(i, i + len) + " ");
                i = i+len;
                len = 1;
            } else {
                len++;
            }
        }
        return sb.toString().substring(0, sb.length() -1);
    }

    static int maxDepth(String expression) {
        int count = 0;
        int answer = 0;
        char[] arr = expression.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(arr[i]);
                count++;
            }
            else if(arr[i] == ')'){
                stack.pop();
                if(count > answer)
                answer = count;
                count--;
            }

        }

        return answer;

    }

    static int coveredDistance(List<int[]> lines) {
        int[] arr = lines.get(0);
        int start = arr[0];
        int end = arr[1];
        int len = end -  start;
        for(int i = 1; i < lines.size(); i++){
            arr = lines.get(i);
            if(end > arr[0]){
                if(end < arr[1]){
                    len += (arr[1] - end);
                    end = arr[1];
                }
            }
            else {
                start = arr[0];
                end = arr[1];
                len += end -  start;
            }

        }
        return len;
    }
    static String[] parseString(String str) {
        ArrayList<String> strArr = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        for(int i =0; i < str.length(); i++){

            if(str.charAt(i) == '\"'){
                temp.append(str.charAt(i));
                i++;
                while(str.charAt(i) != '\"' && i < str.length()){
                    temp.append(str.charAt(i));
                    i++;
                }
                if(str.charAt(i) == '\"')
                temp.append(str.charAt(i));
            }
            if(str.charAt(i) != ',')
                temp.append(str.charAt(i));
            else{
                strArr.add(temp.toString());
                temp = new StringBuffer("");
            }
        }
        String[] ans = new String[strArr.size()];
        for(int i = 0; i < strArr.size(); i++){
            ans[i] = strArr.get(i);
        }
        return ans;

    }
}
