/*Smallest sum contiguous subarray(gfg)
Given an array arr[] of N integers. Find the contiguous sub-array(containing at least one number)
 which has the minimum sum and return its sum.
Example 1:
arr[] = {3,-4, 2,-3,-1, 7,-5}
Output: -6
Explanation: sub-array which has smallest 
sum among all the sub-array is {-4,2,-3,-1} = -6
 */
package Arrays.KadaneAlgorithm;

public class P02_MinSubarraySum {
    public static void main(String[] args) {
        int[] arr={3,-4, 2,-3,-1, 7,-5};
        int bestending=arr[0];
        int ans=arr[0];
        for (int index = 0; index < arr.length; index++) {
            bestending=Math.min(arr[index],arr[index]+bestending);
            ans=Math.min(ans, bestending);
        }
        System.out.println(ans);
    }
}
