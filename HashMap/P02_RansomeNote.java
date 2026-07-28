/*383. Ransom Note
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by 
using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.
Example 1: Input: ransomNote = "aa", magazine = "aab"
Output: true
Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters. */
import java.util.*;
public class P02_RansomeNote {
    public static boolean canConstruct(String ransomNote, String magazine){

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            char ch=magazine.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            char r=ransomNote.charAt(i);
            if(!map.containsKey(r) || map.get(r)==0){
                return false;
            }
            map.put(r,map.get(r)-1);
        }
        return true;
    } 
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean ans=canConstruct(ransomNote,magazine);
        System.out.println(ans);
    }
}
//T.C=O(m+n)  ->m : mag.len , ->n : ransom.len
//S.C=O(1)
