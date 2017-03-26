import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rahilvora on 2/9/17.
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
        public List<Interval> merge(List<Interval> intervals) {
            List<Interval> answer = new ArrayList<>();
            if(intervals.size() <= 1) return intervals;
            Collections.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval v1, Interval v2){
                    return Integer.compare(v1.start, v2.start);
                }
            });
            int start = intervals.get(0).start;
            int end = intervals.get(0).end;
            for(Interval interval: intervals){
                if(interval.start <= end){
                    end  = Math.max(interval.end, end);
                }
                else{
                    answer.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }
            answer.add(new Interval(start,end));
            return answer;
        }

}
