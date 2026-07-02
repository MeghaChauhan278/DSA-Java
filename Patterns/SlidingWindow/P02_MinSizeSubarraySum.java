/*Question : Given an array of positive integers nums and a positive integer target,
return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.*/
package Patterns.SlidingWindow;
public class P02_MinSizeSubarraySum {
    public static void main(String[] args) {
        int[] a={2,3,1,2,4,3};
        int target=7;
        int low=0,high=0;
        int res=Integer.MAX_VALUE;
        int sum=0;
        while(high<a.length){
            sum+=a[high];
            while(sum>=target){
                res=Math.min(res, high-low+1);
                sum-=a[low];
                low++;
            }
            high++;
        }
        System.out.println(res==Integer.MAX_VALUE? 0:res);
    }
}
