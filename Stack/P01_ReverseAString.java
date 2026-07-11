/*Reverse a String
You are given a string s, and your task is to reverse the string.
Examples: Input: s = "Geeks"
Output: "skeeG"
Constraints:
1 <= s.size() <= 106
s contains only alphabetic characters (both uppercase and lowercase). */
import java.util.*;
public class P01_ReverseAString {
    public static void main(String[] args) {
        String s = "Geeks";
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            st.push(s.charAt(i));
        }
        StringBuilder ans=new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        System.out.println(ans);
    }
}

//T.C=O(n)
