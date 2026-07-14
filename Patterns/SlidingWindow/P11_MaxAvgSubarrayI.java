/*643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value
 and return this value. Any answer with a calculation error less than 10-5 will be accepted.
Example 1: Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Constraints:
n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104 */
package Patterns.SlidingWindow;
public class P11_MaxAvgSubarrayI {
    public static void main(String[] args) {
        int[] nums={1,12,-5,-6,50,3};
        int k=4;
        int low=0,high=k-1,sum=0;

        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double res=(double) sum/k;
        while(high<nums.length-1){
            low++;
            sum-=nums[low-1];
            high++;
            sum+=nums[high];
            double avg=(double) sum/k;
            res=Math.max(res,avg);
        }
        System.out.println(res);
    }
}
