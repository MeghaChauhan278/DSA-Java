/*209. Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal 
length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1: Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).*/
package Patterns.SlidingWindow;
public class P02_MinSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums){
        int low=0,high=0,res=Integer.MAX_VALUE,sum=0;
        while(high<nums.length){
            sum+=nums[high];
            while(sum>=target){
                res=Math.min(res, high-low+1);
                sum-=nums[low];
                low++;
            }
            high++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        int ans=minSubArrayLen(target,nums);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)
