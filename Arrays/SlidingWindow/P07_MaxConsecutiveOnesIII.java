/*1004. Max Consecutive Ones III
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array 
if you can flip at most k 0's.
Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1] */
package Arrays.SlidingWindow;

public class P07_MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        int low=0,high=0,res=0,zerocount=0;

        while(high<nums.length){
            if(nums[high]==0){
                zerocount++;

                while (zerocount>k) {
                    if (nums[low]==0) {
                        zerocount--;
                    }
                    low++;
                }
            }
            res=Math.max(res, high-low+1);
            high++;
        }
        System.out.println(res);
    }
}

