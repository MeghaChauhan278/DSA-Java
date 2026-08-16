/*3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.
Example 1: Input: s = "abcabcbb"  ,  Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2: Input: s = "bbbbb"     ,Output: 1
Explanation: The answer is "b", with the length of 1.
Constraints:
0 <= s.length <= 105
s consists of English letters, digits, symbols and spaces.*/
package Patterns.SlidingWindow;

import java.util.HashMap;

public class P05_LongestSubstringWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int low = 0, high = 0, res = -1;
        while (high < s.length()) {
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            int k = high - low + 1;

            while (map.size() < k) {
                char ls = s.charAt(low);
                map.put(ls, map.get(ls) - 1);

                if (map.get(ls) == 0) {
                    map.remove(ls);
                }

                low++;
                k = high - low + 1;
            }
            res = Math.max(res, high - low + 1);
            high++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        int ans1 = lengthOfLongestSubstring(s1);
        int ans2 = lengthOfLongestSubstring(s2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
//T.C=O(n)
//S.C=O(1)