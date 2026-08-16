/*9904. Fruit Into Baskets
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees 
are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount 
of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
Example 1: Input: fruits = [1,2,1]        ,   Output: 3
Explanation: We can pick from all 3 trees.
Example 2: Input: fruits = [1,2,3,2,2]    ,Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
Constraints:
1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length */
package Patterns.SlidingWindow;
import java.util.HashMap;
public class P04_FruitsIntoBasket {
    public static int totalFruit(int[] fruits){
        HashMap<Integer,Integer> map=new HashMap<>();
        int low=0,high=0,res=Integer.MIN_VALUE,k=2;
        while(high<fruits.length){
            int a=fruits[high];
            map.put(a, map.getOrDefault(a, 0)+1);
            while(map.size()>k){
                int b=fruits[low];
                map.put(b, map.get(b)-1);
                if(map.get(b)==0){
                    map.remove(b);
                }
                low++;
            }
            if(map.size()<=k)
            res=Math.max(res, high-low+1);

            high++;
        }
        return res;
    }
    public static void main(String[] args) {
        
        int[] fruits1={1,2,3,2,2};
        int[] fruits2={1,2,1};
        int ans1=totalFruit(fruits1);
        int ans2=totalFruit(fruits2);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
//T.C=O(n)
//S.C=O(n)