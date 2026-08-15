/*1248. Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A continuous subarray is called nice if there 
are k odd numbers on it.
Return the number of nice sub-arrays.
Example 1: Input: nums = [1,1,2,1,1], k = 3
Output: 2       Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Constraints:
1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length */
package Patterns.PrefixSum;
import java.util.HashMap;

public class P07_CountNoOfNiceSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] % 2;
            int need = sum - k;
            int freq = map.getOrDefault(need, 0);
            count += freq;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;
        int ans = numberOfSubarrays(nums, k);
        System.out.println(ans);
    }
}
// T.C=O(n)
// S.C=O(n)