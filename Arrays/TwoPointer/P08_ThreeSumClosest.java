/*Given an integer array nums of length n and an integer target, find three integers at 
distinct indices in nums such that the sum is closest to target.
Return the sum of the three integers.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). */
package Arrays.TwoPointer;

import java.util.*;

public class P08_ThreeSumClosest {
    public static void main(String[] args) {

        int[] nums = { -1, 2, 1, -4 };
        int target = 1;

        int maxdiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int result = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);

                if (diff < maxdiff) {
                    maxdiff = diff;
                    result = sum;
                }

                if (target == sum) {
                    System.out.println(sum);
                    return;
                } 
                
                else if (sum < target) {
                    start++;
                } 
                
                else {
                    end--;
                }
            }
        }
        System.out.println(result);
    }
}
