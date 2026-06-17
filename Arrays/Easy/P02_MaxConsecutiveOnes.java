/*485. Max Consecutive Ones
Given a binary array nums, return the maximum number of consecutive 1's in the array.
Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3. */
public class P02_MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums={1,1,0,1,1,1};

        int count=0,maxcount=0;
        for(int num : nums){
            if(num==1){
                count++;
                maxcount=Math.max(maxcount, count);
            }else{
                count=0;
            }
        }
        System.out.println(maxcount);
    }
}
