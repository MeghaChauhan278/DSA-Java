/*152. Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
Example 1:
Input: nums = [2,3,-2,4]
Output: 6      Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0      Explanation: The result cannot be 2, because [-2,-1] is not a subarray. */
package Arrays.KadaneAlgorithm;

public class P03_MaxProductSubarray {
    public static void main(String[] args) {
        int[] nums={2,3,-2,4};
        int maxEnd=nums[0];
        int minEnd=Integer.MIN_VALUE;
        int ans=nums[0];

        for (int i=1; i<nums.length; i++) {
            int v1=nums[i];
            int v2=maxEnd * nums[i];
            int v3=minEnd * nums[i];

            maxEnd=Math.max(v1,Math.max(v2,v3));
            minEnd=Math.min(v1,Math.min(v2,v3));

            ans=Math.max(ans,Math.max(maxEnd,minEnd));
        }
        System.out.println(ans);
    }
}
