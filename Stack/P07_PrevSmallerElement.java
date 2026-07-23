/*Previous Smaller Element
You are given an integer array arr[ ]. For every element in the array, your task is to
determine its Previous Smaller Element (PSE).
The Previous Smaller Element (PSE) of an element x is the first element that appears to
the left of x in the array and is strictly smaller than x.
Note: If no such element exists, assign -1 as the PSE for that position.
Examples:Input: arr[] = [1, 6, 2]  ,  Output: [-1, 1, 1]
Explanation: For 1, there is no element on the left, so answer is -1.
For 6, previous smaller element is 1.
For 2, previous smaller element is 1.
Constraints:
1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105 */

import java.util.*;
public class P07_PrevSmallerElement {
    public static void main(String[] args) {
        int[] arr = { 1, 6, 2 };
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] <= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                res.add(-1);
            } else {
                res.add(st.peek());
            }
            st.push(arr[i]);
        }
        System.out.println(res);
    }
}
// T.C=O(n)
// S.C=O(n)