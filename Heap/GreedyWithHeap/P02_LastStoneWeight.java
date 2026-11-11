/*1046. Last Stone Weight
You are given an array of integers stones where stones[i] is the weight of the ith stone.
We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. 
Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.
Return the weight of the last remaining stone. If there are no stones left, return 0.
Example 1: Input: stones = [2,7,4,1,8,1]  ,  Output: 1
Example 2: Input: stones = [1]  ,  Output: 1
Constraints:
1 <= stones.length <= 30
1 <= stones[i] <= 1000 */
package Heap.GreedyWithHeap;
import java.util.*;
public class P02_LastStoneWeight {
    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();
            if(x!=y){
                pq.add(y-x);
            }
            if (pq.isEmpty()){
                return 0;
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        int ans=lastStoneWeight(stones);
        System.out.println(ans);
        int[] stones1={1};
        int ans1=lastStoneWeight(stones1);
        System.out.println(ans1);
    }
}
// Time Complexity: O(nlog n)
// Space Complexity: O(n)for the PriorityQueue.