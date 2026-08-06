/*1456. Maximum Number of Vowels in a Substring of Given Length
Given a string s and an integer k, return the maximum number of vowel letters in 
any substring of s with length k.
Example 1: Input: s = "abciiidef", k = 3
Output: 3 , Explanation: The substring "iii" contains 3 vowel letters.
Example 2: Input: s = "leetcode", k = 3
Output: 2 , Explanation: "lee", "eet" and "ode" contain 2 vowels.
Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length */
package Patterns.SlidingWindow;

public class P13_MaxNoOfVowelsInSubstring {
    public static int maxVowels(String s, int k) {
        int low=0 , high=k-1 ,count=0,maxcount=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
        }
        maxcount=count;
        while(high<s.length()-1){
            low++;
            if(s.charAt(low-1)=='a' || s.charAt(low-1)=='e' || s.charAt(low-1)=='i' || s.charAt(low-1)=='o' || s.charAt(low-1)=='u'){
                count--;
            }
            high++;
            if(s.charAt(high)=='a' || s.charAt(high)=='e' || s.charAt(high)=='i' || s.charAt(high)=='o' || s.charAt(high)=='u'){
                count++;
            }
            maxcount=Math.max(maxcount,count);
        }
        return maxcount;
    }
    public static void main(String[] args) {
        String s = "abciiidef";
        int k=3;
        int ans=maxVowels(s,k);
        System.out.println(ans);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
