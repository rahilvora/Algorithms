import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by rahilvora on 10/11/16.
 */
public class Solution1 {
    public static void main(String args[]){
        //new Solution1().rearrangeWord("hefg");
        //new Solution1().solution(1 ,8, 3, 2);
        Solution1.isPalindrome("abc");
    }
    static int ctr;
    static String rearrangeWord(String word) {
        String out = "";
        char[] aCArr = word.toCharArray();
        int aLen = aCArr.length;
        int swap2 = 0;
        for (int i = aLen-2; i>=0; i--){
            int index = i;
            char aVal = aCArr[index];

            for (int j = index+1; j <= aLen-1; j++){
                if (aVal < aCArr[j]){
                    int swap1 = i;
                    ctr = i;
                    int local = i;
                    char base = 'a';
                    int cnt = 1;
                    for (int m = local+1; m < aLen; m++){
                        if (aCArr[m] > aCArr[swap1] && aCArr[m] < base || cnt == 1){
                            base = aCArr[m];
                            swap2 = m;
                            cnt++;
                        }
                    }
                    char temp = aCArr[swap1];
                    aCArr[swap1] = aCArr[swap2];
                    aCArr[swap2] = temp;

                    for (char k:aCArr){
                        out = out+k;
                    }
                    out = SortSubString(out, ctr);
                    return out;
                }

            }
        }
        return "no answer";
    }

    public static String SortSubString(String a, int ctr){

        String sub1 = a.substring(ctr+1, a.length());
        String sub2 = a.substring(0,ctr+1);
        char[] sub1Arr = sub1.toCharArray();
        String out = "";
        Arrays.sort(sub1Arr);

        for (char k:sub1Arr){
            out = out+k;
        }
        out = sub2+out;

        return out;
    }

    static String[] missingWords(String s, String t) {
        String[] str1 = s.split(" ");
        String[] str2 = t.split(" ");
        ArrayList<String> answer = new ArrayList<>();
        int i, j;
        for(i =0, j=0; i<str1.length; i++){
            if(j == str2.length) break;
            if(str1[i].equals(str2[j])) {
                j++;
            } else {
                answer.add(str1[i]);
            }
        }
        while(i< str1.length) {
            answer.add(str1[i]);
            i++;
        }
        String[] ans = new String[answer.size()];
        for(int h = 0; h<ans.length; h++){
            ans[h] = answer.get(h);
        }
        return ans;
    }
    public String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        int sum = A + B + C + D;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(A);
        arrayList.add(B);
        arrayList.add(C);
        arrayList.add(D);
        StringBuffer ans = new StringBuffer();
        if(0 <= sum && sum<= 19){
            if(arrayList.contains(2)) {
                arrayList.remove(arrayList.indexOf(2));
                List<Integer> nosLessThanFour = arrayList.stream().filter(e -> e <= 3).collect(Collectors.toList());
                if (nosLessThanFour.size() > 0) {
                    ans.append(2);
                    OptionalInt h2 = nosLessThanFour.stream().mapToInt(Integer::intValue).max();
                    ans.append(h2);
                    arrayList.remove(arrayList.indexOf(h2));
                } else {
                    arrayList.add(2);
                }
            }

            if(arrayList.size() == 4) {
                if (arrayList.contains(1)) {
                    ans.append(1);
                    arrayList.remove(arrayList.indexOf(1));
                    OptionalInt h2 = arrayList.stream().mapToInt(Integer::intValue).max();
                    ans.append(h2);
                    arrayList.remove(arrayList.indexOf(h2));
                }
            }
            Integer m1 = arrayList.get(0);
            Integer m2 = arrayList.get(1);
            if(m1 <= 5 && m2 <= 5) {
                ans.append(Integer.max(m1,m2));
                ans.append(Integer.min(m1,m2));
                return ans.toString();
            } else if(m1 <= 5){
                ans.append(m1);
                ans.append(m2);
                return ans.toString();
            } else if(m2 <= 5) {
                ans.append(m2);
                ans.append(m1);
                return ans.toString();
            }
        }
        return "NOT POSSIBLE";
    }
    public int solution(int[] A){
        int[] B = A.clone();
        Arrays.sort(B);
        int count = 0;
        for(int i =0; i< B.length; i++){
            if( A[i] != B[i]){
                count++;
            }
        }
        return count / 2;
    }
    static int[] mystery(String[] letter) {
        int len = Integer.parseInt(letter[0]);
        int[] answer = new int[len];
        int index = 0;
        for(int i = 1; i <= len; i++){
            answer[index] = isPalindrome(letter[i]);
            index++;
        }
        return answer;
    }
    public static int isPalindrome(String s) {
        if(s.length() == 0){
            return 0;
        }
        StringBuffer str = new StringBuffer(s);
        int start = 0;
        int end = str.length() - 1;
        int count = 0;
        while (start < end){
            if(str.charAt(start) != str.charAt(end)){
                if(str.charAt(start) > str.charAt(end)){
                    if(str.charAt(start) != 'a'){
                        char a = str.charAt(start);
                        str.setCharAt(start,--a);
                        count++;
                    }
                }
                else{
                    if(str.charAt(end) != 'a'){
                        char a = str.charAt(end);
                        str.setCharAt(end,--a);
                        count++;
                    }
                }
            }
            else {
                start++;
                end--;
            }
        }
        return count;
    }
}
