/*973. K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, 
return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Example 1: Input: points = [[1,3],[-2,2]], k = 1  ,  Output: [[-2,2]]
Example 2: Input: points = [[3,3],[5,-1],[-2,4]], k = 2  ,  Output: [[3,3],[-2,4]]
Constraints:
1 <= k <= points.length <= 104
-104 <= xi, yi <= 104 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class P05_KClosestPointsToOrigin {
    static class Pair{
        int first;//distance
        int[] sec;//for actual point i.e array
        Pair(int f,int[] s){
            first=f;
            sec=s;
        }
    }
    public static int[][] kClosest(int[][] points, int k){
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first){
                    return Integer.compare(b.first, a.first);
                }
                return 0;
            }
        );
        for(int[] point:points){
            int x=point[0];
            int y=point[1];
            int distance=x*x + y*y;
            Pair curr=new Pair(distance,point);

            pq.add(curr);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans=new int[k][2];//we have 2 coordinates(x,y) i.e why k,2
        int i=0;
        while(!pq.isEmpty()){
            ans[i]=pq.poll().sec;
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] nums1={{1,3},{-2,2}};
        int k1=1;
        int[][] ans1=kClosest(nums1,k1);

        int[][] nums2={{3,3},{5,-1},{-2,4}};
        int k2=2;
        int[][] ans2=kClosest(nums2,k2);

        System.out.println(Arrays.deepToString(ans1));
        System.out.println(Arrays.deepToString(ans2));
    }
}
// Time: O(n log k)	   {Each insertion/removal takes O(log k)}
// Space: O(k)         {Heap stores at most k points}