/*Question: Input: nums = [0,0,1,1,1,1,2,3,3]
            Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively. */

package Patterns.TwoPointer;
import java.util.Arrays;
public class P03_RemoveDuplicatesII {
    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,1,2,3,3};
        int slow=2;
        int fast=2;
        while(fast<nums.length){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(slow);
        System.out.println(Arrays.toString(nums));
    }
}
