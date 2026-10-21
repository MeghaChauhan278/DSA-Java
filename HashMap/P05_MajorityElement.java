/*169. Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element 
always exists in the array.
Example 1: Input: nums = [3,2,3]  ,  Output: 3
Example 2: Input: nums = [2,2,1,1,1,2,2]  ,  Output: 2
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.
Follow-up: Could you solve the problem in linear time and in O(1) space? */

import java.util.HashMap;

public class P05_MajorityElement {
    public static int majorityElement(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>n/2){
                return key;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums={3,2,3};
        int[] nums1={2,2,1,1,1,2,2};
        int ans=majorityElement(nums);
        int ans1=majorityElement(nums1);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
