/*Question: You are given a string s consisting only lowercase alphabets and an integer k. 
Your task is to find the length of the longest substring that contains exactly k distinct characters.
Note : If no such substring exists, return -1. 
Examples:
Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'. */
package Patterns.SlidingWindow;
import java.util.HashMap;
//Sliding.W +hashmap
public class P03_LongestSubstringWithKdistinctCHAR {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k=3;

        HashMap<Character,Integer> map=new HashMap<>();

        int low=0,high=0,res=-1;

        while(high<s.length()){
            char ch=s.charAt(high);
            map.put(ch, map.getOrDefault(ch,0)+1);

            while (map.size()>k) {
                char leftchar=s.charAt(low);
                map.put(leftchar, map.get(leftchar)-1);

                if(map.get(leftchar)==0){
                    map.remove(leftchar);
                }
                low++;
                
            }
            if (map.size()==k) {
                int len=high-low+1;
                res=Math.max(res, len);
                
            }
            high++;
        }
        System.out.println(res);
    }
}
