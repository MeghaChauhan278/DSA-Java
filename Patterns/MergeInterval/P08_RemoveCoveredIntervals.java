/*1288. Remove Covered Intervals
Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri),
remove all intervals that are covered by another interval in the list.
The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
Return the number of remaining intervals.
Example 1: Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2      Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2: Input: intervals = [[1,4],[2,3]]
Output: 1
Constraints: 1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= li < ri <= 105
All the given intervals are unique. */
package Patterns.MergeInterval;
import java.util.*;
public class P08_RemoveCoveredIntervals {
    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
/*If two intervals have the same start, we sort the one with the larger end first.
For example:[1,4][1,8]
becomes:[1,8][1,4]
Why? Because [1,4] is covered by [1,8].*/
        int st1=intervals[0][0];
        int end1=intervals[0][1];
        int count=intervals.length;

        for(int i=1;i<intervals.length;i++){
            int st2=intervals[i][0];
            int end2=intervals[i][1];

            if(st1 <= st2 && end2 <= end1){
                count--;
            }else{
                st1=st2;
                end1=end2;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{3,6},{2,8}};
        int ans=removeCoveredIntervals(intervals);
        System.out.println(ans);
    }
}
// TC: O(n log n)
// SC: O(log n) 
