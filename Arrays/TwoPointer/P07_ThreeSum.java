/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter. */
package Arrays.TwoPointer;
import java.util.*;
public class P07_ThreeSum {
    public static void main(String[] args) {
        int[] a={-1,0,1,2,-1,-4};
        Arrays.sort(a);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(i>0 && a[i]==a[i-1]){
                continue;
            }
            int start=i+1;
            int end=a.length-1;
            int target=-a[i];

            while(start<end){
                int sum=a[start]+a[end];
                if(sum==target){
                    result.add(Arrays.asList(a[i],a[start],a[end]));
                    start++;
                    end--;

                    while(start<a.length && a[start]==a[start-1]){
                        start++;
                    }
                    while (start<end && a[end] == a[end+1]){
                        end--;
                    }
                }
                else if(sum<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(result);
    }
}
