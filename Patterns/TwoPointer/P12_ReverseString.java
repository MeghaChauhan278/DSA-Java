/*344. Reverse String
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"] */
package Patterns.TwoPointer;

public class P12_ReverseString {
    public static void main(String[] args) {
        char[] s = { 'h', 'e', 'l', 'l', 'o' };

        int start = 0;
        int end = s.length - 1;

        while (start < end) {

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        for (char ch : s) {
            System.out.print(ch + " ");
        }
    }
}
