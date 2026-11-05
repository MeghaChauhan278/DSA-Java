/*451. Sort Characters By Frequency
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency 
of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.
Example 1: Input: s = "tree"  ,  Output: "eert"
Example 2: Input: s = "Aabb"  ,  Output: "bbAa"
Constraints:
1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P10_SortCharactersByFrequency {
    public static String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Character> list=new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b)->map.get(b)-map.get(a));

        StringBuilder ans=new StringBuilder();
        for(char ch:list){
            int freq=map.get(ch);
            for(int i=0;i<freq;i++){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s="tree";
        String s1="Aabb";
        String ans=frequencySort(s);
        String ans1=frequencySort(s1);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
//TC: O(n + k log k)
// SC: O(n + k), including output.