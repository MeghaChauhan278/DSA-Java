/*767. Reorganize String
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.
Example 1: Input: s = "aab"  :  Output: "aba"
Example 2: Input: s = "aaab"  :  Output: ""
Constraints:
1 <= s.length <= 500
s consists of lowercase English letters.*/
package Heap.GreedyWithHeap;
import java.util.*;
public class P01_ReorganizeString {
    static class Pair{
        int first;
        char sec;
        Pair(int f,char s){
            first=f;
            sec=s;
        }
    }
    public static  String reorganizeString(String s){
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> Integer.compare(b.first, a.first)
        );
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(Character key:map.keySet()){
            Pair curr=new Pair(map.get(key),key);
            pq.add(curr);
        }
        StringBuilder res=new StringBuilder();
        int seat=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(seat==0 || res.charAt(seat-1)!=p.sec){
                res.append(p.sec);
                seat++;
                p.first--;
                if(p.first>0){
                    pq.add(p);
                }
            }else{
                if(pq.isEmpty()){
                    return  "";
                }
                Pair p2=pq.poll();
                res.append(p2.sec);
                seat++;
                p2.first--;
                if(p2.first>0){
                    pq.add(p2);
                }
                pq.add(p);
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        // String s="aab";
        // String s2="aaab";
        // String ans=reorganizeString(s);
        // System.out.println(ans);
        // String ans2=reorganizeString(s2);
        // System.out.println(ans2);
    }
}
// TC: O(nlog p), effectively (O(n)) for lowercase English letters.
// SC: O(n), including the output StringBuilder.