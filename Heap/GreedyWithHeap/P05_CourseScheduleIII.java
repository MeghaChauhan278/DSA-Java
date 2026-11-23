/*630. Course Schedule III
There are n different online courses numbered from 1 to n. You are given an array courses where 
courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days 
and must be finished before or on lastDayi.
You will start on the 1st day and you cannot take two or more courses simultaneously.
Return the maximum number of courses that you can take.
Example 1: Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]  :  Output: 3
Example 2: Input: courses = [[1,2]]  :  Output: 1
Example 3: Input: courses = [[3,2],[4,3]]  :  Output: 0
Constraints:
1 <= courses.length <= 104
1 <= durationi, lastDayi <= 104 */
package Heap.GreedyWithHeap;
import java.util.*;
public class P05_CourseScheduleIII {
    public static int scheduleCourse(int[][] courses){
        Arrays.sort(courses,(a,b)-> Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int totalDays=0;
        for(int[] course:courses){
            int duration=course[0];
            int lastday=course[1];

            totalDays+=duration;
            pq.add(duration);
            if(totalDays>lastday)
                totalDays-=pq.poll();
            
        }
        return pq.size();
    }
    public static void main(String[] args) {
        int[][] courses={{100,200},{200,1300},{1000,1250},{2000,3200}};
        int ans=scheduleCourse(courses);
        System.out.println(ans);
    }
}
// Time: O(n log n)
// Space: O(n)