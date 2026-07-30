/*409. Longest Palindrome
Given a string s which consists of lowercase or uppercase letters, return the length of the
longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.
Example 1: Input: s = "abccccdd" , Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only. */
import java.util.*;
public class P04_LongestPalindrome {
    public static int longestPalindrome(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch : s.toCharArray()){ //O(n)
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int length=0;
        boolean oddFound=false;

        for(int count : map.values()){//O(1)
            if (count%2==0) {
                length+=count;
            }else{
                length+=count-1;
                oddFound=true;
            }
        }
        if (oddFound) {//that one leftover character can become the center.
            length++;
        }
        return length;
    }
    public static void main(String[] args) {
        String s = "abccccdd";
        int ans=longestPalindrome(s);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)
