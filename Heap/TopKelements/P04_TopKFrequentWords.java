/*692. Top K Frequent Words
Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same 
frequency by their lexicographical order.
Example 1: Input: words = ["i","love","leetcode","i","love","coding"], k = 2  ,  Output: ["i","love"]
Example 2: Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"] 
Constraints:
1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space? */
// package Heap.TopKelements;
import java.util.*;

public class P04_TopKFrequentWords {
    static class Pair{
        int first;
        String sec;
        Pair(int f, String s){
            first=f;
            sec=s;
        }
    }
    public static List<String> topKFrequent(String[] words, int k){
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first){
                    return Integer.compare(a.first, b.first);
                }
                return b.sec.compareTo(a.sec);
            }
        );
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        for(String key:map.keySet()){
            String element=key;
            int freq=map.get(key);
            Pair curr=new Pair(freq,element);
            if(pq.size()<k){
                pq.add(curr);
            }else if(freq>pq.peek().first || (freq==pq.peek().first && element.compareTo(pq.peek().sec)<0)){
                pq.poll();
                pq.add(curr);
            }
        }
        List<String> ans=new ArrayList<>();
        while (!pq.isEmpty()){
            ans.add(pq.poll().sec);
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        String[] word1={"i","love","leetcode","i","love","coding"};
        int k1=2;
        List<String> ans1=topKFrequent(word1,k1);
        System.out.println(ans1);
        String[] word2={"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k2=4;
        List<String> ans2=topKFrequent(word2,k2);
        System.out.println(ans2);
    }
}
// TC:O(n+plog k)
// SC:O(p+k)