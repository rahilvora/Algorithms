import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rahilvora on 1/18/17.
 */
public class CourseSchedule {

    public int[] canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] pCounter = new int[numCourses];
        int[] answer = new int[numCourses];
        for(int i = 0; i < len; i++){
            pCounter[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(pCounter[i] == 0){
                queue.offer(i);
            }
        }
        int numOfPre = queue.size();

        while(!queue.isEmpty()){
            int top = queue.poll();
            answer[count] = top;
            count++;
            for(int i = 0; i < len; i++){
                if(prerequisites[i][1] == top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]] == 0){
                        numOfPre++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        if(numCourses == numOfPre){
            return answer;
        }
        else{
            return new int[0];
        }
    }
    public static void  main(String args[]){
        int[][] arr = {{0,1}};
        new CourseSchedule().canFinish(2, arr);
    }
}
