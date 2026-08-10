/*80. Remove Duplicates from Sorted Array II
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each
unique element appears at most twice. The relative order of the elements should be kept the same.
Since it is impossible to change the length of the array in some languages, you must instead have the 
result be placed in the first part of the array nums. More formally, if there are k elements after
removing the duplicates, then the first k elements of nums should hold the final result. It does not
matter what you leave beyond the first k elements.
Return k after placing the final result in the first k slots of nums.
Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
Example 1: Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 Constraints:1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order. */

package Patterns.TwoPointer;
import java.util.Arrays;
public class P03_RemoveDuplicatesII {
    public static int rmDup(int[] nums){
        int low=2,high=2;
        while(high<nums.length){

            if(nums[low-2]!=nums[high]){
                nums[low]=nums[high];
                low++;
            }
            
            high++;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,1,2,3,3};
        int ans=rmDup(nums);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }
}
//T.C=O(n)
//S.C=O(1)