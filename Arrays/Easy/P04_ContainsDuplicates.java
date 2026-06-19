/*217. Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array,
 and return false if every element is distinct.
Example 1: Input: nums = [1,2,3,1]  ,Output: true
Explanation: The element 1 occurs at the indices 0 and 3.

Example 2:Input: nums = [1,2,3,4]  ,Output: false*/

import java.util.*;
public class P04_ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        HashSet<Integer> set=new HashSet<>();
        boolean found=false;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                found=true;
                break;
                }
                set.add(nums[i]);
            }
        System.out.println(found);
    }
}
