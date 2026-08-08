/*560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number
of subarrays whose sum equals to k.
Example 1: Input: nums = [1,2,3], k = 3 : O/P=2
Constraints: 1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107 */
package Patterns.PrefixSum;
import java.util.*;
public class P02_SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        int sum=0,res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int need=sum-k;
            int freq=map.getOrDefault(need, 0);
            res+=freq;
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        int ans=subarraySum(nums,k);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(n)
