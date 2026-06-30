/*560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number
 of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
Example 1: Input: nums = [1,2,3], k = 3
Output: 2 */
package Arrays.PrefixSum;

import java.util.HashMap;

public class P02_SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        map.put(0,1);

        int sum=0,res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            int need=sum-k;
            int freq=map.getOrDefault(need, 0);
            res+=freq;
            map.put(sum,map.getOrDefault(sum, 0) +1);

        }
        System.out.println(res);
    }
}
