/*986. Interval List Intersections
You are given two lists of closed intervals, firstList and secondList, 
where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list
 of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that are either empty or
 represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]] */
package Patterns.MergeInterval;
import java.util.*;
public class P03_IntervalListIntersection {
    public static void main(String[] args) {
        int[][] firstList={{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList={{1,5},{8,12},{15,24},{25,26}};

        List<int[]> res=new ArrayList<>();
        int i=0,j=0;
        while(i<firstList.length && j<secondList.length){
            int start=Math.max(firstList[i][0], secondList[j][0]);
            int end=Math.min(firstList[i][1], secondList[j][1]);

            if(start<=end){
                res.add(new int[]{start,end});
            }
            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        int[][] ans=res.toArray(new int[res.size()][]);
        System.out.println(Arrays.deepToString(ans));
    }
}
