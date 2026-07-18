/*503. Next Greater Element II
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order
 next in the array, which means you could search circularly to find its next greater number. 
If it doesn't exist, return -1 for this number.
Example 1:Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Constraints: 1 <= nums.length <= 104 , -109 <= nums[i] <= 109 */
import java.util.*;
public class P05_NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums={1,2,1};
        int n=nums.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i%n]){
                stack.pop();
            }
            ans[i%n]=stack.isEmpty()? -1 : nums[stack.peek()];
            stack.push(i%n);
        }
        System.out.println(Arrays.toString(ans));
    }
}
//T.C=O(n)
//S.C=O(n)
