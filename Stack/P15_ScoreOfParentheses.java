/*856. Score of Parentheses
Given a balanced parentheses string s, return the score of the string.
The score of a balanced parentheses string is based on the following rule:
-> "()" has score 1.
-> AB has score A + B, where A and B are balanced parentheses strings.
-> (A) has score 2 * A, where A is a balanced parentheses string.
Example 1: Input: s = "()"  ,  Output: 1
Example 2: Input: s = "(())"  , Output: 2
Example 3: Input: s = "()()" , Output: 2
Constraints:
2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string. */

import java.util.Stack;

public class P15_ScoreOfParentheses {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(0);
            } else {
                int top = st.pop();
                if (top == 0) {
                    top = 1;
                } else {
                    top = 2 * top;
                }
                st.push(st.pop() + top);
            }
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String s = "()";
        String s1 = "(())";
        String s2 = "()()";
        int ans = scoreOfParentheses(s);
        int ans1 = scoreOfParentheses(s1);
        int ans2 = scoreOfParentheses(s2);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
// Time Complexity  = O(n)
// Space Complexity = O(n)