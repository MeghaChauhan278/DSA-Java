/*1209. Remove All Adjacent Duplicates in String II
You are given a string s and an integer k, a k duplicate removal consists of choosing k
adjacent and equal letters from s and removing them, causing the left and the right side
of the deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It is
guaranteed that the answer is unique.
Example 1: Input: s = "deeedbbcccbdaa", k = 3 ; Output: "aa"
Constraints:
1 <= s.length <= 105
2 <= k <= 104   ,   s only contains lowercase English letters. */
import java.util.*;
public class P11_RemoveAdjacentDuplicatesII {
    static class Pair{
        char ch;
        int count;
        Pair(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public static String removeDuplicates(String s, int k){
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek().ch==ch){
                st.peek().count++;
                if(st.peek().count==k){
                    st.pop();
                }
            }else{
            st.push(new Pair(ch,1));
            }
        }
        StringBuilder ans=new StringBuilder();
        while (!st.isEmpty()){
            Pair curr=st.pop();

            while (curr.count-- > 0) {
                ans.append(curr.ch);
            }
        }
        return ans.reverse().toString();

    }
    public static void main(String[] args) {
        String s="deeedbbcccbdaa";
        int k = 3;
        String ans=removeDuplicates(s,k);
        System.out.println(ans);
    }
}
//T.C,S.C=O(n)