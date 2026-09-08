/*704. Binary Search
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
Example 1: Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Example 2: Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1  ,  Explanation: 2 does not exist in nums so return -1
Constraints:
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order. */
package Patterns.BinarySearch;
public class P01_BinarySearch {
    public static  int search(int[] nums, int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int ans=search(nums,target);
        System.out.println(ans);
        int[] nums2 = {-1,0,3,5,9,12};
        int target2 = 2;
        int ans1=search(nums2,target2);
        System.out.println(ans1);
    }
}
// TC:O(logn)
// SC:O(1);