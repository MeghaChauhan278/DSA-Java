/* GFG: Kth Smallest
Given an integer array arr[] and an integer k, find and return the kth smallest element in the given array.
Examples : Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4
Output: 5  ,  Explanation: 4th smallest element in the given array is 5.
Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3 , Output: 7
Explanation: 3rd smallest element in the given array is 7.
Constraints:
1 ≤ arr.size(), arr[i] ≤ 105
1 ≤ k ≤ arr.size() */
package Heap.TopKelements;
import java.util.Collections;
import java.util.PriorityQueue;
public class P01_KthSmallest {
    public static int kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]>=pq.peek()){
                continue;
            }else{
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] arr={10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k=4;
        int[] arr1={7, 10, 4, 3, 20, 15};
        int k1=3;
        int ans=kthSmallest(arr,k);
        int ans1=kthSmallest(arr1,k1);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
// TC:O(n log k)
// SC:O(k)