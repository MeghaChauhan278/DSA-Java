/*974. Subarray Sums Divisible by K
Given an integer array nums and an integer k, return the number of non-empty subarrays
 that have a sum divisible by k.
Example 1:Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
package Patterns.PrefixSum;
import java.util.*;
public class P03_SubarraySumDivisibleByK {
    public static void main(String[] args) {
        int[] nums={4,5,0,-2,-3,1};
        int k=5;

        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0, 1);
        int sum=0,res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            int rem=sum%k;
            if(rem<0){
                rem+=k;
            }
            int freq=map.getOrDefault(rem, 0);
            res+=freq;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        System.out.println(res);
    }
}
