/*209. Minimum Size Subarray Sum
Given an array of positive integers nums and a positive integer target, return the minimal length 
of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1:
Input: target = 7, arr = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.*/
package Arrays.SlidingWindow;
import java.util.*;
public class P08_MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr={2, 3, 1, 2, 4, 3};
        int target=7;
        int high=0,low=0,sum=0,minLen=Integer.MAX_VALUE;

        while (high<arr.length) {
            sum+=arr[high];

            while (sum>=target) {
                minLen=Math.min(minLen, high-low+1);
                sum-=arr[low];
                low++;
            }
            high++;
        }
        System.out.println(minLen==Integer.MAX_VALUE ? 0 : minLen);
    }
}
