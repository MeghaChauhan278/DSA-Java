/*347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the 
answer in any order.
Example 1: Input: nums = [1,1,1,2,2,3], k = 2  :  Output: [1,2]
Example 2: Input: nums = [1], k = 1  :  Output: [1]
Example 3: Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2  :  Output: [1,2]
Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size. */
package Heap.TopKelements;

import java.util.*;
public class P03_TopKFrequentElements {
    static class Pair{
        int first;
        int sec;
        Pair(int f,int s){
            first=f;
            sec=s;
        }
    }
    public static  int[] topKFrequent(int[] nums, int k){
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first){
                    return Integer.compare(a.first,b.first);
                }
                return Integer.compare(a.sec, b.sec);
            }
        );
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            int element=key;
            int freq=map.get(key);
            Pair curr=new Pair(freq,element);
            if(pq.size()<k){
                pq.add(curr);        
            }else if(freq>pq.peek().first){
                pq.poll();
                pq.add(curr);
            }
        }
        int[] ans=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i]=pq.poll().sec;
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1={1,1,1,2,2,3};
        int k1=2;
        int[] ans1=topKFrequent(nums1,k1);
        System.out.println(Arrays.toString(ans1));
        int[] nums2={1};
        int k2=1;
        int[] ans2=topKFrequent(nums2,k2);
        System.out.println(Arrays.toString(ans2));
        int[] nums3={1,2,1,2,1,2,3,1,3,2};
        int k3=2;
        int[] ans3=topKFrequent(nums3,k3);
        System.out.println(Arrays.toString(ans3));
    }
}
// TC:O(n+plog k)
// SC:O(p+k)