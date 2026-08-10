/*Question: Given an array of integers nums and an integer target, return indices of the two numbers such 
that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example 1:
Input: nums = [2,7,11,15], target = 9        Input: nums = [3,2,4], target = 6
Output: [0,1]                                       Output: [1,2]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. */
package Patterns.TwoPointer;

import java.util.*;

public class P00_TwoSum {
    public static int[] a(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[] { map.get(need), i };
            }

            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] ans = a(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
//T.C=O(n)
//S.C=O(n)