/*53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6      Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:
Input: nums = [1]
Output: 1      Explanation: The subarray [1] has the largest sum 1.
Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23     Explanation: The subarray [5,4,-1,7,8] has the largest sum 23. */
package Arrays.KadaneAlgorithm;

public class P01_MaxSubarray {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};

        int bestending=arr[0];
        int ans=arr[0];
        
        for(int i=1;i<arr.length;i++){

            bestending=Math.max(arr[i],arr[i]+ bestending);
            ans=Math.max(ans, bestending);
        }
        System.out.println(ans);
    }
}
