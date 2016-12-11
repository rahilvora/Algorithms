
/**
 * Created by rahilvora on 7/21/16.
 */
public class RotateImageBy90 {
    public static void main(String args[]){
        int[][] image = {{1,2,3},{4,5,6},{7,8,9}};
        new RotateImageBy90().rotateRight(image);
    }
    public void rotateRight(int[][] image){

        int n = image.length;
        int f = (int) Math.floor(n/2);
        int c = (int) Math.ceil(n/2);

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = image[i][j];
                image[i][j] = image[n-1-j][i];
                image[n-1-j][i] = image[n-1-i][n-1-j];
                image[n-1-i][n-1-j] = image[j][n-1-i];
                image[j][n-1-i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
