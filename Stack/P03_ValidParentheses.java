/*20. Valid Parentheses
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1: Input: s = "([)]" , Output: false
Constraints:1 <= s.length <= 104 ,s consists of parentheses only '()[]{}'. */

import java.util.*;

public class P03_ValidParentheses {
    public static void main(String[] args) {
        String s = "([)]";
        boolean isValid=true;

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    isValid=false;
                    break;
                }

                char top=stack.pop();
                if(ch==')' && top!='('){
                    isValid=false;
                    break;
                }
                if(ch==']' && top!='['){
                    isValid=false;
                    break;
                }
                if(ch=='}' && top!='{'){
                    isValid=false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            isValid = false;
        }
        System.out.println(isValid);
    }
}

//T.C=O(n)
//S.C=O(n)