/*1004. Max Consecutive Ones III
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the 
array if you can flip at most k 0's.
Example 1: Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6  Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Example 2: Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10 Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length*/
package Patterns.SlidingWindow;

public class P07_MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k){
        int low=0,high=0,res=0,zerocount=0;
        while(high<nums.length){
            if(nums[high]==0){
                zerocount++;
                while(zerocount>k){
                    if(nums[low]==0){
                        zerocount--;
                    }
                    low++;
                }
            }
            res=Math.max(res, high-low+1);
            high++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        int[] nums1={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k1=3;
        int ans=longestOnes(nums,k);
        int ans1=longestOnes(nums1,k1);
        System.out.println(ans);
        System.out.println(ans1);
        
    }
}
//T.C=O(n)
//S.C=O(1)
