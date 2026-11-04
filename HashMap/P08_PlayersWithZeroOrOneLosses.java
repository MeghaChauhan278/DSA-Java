/*2225. Find Players With Zero or One Losses
You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player 
winneri defeated player loseri in a match.
Return a list answer of size 2 where:
answer[0] is a list of all players that have not lost any matches.
answer[1] is a list of all players that have lost exactly one match.
The values in the two lists should be returned in increasing order.
Note:
You should only consider the players that have played at least one match.
The testcases will be generated such that no two matches will have the same outcome.
Example 1: Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Example 2: Input: matches = [[2,3],[1,3],[5,4],[6,4]]  ,  Output: [[1,2,5,6],[]]
Constraints:
1 <= matches.length <= 105
matches[i].length == 2
1 <= winneri, loseri <= 105
winneri != loseri
All matches[i] are unique. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P08_PlayersWithZeroOrOneLosses {
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<matches.length;i++){
            map.putIfAbsent(matches[i][0],0);
            map.put(matches[i][1],map.getOrDefault(matches[i][1],0)+1);
        }
        
        for(int key: map.keySet()){
            if(map.get(key)==0){
                ans.get(0).add(key);
                //ans.get(0) → Players with zero losses.,ans.get(1) → Players with exactly one loss.
            }else if(map.get(key)==1){
                ans.get(1).add(key);
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
    public static void main(String[] args) {
        int[][] matches={{2,3},{1,3},{5,4},{6,4}};
        List<List<Integer>> res=findWinners(matches);
        System.out.println(res);
    }
}
// TC: O(n + p log p) average
// SC: O(p)
// n = Number of matches
// p = Number of unique players
// Operation	                Complexity
// First loop (HashMap)	            O(n)
// Second loop (categorization)	    O(p)
// Sorting first list	            O(p log p)
// Sorting second list	            O(p log p)