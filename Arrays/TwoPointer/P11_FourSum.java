/*18. 4Sum
Given an array nums of n integers, return an array of all the unique quadruplets
 [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
Example 1: Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]*/
package Arrays.TwoPointer;
import java.util.*;
public class P11_FourSum {
    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length - 3;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;

            for(int j=i+1;j<nums.length - 2; j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;

                int start=j+1 , end=nums.length-1;
                while(start<end){
                    long sum=(long) nums[i]+nums[j]+nums[start]+nums[end];

                    if (sum==target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;

                        while(start<end && nums[start]==nums[start-1])
                            start++;

                        while (start<end && nums[end]==nums[end+1]) 
                            end--;
                        
                    }
                    else if(sum<target){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
