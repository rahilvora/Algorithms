/**
 * Created by rahilvora on 10/1/16.
 */
public class RollingString {
    public static void main(String args[]){
        String[] operations = {"0 0 L","2 2 L","0 2 R"};
        String s = "abc";
        System.out.print(rollingString(s,operations));

    }
    public static String rollingString(String s, String[] operations) {
        StringBuilder str = new StringBuilder(s);
        for(int i = 0; i < operations.length; i++){
            String[] strArr = operations[i].split(" ");
            int start = Integer.parseInt(strArr[0]);
            int end = Integer.parseInt(strArr[1]);
            char opr = operations[i].charAt(operations[i].length()-1);
            if(start <= end){
                for(int j = start; j <= end; j++){
                    if(opr == 'L'){
                        if(str.charAt(j) == 97){
                            str.setCharAt(j,'z');
                        }
                        else{
                            str.setCharAt(j,(char) (str.charAt(j) - 1));
                        }
                    }
                    if(opr == 'R'){
                        if(str.charAt(j) == 122){
                            str.setCharAt(j,'a');
                        }
                        else{
                            str.setCharAt(j,(char) (str.charAt(j) + 1));
                        }
                    }
                }
            }
            else{
                return null;
            }

        }
        return str.toString();
    }
}
