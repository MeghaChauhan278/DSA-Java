/*502. IPO
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, 
LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited 
resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way 
to maximize its total capital after finishing at most k distinct projects.
You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of 
capital[i] is needed to start it.Initially, you have w capital. When you finish a project, you will obtain 
its pure profit and the profit will be added to your total capital.
Pick a list of at most k distinct projects from given projects to maximize your final capital, and return 
the final maximized capital.
The answer is guaranteed to fit in a 32-bit signed integer.
Example 1: Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]  ,  Output: 4 
Example 2: Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]  ,  Output: 6
Constraints:
1 <= k <= 105
0 <= w <= 109
n == profits.length
n == capital.length
1 <= n <= 105
0 <= profits[i] <= 104
0 <= capital[i] <= 109 */
package Heap.GreedyWithHeap;

import java.util.*;
public class P03_IPO {
    static class Pair{
        int first;
        int sec;
        Pair(int f,int s){
            first=f;
            sec=s;
        }
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
        int n=profits.length;
        Pair[] proj=new Pair[n];
        for(int i=0;i<n;i++){
            proj[i]=new Pair(capital[i], profits[i]);
        }
        Arrays.sort(proj,(a, b) -> Integer.compare(a.first, b.first));
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int index=0;
        while(k-->0){
            while(index<n){
                if(proj[index].first>w){
                    break;
                }
                pq.add(proj[index].sec);
                index++;
            }
            if(pq.isEmpty()){
                break;
            }
            w=w+pq.poll();
        }
        return w;
    }
    public static void main(String[] args) {
        int  k = 2, w = 0;
        int[] profits = {1,2,3}; 
        int[] capital = {0,1,1};
        int ans=findMaximizedCapital(k,w,profits,capital);
        System.out.println(ans);
    }
}
// TC:O(nlog n)
// SC:O(n)