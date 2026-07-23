/*739. Daily Temperatures
Given an array of integers temperatures represents the daily temperatures, return an array
answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer
temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
Example 1: Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Constraints:
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100 */

import java.util.Arrays;
import java.util.Stack;

public class P08_DailyTemperature {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int n=temperatures.length;
        int[] ans=new int[n];

        Stack<Integer> stack=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i]=stack.peek()-i;
            }
            stack.push(i);
        }
         System.out.println(Arrays.toString(ans));
    }
}

//T.C=O(n)
//S.C=O(n)