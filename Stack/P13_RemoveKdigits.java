/*402. Remove K Digits
Given string num representing a non-negative integer num, and an integer k, return the smallest 
possible integer after removing k digits from num.
Example 1: Input: num = "1432219", k = 3   ,   Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2: Input: num = "10200", k = 1     ,   Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3: Input: num = "10", k = 2   ,    Output: "0"
Constraints:
1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself. */

import java.util.Stack;

public class P13_RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while (k > 0) {//Remove remaining digits
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans.reverse();
        int i = 0;//Remove leading zeros
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        if (i == ans.length()) {
            return "0";
        }
        return ans.substring(i);
    }

    public static void main(String[] args) {
        String num1 = "1432219";
        int k1 = 3;
        String num2 = "10200";
        int k2 = 1;
        String num3 = "10";
        int k3 = 2;
        String ans1 = removeKdigits(num1, k1);
        String ans2 = removeKdigits(num2, k2);
        String ans3 = removeKdigits(num3, k3);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
// TC=O(n)
// SC=O(n)