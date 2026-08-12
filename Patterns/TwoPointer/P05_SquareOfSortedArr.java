/*977. Squares of a Sorted Array
Given an integer array nums sorted in non-decreasing order, return an array of the squares of
each number sorted in non-decreasing order.
Example 1: Input: nums = [-4,-1,0,3,10]  ,  Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
*/
package Patterns.TwoPointer;
import java.util.Arrays;
public class P05_SquareOfSortedArr {
    public static int[] sortedSquares(int[] nums){
        int n= nums.length;
        int[] square=new int[n];
        int j=0;
        while(j<nums.length && nums[j]<0){
            j++;
        }
        int i=j-1;
        int k=0;
        while(i>=0 && j<nums.length){
            int leftsq=nums[i]*nums[i];
            int rightsq=nums[j]*nums[j];
            if(leftsq<rightsq){
                square[k]=leftsq;
                k++;
                i--;
            }else{
                square[k]=rightsq;
                k++;
                j++;
            }
        }
        while(i>=0){
            square[k]=nums[i]*nums[i];
            i--;
            k++;
        }
        while(j<nums.length){
            square[k]=nums[j]*nums[j];
            j++;
            k++;
        }
        return square;
    }
    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] ans=sortedSquares(nums);
        System.out.println(Arrays.toString(ans));
    }
}
//T.C=O(n);
//S.C=O(n);

