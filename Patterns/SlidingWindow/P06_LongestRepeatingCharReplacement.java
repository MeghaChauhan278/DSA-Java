/*424. Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any
 other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations. 
Example:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.*/
package Patterns.SlidingWindow;
public class P06_LongestRepeatingCharReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k=1;
        int[] freq=new int[26];
        int low=0,high=0,res=0,maxcount=0;
        
        while(high<s.length()){
            char ch=s.charAt(high);
            freq[ch - 'A']++;//65-65 , "Increase the frequency count of the current character."

            maxcount=Math.max(maxcount,freq[ch - 'A']);

            while ((high-low+1)-maxcount > k) {
                char left=s.charAt(low);
                freq[left - 'A']--;
                low++;
            }
            res=Math.max(res, high-low+1);
            high++;
        }
        System.out.println(res);
    }
}
