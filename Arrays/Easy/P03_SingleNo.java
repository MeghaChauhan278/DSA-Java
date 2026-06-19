/*136. Single Number
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,1] , Output: 1 */

import java.util.HashMap;

public class P03_SingleNo {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] nums={2,2,1};
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)==1){
                System.out.println(key);
            }
        }
        System.out.println(-1);
    }
}
