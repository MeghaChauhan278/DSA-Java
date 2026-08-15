/*523. Continuous Subarray Sum
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:
1-its length is at least two, and
2-the sum of the elements of the subarray is a multiple of k.
Note that:
A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
Example 1: Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2: Input: nums = [23,2,6,4,7], k = 13
Output: false
Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= sum(nums[i]) <= 231 - 1
1 <= k <= 231 - 1 */
package Patterns.PrefixSum;

import java.util.HashMap;

public class P09_ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=sum%k;
            if(map.containsKey(rem)){
                int length=i-map.get(rem);
                if(length>=2){
                    return true;
                }
            }else{
                map.put(rem,i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7}; int k = 6;
        boolean ans= checkSubarraySum(nums,k);
        System.out.println(ans);
    }
}
// T.C=O(n)
// S.C=O(n)
