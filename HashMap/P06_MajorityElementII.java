/*229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.
Example 1: Input: nums = [3,2,3]  ,  Output: [3]
Example 2: Input: nums = [1]  ,  Output: [1]
Example 3: Input: nums = [1,2]  ,  Output: [1,2]
Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
Follow up: Could you solve the problem in linear time and in O(1) space?*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P06_MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>n/3){
                list.add(key);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums={3,2,3};
        int[] nums1={1,2};
        List<Integer> ans=majorityElement(nums);
        List<Integer> ans1=majorityElement(nums1);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
//TC,SC: O(n)