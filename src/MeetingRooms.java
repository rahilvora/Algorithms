import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by rahilvora on 12/2/16.
 */
public class MeetingRooms {
    public static void main(String[] args){
        HashMap<Integer, Integer[]> m;
        Interval obj = new Interval();
        Interval obj1 = new Interval();
        Interval obj2 = new Interval();
        obj.start = 6;
        obj.end = 10;
        obj1.start = 13;
        obj1.end = 14;
        obj2.start = 12;
        obj2.end = 14;
        Interval[] arr = {obj2, obj1, obj};
        System.out.print(new MeetingRooms().minMeetingRooms(arr));
    }
    /*
    Total number of meeting rooms required
    [[0,30], [5,10], [15,20]]
    1. Arrange array based on start time i.e. [[6,10], [12,14], [13,14]]
    */
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.start-o2.start;
            }
        });
        PriorityQueue queue = new PriorityQueue();
        queue.offer(intervals[0].end);
        int count = 1;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < (int) queue.peek()){
                count++;
            }
            else{
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }
        return count;
    }

    /*
    Can a user attend all the meetings
    [[6,10], [13,14], [12,14]]
    1. Arrange array based on start time i.e. [[6,10], [12,14], [13,14]]
    */
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
}
