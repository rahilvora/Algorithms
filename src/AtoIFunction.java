/**
 * Created by rahilvora on 9/2/16.
 */
public class AtoIFunction {
    public static void main(String args[]){
        System.out.print(new AtoIFunction().myAtoI1("123"));
    }
    public static void a(){
        System.out.print("hello");
    }
    public int myAtoI1(String str){
        int result = 0;
        str = str.trim();
        int sign = 0;
        boolean isNegative = false;
        for(int i = 0; i < str.length() && sign < 2; i++){
            int value = (int) str.charAt(i) - 48;
            if(str.charAt(i) == '-' || str.charAt(i) == '+'){
                sign++;
                if(str.charAt(i) == '-'){
                    isNegative = true;
                }
                continue;
            }
            if(value > 9 || value < 0){
                break;
            }
            if(!isNegative && result > (Integer.MAX_VALUE - value)/10){
                return Integer.MAX_VALUE;
            }
            if(isNegative && result > (Integer.MAX_VALUE - value)/10){
                return Integer.MIN_VALUE;
            }
            result = result*10 + value;
        }
        if(isNegative){
            return result*-1;
        }
        return result;
    }
}
