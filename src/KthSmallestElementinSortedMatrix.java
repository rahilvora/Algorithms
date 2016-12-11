import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rahilvora on 9/22/16.
 */
public class KthSmallestElementinSortedMatrix {
    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(new KthSmallestElementinSortedMatrix().kthSmallest1(matrix, 8));
    }
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int[] arr = new int[len*len];
        int c = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                arr[c] = matrix[i][j];
                c++;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getLessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    private int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) i--;
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}
