/*Longest Substring with K Uniques
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the 
length of the longest substring that contains exactly k distinct characters.
Note : If no such substring exists, return -1. 
Examples: Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26 */
package Patterns.SlidingWindow;
import java.util.HashMap;
//Sliding.W +hashmap
public class P03_LongestSubstringWithKdistinctCHAR {
    public static int longestKSubstr(String s, int k){
        HashMap<Character,Integer> map=new HashMap<>();
        int low=0,high=0,res=-1;
        while(high<s.length()){
            char ch=s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.size()>k){
                char ls=s.charAt(low);
                map.put(ls,map.get(ls)-1);
                if(map.get(ls)==0){
                    map.remove(ls);
                }
                low++;
            }
            if (map.size()==k) {
                res=Math.max(res, high-low+1);
            }
            high++;
        }
        return res;
    }
    public static void main(String[] args) {
        String s1 = "aabacbebebe";
        int k1=3;
        String s2 = "aaaa";
        int k2=2;
        int ans1=longestKSubstr(s1,k1);
        int ans2=longestKSubstr(s2,k2);
        System.out.println(ans1);
        System.out.println(ans2);

    }
}
//T.C=O(n)
//S.C=O(n)