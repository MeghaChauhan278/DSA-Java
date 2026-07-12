/*Meeting Rooms II
Given two arrays start[] and end[] such that start[i] is the starting time of ith meeting and end[i]
 is the ending time of ith meeting. Return the minimum number of rooms required to attend all meetings.
Note: A person can also attend a meeting if it's starting time is same as the previous meeting's ending time.
Examples: Input: start[] = [2, 9, 6], end[] = [4, 12, 10]
Output: 2,Explanation: 1st and 2nd meetings at one room but for 3rd meeting one another room required.
Constraints:
1 ≤ start.size() = end.size() ≤ 105
0 ≤ start[i] < end[i] ≤ 106 */
package Patterns.MergeInterval;
import java.util.*;
public class P05_MeetingRoomII {
    public static void main(String[] args) {
        int start[] ={2, 9, 6};
        int end[] ={4, 12, 10};
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0,j=0;
        int room=0,maxroom=0;

        while(i<start.length){
            if(start[i]<end[j]){//overlap
                room++;//need a room
                maxroom=Math.max(maxroom, room);
                i++;//next meeting
            }else{//no overlap
                room--;//1 meeting finished room released
                j++;//next ending
            }
        }
        System.out.println(maxroom);
    }
}
/* 2Pointer + Sorting 
T.C=O(n logn)
S.C=algo space->O(1)*/