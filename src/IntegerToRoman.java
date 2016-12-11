import java.util.HashMap;

/**
 * Created by rahilvora on 9/16/16.
 */
public class IntegerToRoman {

    public static void main(String args[]){
        System.out.print(new IntegerToRoman().intToRoman(100));
    }
    public String intToRoman(int num) {
        StringBuffer str  = new StringBuffer();

        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(100,'M');


        return str.toString();
    }
}
