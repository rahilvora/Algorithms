import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by rahilvora on 7/13/16.
 * Consider the following 6 activities.
 * start[]  =  {1, 3, 0, 5, 8, 5};
 * finish[] =  {2, 4, 6, 7, 9, 9};
 * The maximum set of activities that can be executed
 * by a single person is {0, 1, 3, 4}
 */
public class ActivitySelectionProblem {
    public static void main(String  args[]){
        int[] start = {6, 0, 4, 3, 5, 8};
        int[] finish = {7,2, 6, 4, 8, 9};
        int[] s1 = {1, 3, 0, 5, 8, 5};
        int[] f2 = {2, 4, 6, 7, 9, 9};
        sortArray(s1, f2);
        //selectionAlgo(s1,f2);

    }
    public static void sortArray(int[] start, int[] finish){
        Arrays.sort(finish, 0 , finish.length);
        int[] tempstart = new int[start.length];
        int[] tempfinish = new int[start.length];
        tempfinish = finish.clone();
        Arrays.sort(tempfinish, 0, finish.length);
        for(int i = 0; i < start.length; i++){
            int index = findIndex(finish, tempfinish[i]);
            tempstart[i] = start[index];

        }
        maxActivities(tempstart, tempfinish, tempfinish.length);
    }
    //actual implementation
    public static void maxActivities(int[] start, int[] finish, int n){

        int i = 0;
        System.out.print(i + " " );
        for(int j = 1; j < n ; j++){
            if(start[j] >= finish[i]){
                i = j;
                System.out.print(j + " ");
            }
        }
    }
    //My implementation
    public static void selectionAlgo(int[] start, int[] finish){
        if(start.length == finish.length){
            int[] tempstart = new int[start.length];
            int[] tempfinish = new int[start.length];

            tempfinish = finish.clone();
            Arrays.sort(tempfinish, 0, finish.length);

            for(int i = 0; i < start.length; i++){
                int index = findIndex(finish, tempfinish[i]);//Arrays.asList(finish).indexOf(tempfinish[i]);
                if(i == 0){
                    tempstart[i] = start[index];
                }
                else{
                    int temp  = start[index];
                    if(tempstart[i -1] != -1 && temp > tempfinish[ i -1] && temp < tempfinish[i]){
                        tempstart[i] = start[index];
                    }
                    else if (tempstart[i -1] == -1 && temp >= tempfinish[ i -1] && temp < tempfinish[i]){
                        tempstart[i] = start[index];
                    }
                    else{
                        tempstart[i] = -1;
                    }
                }
            }
            for(int x = 0; x < start.length; x++){
                if(tempstart[x] != -1 ){
                    System.out.print(findIndex(start,tempstart[x]) +" ");
                }
            }
        }

    }
    public static int findIndex(int[] finish, int value){
        for(int i = 0; i < finish.length; i++){
            if(finish[i] == value){
                return i;
            }
        }
        return -1;
    }
}
