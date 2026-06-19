/*219. Contains Duplicate II
Given an integer array nums and an integer k, return true if there are two distinct indices i and j 
in the array such that nums[i] == nums[j] and abs(i - j) <= k.
Example 1: Input: nums = [1,2,3,1], k = 3
Output: true
Example 2: Input: nums = [1,0,1,1], k = 1
Output: true
Example 3: Input: nums = [1,2,3,1,2,3], k = 2
Output: false */
package Arrays.SlidingWindow;
import java.util.*;
public class P10_ContainsDuplicatesII {
    public static void main(String[] args) {//fixed sliding window
        int[] nums={1,2,3};
        int k=3;
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean found=false;
        // instead of putting all values at once ,we will put values 1 by 1
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])) {
                int previndex=map.get(nums[i]);
                if(i-previndex <=k){
                    found=true;
                }
            }
            map.put(nums[i], i);
        }
        System.out.println(found);
    }
}
