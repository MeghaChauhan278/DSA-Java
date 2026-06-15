/*Question: Given an array of integers nums and an integer target, return indices of the two numbers such 
that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example 1:
Input: nums = [2,7,11,15], target = 9        Input: nums = [3,2,4], target = 6
Output: [0,1]                                       Output: [1,2]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]. */
package Arrays.TwoPointer;
import java.util.*;
public class P00_TwoSum {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target = 9;
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int needed=target-nums[i];
            
            if(map.containsKey(needed)){
                System.out.println(Arrays.toString(new int[]{map.get(needed),i}));
                return;
            }
            map.put(nums[i], i);//stores value in hashmap if needed value isnt found
        }
        // System.out.println(Arrays.toString(new int[]{})); -->inp always has a soln, this won't run
    }
    
}
