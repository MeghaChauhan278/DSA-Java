/*387. First Unique Character in a String
Given a string s, find the first non-repeating character in it and return its index. If it
does not exist, return -1.
Example 1: Input: s = "loveleetcode" , Output: 2
Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters. */
import java.util.*;
public class P01_FirstUniqueCharInString {

    public static int firstUniqChar(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String s = "loveleetcode";
        int ans=firstUniqChar(s);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)
