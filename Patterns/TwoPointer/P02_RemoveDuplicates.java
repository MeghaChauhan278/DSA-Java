/*26. Remove Duplicates from Sorted Array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
such that each unique element appears only once. The relative order of the elements should be kept the same.
Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the
number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining
elements beyond index k - 1 can be ignored.
Example 1: Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 Constraints: 1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order. */

package Patterns.TwoPointer;
import java.util.Arrays;

public class P02_RemoveDuplicates {
    public static int RemoveDuplicate(int[] nums){
        int low=0,high=low+1;
        while(high<nums.length){
            if(nums[low]!=nums[high]){
                low++;
                nums[low] = nums[high];
            }
            high++;  
        }
        return low+1;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int ans=RemoveDuplicate(nums);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }
}
//T.C=O(n)
//S.C=O(1)