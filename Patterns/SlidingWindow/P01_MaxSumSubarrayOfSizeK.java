/*Max Sum Subarray of size K
Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
Examples: Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ k ≤ arr.size()*/
package Patterns.SlidingWindow;
public class P01_MaxSumSubarrayOfSizeK {
    public static int maxSubarraySum(int[] arr, int k){
        int high=k-1,low=0,res=0,sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        res=sum;
        while(high<arr.length-1){
            low++;
            sum-=arr[low-1];
            high++;
            sum+=arr[high];
            res=Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1={100, 200, 300, 400};
        int k1=2;
        int[] arr2 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k2=4;
        int ans1=maxSubarraySum(arr1,k1);
        System.out.println(ans1);
        int ans2=maxSubarraySum(arr2,k2);
        System.out.println(ans2);
    }
}
//T.C=O(n)
//S.C=O(1)
