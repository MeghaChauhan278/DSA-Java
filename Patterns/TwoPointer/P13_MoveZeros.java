/*283. Move Zeroes
Given an integer array nums, move all 0's to the end of it while maintaining the relative
order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
Example 1: Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1 */
package Patterns.TwoPointer;

import java.util.Arrays;

public class P13_MoveZeros {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        int low=0,high=0;
        while(high<nums.length){
            if(nums[high]!=0){
                int temp=nums[low];
                nums[low]=nums[high];
                nums[high]=temp;
                low++;
            }
            high++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
/*
Time Complexity = O(n)
Space Complexity = O(1)
*/
