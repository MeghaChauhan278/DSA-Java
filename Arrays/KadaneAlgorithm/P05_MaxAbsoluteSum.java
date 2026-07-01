/*1749. Maximum Absolute Sum of Any Subarray
You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr]
 is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
Return the maximum absolute sum of any (possibly empty) subarray of nums.
Note that abs(x) is defined as follows:
If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
Example 1: Input: nums = [2,-5,1,-4,3,-2] , Output: 8
Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8. */
package Arrays.KadaneAlgorithm;

public class P05_MaxAbsoluteSum {
    public static void main(String[] args) {
        int[] nums={2,-5,1,-4,3,-2};
        int maxend=nums[0],minend=nums[0],ans=Math.abs(nums[0]);

        for(int i=1;i<nums.length;i++){
            maxend=Math.max(nums[i], maxend+nums[i]);
            minend=Math.min(nums[i], minend+nums[i]);

            ans=Math.max(ans,Math.max(Math.abs(maxend),Math.abs(minend)));

        }
        System.out.println(ans);
    }
}
