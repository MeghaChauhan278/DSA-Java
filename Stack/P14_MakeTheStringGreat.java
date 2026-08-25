/*1544. Make The String Great
Given a string s of lower and upper case English letters.
A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
->0 <= i <= s.length - 2
->s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. 
You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.
Example 1: Input: s = "leEeetcode"  ,  Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2: Input: s = "abBAcC"   ,  Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3: Input: s = "s"  ,  Output: "s"
Constraints:
1 <= s.length <= 100
s contains only lower and upper case English letters. */
import java.util.*;
public class P14_MakeTheStringGreat{
    public static String makeGood(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek()-ch)==32){//uppercase and lowercase of the same letter differ by 32
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "leEeetcode";
        String s1 = "abBAcC";
        String s2 = "s";
        String ans=makeGood(s);
        String ans1=makeGood(s1);
        String ans2=makeGood(s2);
        System.out.println("\"" + ans + "\"");
        System.out.println("\"" + ans1 + "\"");
        System.out.println("\"" + ans2 + "\"");
    }
}
// TC = O(n)
// Traverse the string → O(n)
// Build the answer → O(n)
// Reverse → O(n)
// SC = O(n)
// Stack can contain up to n characters.
// StringBuilder also uses O(n).