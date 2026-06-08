/*Question: Input: a = [2,7,11,15], target = 9
            Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2]. */

package Arrays.TwoPointer;
import java.util.Arrays;
public class P01_TwoSumII {
    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int target=9;
        int start=0;
        int end=a.length-1;
        while(start<end){
            int sum=a[start]+a[end];
            if(target==sum){
                System.out.println(Arrays.toString( new int[]{start+1,end+1}));
                return;

            }else if(target>sum){
                start++;
            }else if(target<sum){
                end--;
            }
        }
        System.out.println(new int[]{-1,-1});
    }
}
