/*Previous Greater Element
You are given an integer array arr[]. For every element in the array, determine its Previous
Greater Element (PGE).
The Previous Greater Element (PGE) of an element x is the first element that appears to the
left of x in the array and is strictly greater than x.
Note: If no such element exists, assign -1 as the PGE for that position.
Examples: Input: arr[] = [10, 4, 2, 20, 40, 12, 30]
Output: [-1, 10, 4, -1, -1, 40, 40]
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105 */
import java.util.*;
public class P06_PrevGreaterElement{
    public static void main(String[] args) {

        int[] arr={10, 4, 2, 20, 40, 12, 30};
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(-1);
            }else{
                res.add(st.peek());
            }
            st.push(arr[i]);
        }
        System.out.println(res);
    }
}
//T.C=O(n)
//S.C=O(n)