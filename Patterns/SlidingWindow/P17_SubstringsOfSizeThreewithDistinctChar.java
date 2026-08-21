/*1876. Substrings of Size Three with Distinct Characters
A string is good if there are no repeated characters.
Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
Example 1: Input: s = "xyzzaz"   ,   Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".
Example 2: Input: s = "aababcabc"  ,   Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
Constraints:
1 <= s.length <= 100
s​​​​​​ consists of lowercase English letters. */
package Patterns.SlidingWindow;

import java.util.HashMap;

public class P17_SubstringsOfSizeThreewithDistinctChar {
    public static int countGoodSubstrings(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        int k=3;
        int low=0,high=k-1,count=0;

        if(s.length()<k){
            return 0;
        }

        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        if(map.size()==k){
            count++;
        }

        while(high<s.length()-1){
            low++;
            char ls=s.charAt(low-1);
            map.put(ls, map.get(ls)-1);
            if(map.get(ls)==0){
                map.remove(ls);
            }
            high++;
            char rs=s.charAt(high);
            map.put(rs,map.getOrDefault(rs,0)+1);
            if(map.size()==k){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "xyzzaz" ;
        String s1 = "aababcabc" ;
        int ans=countGoodSubstrings(s);
        int ans1=countGoodSubstrings(s1);
        System.out.println(ans);
        System.out.println(ans1);

    }
}
// TC: O(n)
// SC: O(1)

/*for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && a != c && b != c) {
                count++;
            }*/