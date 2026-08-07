/*438. Find All Anagrams in a String
Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.
Example 1: Input: s = "cbaebabacd", p = "abc" , Output: [0,6]
Explanation: The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Constraints: 1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters. */
package Patterns.SlidingWindow;
import java.util.*;
public class P14_AnagramInString {
    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> ans = new ArrayList<>();

        HashMap<Character,Integer> sMap=new HashMap<>();
        HashMap<Character,Integer> pMap=new HashMap<>();

        int k = p.length();

        for (int i=0;i<k;i++) {
            char ch1=p.charAt(i);
            pMap.put(ch1, pMap.getOrDefault(ch1, 0) + 1);

            char ch2 = s.charAt(i);
            sMap.put(ch2, sMap.getOrDefault(ch2, 0) + 1);
        }

        int low = 0;
        int high = k-1;

        if (pMap.equals(sMap))
            ans.add(low);

        while (high<s.length()-1) {
            low++;
            char left = s.charAt(low - 1);
            sMap.put(left, sMap.get(left) - 1);

            if (sMap.get(left)==0)
                sMap.remove(left);

            high++;
            char right = s.charAt(high);
            sMap.put(right, sMap.getOrDefault(right, 0) + 1);

            if (pMap.equals(sMap))
                ans.add(low);
        }
        return ans;

    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> res=findAnagrams(s,p);
        System.out.println(res);

    }
// }
// Time Complexity: O(n)
// Space Complexity: O(1) (because the alphabet size is fixed at 26 lowercase English letters)