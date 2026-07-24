/*Next Smaller Element(gfg)
You are given an integer array arr[]. For every element in the array, your task is
to determine its Next Smaller Element (NSE).
The Next Smaller Element (NSE) of an element x is the first element that appears to
the right of x in the array and is strictly smaller than x.
If no such element exists, assign -1 as the NSE for that position.
Examples:Input: arr[] = [4, 8, 5, 2, 25]
Output: [2, 5, 2, -1, -1]
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105 */
import java.util.*;
public class P08_NextSmallerElement {
    public static void main(String[] args) {
        int[] nums={4, 8, 5, 2, 25};
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            //while(!st.isEmpty() && st.peek()<=arr[i]) --> next gr ele
            while (!st.isEmpty() && nums[i]<=st.peek()) {
                st.pop();
            }
            if(st.isEmpty()){
                res.add(-1);
            }else{
                res.add(st.peek());
            }
            st.push(nums[i]);
        }
        Collections.reverse(res);
        System.out.println(res);
    }
}
//T.C=O(n)
//S.C=O(n)
