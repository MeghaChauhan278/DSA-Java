/*167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, 
find two numbers such that they add up to a specific target number. Let these two numbers be
numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers index1 and index2, each incremented by one, as an integer
array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.
Example 1: Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Constraints:2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution. */

package Patterns.TwoPointer;
import java.util.Arrays;
public class P01_TwoSumII {
    public static int[] twosum(int[] a,int target){
        int start=0,end=a.length-1,sum=0;

        while(start<end){
            
            sum=a[start]+a[end];

            if(sum==target){
                return new int[]{start+1,end+1};
            }
            else if(sum<target){
                start++;
            }else{
                end--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int target=9;
        int[] ans=twosum(a,target);
        System.out.println(Arrays.toString(ans));
    }
}
//T.C=O(n)
//S.C=O(1)
