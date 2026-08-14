/*435. Non-overlapping Intervals
Example 1: Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2: Input: intervals = [[1,2],[2,3]]  ,  Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
Constraints:
1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104 */
package Patterns.MergeInterval;

import java.util.Arrays;

public class P06_NonOverlappngInterval {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int end1=intervals[0][1];
        int count=0;

        for(int i=1;i<intervals.length;i++){
            int st2=intervals[i][0];
            int end2=intervals[i][1];

            if(end1>st2){
                count++;
                end1=Math.min(end1,end2);
            }else{
                // st1=st2;
                end1=end2;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int ans=eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }
}
// TC: O(n log n)
// SC: O(log n)  -> Java's sorting requires stack space