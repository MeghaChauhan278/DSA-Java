/*1189. Maximum Number of Balloons
Given a string text, you want to use the characters of text to form as many
instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number
of instances that can be formed.
Example 1: Input: text = "loonbalxballpoon" , Output: 2
Constraints:
1 <= text.length <= 104
text consists of lower case English letters only. */
import java.util.*;
public  class P03_MaxNOofBalloons {
    public static int maxNumberOfBalloons(String text){
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int b=map.getOrDefault('b', 0);
        int a=map.getOrDefault('a', 0);
        int l=map.getOrDefault('l', 0)/2;
        int o=map.getOrDefault('o', 0)/2;
        int n=map.getOrDefault('n', 0);

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)),n);
    }
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        int ans=maxNumberOfBalloons(text);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)