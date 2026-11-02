/*215. Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?
Example 1: Input: nums = [3,2,1,5,6,4], k = 2  ,  Output: 5
Example 2: Input: nums = [3,2,3,1,2,4,5,5,6], k = 4  ,  Output: 4
Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104 */
package Heap.TopKelements;

import java.util.PriorityQueue;

public class P02_KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]<=pq.peek()){
                continue;
            }else{
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] arr={3,2,1,5,6,4};
        int k=2;
        int[] arr1={3,2,3,1,2,4,5,5,6};
        int k1=4;
        int ans=findKthLargest(arr,k);
        int ans1=findKthLargest(arr1,k1);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
// TC:O(n log k)
// SC:O(k)