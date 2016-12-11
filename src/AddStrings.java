/**
 * Created by rahilvora on 11/25/16.
 */
public class AddStrings {
    public static void main(String args[]){
        new AddStrings().addStrings("1","9");
    }
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int val = val1 + val2 + carry;
            str.insert(0, val % 10);
            //str.append(val % 10);
            carry = val / 10;
        }
        return str.toString();
    }
}
