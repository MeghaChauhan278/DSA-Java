/*242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Example 1: Input: s = "anagram", t = "nagaram"
Output: true
Example 2: Input: s = "rat", t = "car"
Output: false
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters. */

import java.util.HashMap;

public class P07_ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!map.containsKey(ch) || map.get(ch)==0){
                return false;
            }
            map.put(ch,map.get(ch)-1);
        }
        return true;
    }
    public static void main(String[] args) {
        String s="anagram",t="nagaram";
        boolean ans=isAnagram(s,t);
        System.out.println(ans);
    }
}
//TC:O(n)
//SC:O(1)