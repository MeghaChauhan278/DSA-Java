/*713. Subarray Product Less Than K
Given an array of integers nums and an integer k, return the number of contiguous subarrays 
where the product of all the elements in the subarray is strictly less than k.
Example 1: Input: nums = [10,5,2,6], k = 100
Output: 8  Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Constraints:
1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106 */
package Patterns.SlidingWindow;

public class P16_SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) {
            return 0;
        }
        int low = 0, high = 0, product = 1, count = 0;
        while (high < nums.length) {
            product *= nums[high];
            while (product >= k) {
                product /= nums[low];
                low++;
            }
            count += high - low + 1;
            high++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        int ans = numSubarrayProductLessThanK(nums, k);
        System.out.println(ans);
    }
}
// T.C=O(n)
// S.C=O(1)
