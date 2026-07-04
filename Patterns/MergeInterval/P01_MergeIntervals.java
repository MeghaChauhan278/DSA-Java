/*56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1: Input: intervals = [[2,6],[1,3],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
package Patterns.MergeInterval;
import java.util.*;
public class P01_MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals={{2,6},
                           {1,3},
                           {8,10},
                           {15,18}};
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> res=new ArrayList<>();
        
        int start1=intervals[0][0];
        int end1=intervals[0][1];

        for(int i=1;i<intervals.length;i++){

            int start2= intervals[i][0];
            int end2= intervals[i][1];

            if(end1>=start2){ //overlapping
                end1=Math.max(end1, end2); //extend
                continue;
            }else{//no overlapping
                res.add(new int[]{start1,end1});// add curr value in arrList
                start1=start2; //change interval
                end1=end2;
            }
        }
        res.add(new int[]{start1,end1});
        //return res.toArray(new int[res.size()][]);

        int[][] ans=res.toArray(new int[res.size()][]);
        System.out.println(Arrays.deepToString(ans));

    }
}
