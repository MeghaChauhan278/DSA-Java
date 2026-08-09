/*42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.
Example 1: Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6 Explanation: The above elevation map (black section) is represented by array 
[0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Constraints: n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105 */
package Patterns.TwoPointer;
import java.util.*;
public class P16_TrappingRainWater {
     public static int trap(int[] height){
        int n=height.length , res=0;
        int left=0 , lmax=0;
        int right=n-1 , rmax=0;
        while(left<right){
            lmax=Math.max(lmax,height[left]);
            rmax=Math.max(rmax,height[right]);

            if(lmax<rmax){
                res+=lmax-height[left];
                left++;
            }else{
                res+=rmax-height[right];
                right--;
            }
        }
        return res;
     } 
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans=trap(height);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)