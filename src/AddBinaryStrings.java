/**
 * Created by rahilvora on 2/11/17.
 */
public class AddBinaryStrings {
    public static void main(String args[]){
        new AddBinaryStrings().addBinary("1","1");
    }
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder answer = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0){
            int value = 0;
            if (i >= 0 && j >= 0) {
                value = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j)) + carry;
            } else if (i >= 0) {
                value = Character.getNumericValue(a.charAt(i)) + carry;
            } else if (j >= 0) {
                value = Character.getNumericValue(b.charAt(j)) + carry;
            }
            else if(carry == 1){
                value = carry;
            }
            switch(value){
                case 0:{
                    answer.insert(0, '0');
                    break;
                }
                case 1:{
                    answer.insert(0,'1');
                    carry = 0;
                    break;
                }
                case 2:{
                    answer.insert(0,'0');
                    carry = 1;
                    break;
                }
                case 3:{
                    answer.insert(0,'1');
                    carry = 1;
                    break;
                }
            }
            i--;
            j--;
        }
        return answer.toString();
    }
}
