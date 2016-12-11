/**
 * Created by rahilvora on 8/16/16.
 */
public class RansonNote {

    public static void main(String args[]){

        System.out.print(new RansonNote().canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));

    }
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            a1[ransomNote.charAt(i) - 'a']++;
        }
        for(int j = 0; j < magazine.length(); j++){
            a2[magazine.charAt(j) - 'a']++;
        }
        for(int z = 0; z < ransomNote.length(); z++){
            if( a1[ransomNote.charAt(z) - 'a'] > a2[ransomNote.charAt(z) - 'a']){
                return false;
            }
        }
        return true;
    }
}
