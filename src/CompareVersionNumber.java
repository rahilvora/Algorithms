import sun.security.pkcs11.Secmod;

import java.io.IOException;

/**
 * Created by rahilvora on 7/27/16.
 */
public class CompareVersionNumber {
    public static void main(String args[]) throws IOException{
        System.out.print(new CompareVersionNumber().compareVersion("0.1","0.0.1"));
    }
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
