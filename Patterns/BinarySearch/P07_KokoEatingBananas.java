/*875. Koko Eating Bananas
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and 
eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not 
eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.
Example 1: Input: piles = [3,6,7,11], h = 8  ,  Output: 4
Example 2: Input: piles = [30,11,23,4,20], h = 5  ,  Output: 30
Example 3: Input: piles = [30,11,23,4,20], h = 6  ,  Output: 23
Constraints:
1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109 */
package Patterns.BinarySearch;
public class P07_KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h){
        int low=1,high=Integer.MIN_VALUE;
        int n=piles.length;
        // Find maximum pile
        for(int i=0;i<n;i++){
            high=Math.max(high, piles[i]);;
        }
        int res=-1;
        while(low<=high){
            int mid=(low+high)/2;
            long hour=fun(piles,n,mid);
            if(hour>h){
                // Speed is too slow
                low=mid+1;
            }else{
                // Speed works
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
    public static  long fun(int[] a,int n,int speed){
        long hour=0;
        for(int i=0;i<n;i++){
            hour+=a[i]/speed;
            if(a[i]%speed!=0){
                hour++;
            }
        }
        return hour;
    }

    public static void main(String[] args) {
        int[] piles={3,6,7,11};
        int h = 8;
        int[] piles1={30,11,23,4,20};
        int h1 = 5;
        int[] piles2={30,11,23,4,20};
        int h2 = 6;
        int ans=minEatingSpeed(piles,h);
        int ans1=minEatingSpeed(piles1,h1);
        int ans2=minEatingSpeed(piles2,h2);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
// TC: O(n log(max(piles)))
// SC: O(1)