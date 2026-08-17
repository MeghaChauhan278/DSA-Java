/*424. Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it 
to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
Example 1: Input: s = "ABAB", k = 2
Output: 4  Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2: Input: s = "AABABBA", k = 1
Output: 4  Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
Constraints:
1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length*/
package Patterns.SlidingWindow;
public class P06_LongestRepeatingCharReplacement {
     public static int characterReplacement(String s, int k){
        int[] freq=new int[26];
        int low=0,high=0,res=0,maxcount=0;
        while(high<s.length()){
            char ch=s.charAt(high);
            freq[ch-'A']++;
            maxcount=Math.max(maxcount, freq[ch-'A']);
            while((high-low+1)-maxcount >k){
                char ls=s.charAt(low);
                freq[ls-'A']--;
                low++;
            }
            res=Math.max(res, high-low+1);
            high++;
        }
        return res;
     }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k=1;
        String s1 = "ABAB";
        int k1=2;
        int ans=characterReplacement(s,k);
        int ans1=characterReplacement(s1,k1);
        System.out.println(ans);
        System.out.println(ans1);
        
    }
}
//T.C=O(n)
//S.C=O(1)