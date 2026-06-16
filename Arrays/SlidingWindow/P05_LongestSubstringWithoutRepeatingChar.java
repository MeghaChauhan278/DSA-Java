/*3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:*/
package Arrays.SlidingWindow;
import java.util.*;
public class P05_LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "abcabcbb";
        HashMap<Character,Integer> map=new HashMap<>();
        int high=0,low=0,res=0;
        while(high<s.length()){
            char ch=s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            int k=high-low+1;

            while(map.size()<k){
                char leftch=s.charAt(low);
                map.put(leftch, map.get(leftch)-1);

                if(map.get(leftch)==0){
                    map.remove(leftch);
                }
                low++;
                k=high-low+1;//bcoz length is changing
            }
            res=Math.max(res, high-low+1);
            high++;
        }
        System.out.println(res);
    }
}
