import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahilvora on 10/20/16.
 */
public class InsertIntervalDP {
    public static void main(String args[]){
        Interval one = new Interval(1,5);
        Interval three = new Interval(0,3);

        List<Interval> list = new ArrayList<>();
        list.add(one);
        //list.add(two);

        new InsertIntervalDP().insert(list, three);
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        boolean flag = false;
        if(intervals.size() == 0) {
            ans.add(newInterval);
            return ans;
        }
        for (Interval obj:
             intervals) {
            if(newInterval.start >= obj.start && newInterval.end <= obj.end){
                
            }
//            if(obj.end >= newInterval.start){
//                if(obj.end > newInterval.end) {
//                    if(obj.end < newInterval.end)
//                        obj.end = newInterval.end;
//                    ans.add(obj);
//                    flag = true;
//                    break;
//                }
//
//            }
            ans.add(obj);
        }
        if(!flag) ans.add(newInterval);
        return ans;
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }