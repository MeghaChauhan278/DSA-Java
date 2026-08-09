/*125. Valid Palindrome
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
and removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1: Input: s = "A man, a plan, a canal: Panama"
Output: true , Explanation: "amanaplanacanalpanama" is a palindrome.
Constraints:1 <= s.length <= 2 * 105
s consists only of printable ASCII characters. */
package Patterns.TwoPointer;
import java.util.*;
public class P14_ValidPalindrome {
    public static boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean ans=isPalindrome(s);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)
