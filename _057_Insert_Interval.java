/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        if(newInterval.start > intervals.get(intervals.size()-1).end){
            intervals.add(intervals.size(), newInterval);
            return intervals;
        }
        if(newInterval.end < intervals.get(0).start){
            intervals.add(0, newInterval);
            return intervals;
        }
        int startP = 0;
        while(startP < intervals.size() && intervals.get(startP).end < newInterval.start){
            startP ++;
        }
        int start = Math.min(intervals.get(startP).start, newInterval.start);
        int endP = startP;
        while(endP < intervals.size() &&  intervals.get(endP).start <= newInterval.end ){
            endP ++;
        }
        endP --;
        int end = Math.max(intervals.get(endP).end, newInterval.end);
        Interval merged = new Interval(start, end);
        while(endP >= startP){
            intervals.remove(startP);
            endP --;
        }
        intervals.add(startP, merged);
        return intervals;
    }
}
