/**
 * Created by rahilvora on 7/25/16.
 */
public class ExcelSheetColumnNumber {
    public static void main(String args[]){
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("BA"));
        System.out.println(new ExcelSheetColumnNumber().convertToTitle(62));

    }

    //String to column number
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

    //Number to column Name
    public String convertToTitle(int n) {
        String ret = "";
        while (n != 0) {
            ret = (char)('A'+(--n)%26) + ret;
            n /= 26;
        }
        return ret;
    }
}
