/*34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position 
of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.
Example 1: Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2: Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3: Input: nums = [], target = 0
Output: [-1,-1]
Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 */
package Patterns.BinarySearch;
import java.util.Arrays;

public class P03_FirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target){
        int low=0,high=nums.length-1;
        int[] res={-1,-1};
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                res[0]=mid;
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        //last occurence
        low=0;
        high=nums.length-1;//reset
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                res[1]=mid;
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;    
    }
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ans=searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        int[] ans1=searchRange(nums2,target2);
        System.out.println(Arrays.toString(ans1));
        int[] nums3 = {};
        int target3 = 0;
        int[] ans3=searchRange(nums3,target3);
        System.out.println(Arrays.toString(ans3));
    }
}
// TC:O(logn)
// SC:O(1)