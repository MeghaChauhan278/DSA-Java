/*57. Insert Interval
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
represent the start and the end of the ith interval and intervals is sorted in ascending order by start i.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.
Example 1: Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. */
package Patterns.MergeInterval;
import java.util.*;
public class P02_InsertIntervals{
    public static void main(String[] args) {
        int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval={4,8};

        List<int[]> res=new ArrayList<>();
        int i=0;
        // Add intervals before newInterval
        while(i<intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        // Merge overlapping intervals
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){//Has the current interval started before the merged interval ends?

            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add merged interval
        res.add(newInterval);
        
        // Add remaining intervals
        while (i<intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        int[][] ans = res.toArray(new int[res.size()][]);
        System.out.println(Arrays.deepToString(ans));
    }
}