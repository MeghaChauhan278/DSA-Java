/*2461. Maximum Sum of Distinct Subarrays With Length K
You are given an integer array nums and an integer k. Find the maximum subarray sum of
all the subarrays of nums that meet the following conditions:
The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no 
subarray meets the conditions, return 0.
Example 1: Input: nums = [1,5,4,2,9,9,9], k = 3 ,  Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Constraints: 1 <= k <= nums.length <= 105  ,   1 <= nums[i] <= 105 */
package Patterns.SlidingWindow;

import java.util.*;

public class P15_MaxSumOfDistinctSubarraysWithLengthK {
    public static long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int low = 0, high = k - 1;
        long sum = 0, res = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (map.size() == k) {
            res = sum;
        }
        while (high < nums.length - 1) {
            low++;
            sum -= nums[low - 1];
            int left = nums[low - 1];
            map.put(left, map.get(left) - 1);
            if (map.get(left) == 0) {
                map.remove(left);
            }
            high++;
            sum += nums[high];
            map.put(nums[high], map.getOrDefault(nums[high], 0) + 1);

            if (map.size() == k) {
                res = Math.max(sum, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;
        long ans = maximumSubarraySum(nums, k);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(k) HashMap can contain at most k distinct elements.