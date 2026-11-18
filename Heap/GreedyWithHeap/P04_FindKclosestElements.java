/*658. Find K Closest Elements
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result 
should also be sorted in ascending order.
An integer a is closer to x than an integer b if:
|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
Example 1: Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2: Input: arr = [1,1,2,3,4,5], k = 4, x = -1
Output: [1,1,2,3]
Constraints:
1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104 */
package Heap.GreedyWithHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
class Pair{
    int first;
    int sec;
    Pair(int f,int s){
        first=f;
        sec=s;
    }
}
public class P04_FindKclosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x){
        List<Integer> ans= new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first)
                    return Integer.compare(b.first,a.first);
                return Integer.compare(b.sec,a.sec);
            }
        );
        int n = arr.length;
        // Pair[] p = new Pair[n];
        // for(int i=0;i<n;i++){
        //     p[i]=new Pair(Math.abs(arr[i]-x),arr[i]);
        // }
        for (int i = 0; i < n; i++) {

            pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll().sec);
        }
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int k=4,x=3;
        int[] arr1={1,1,2,3,4,5};
        int k1=4,x1=-1;
        List<Integer>ans=findClosestElements(arr,k,x);
        List<Integer> ans1=findClosestElements(arr1,k1,x1);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
// TC: O(n log k)
// SC: O(k)