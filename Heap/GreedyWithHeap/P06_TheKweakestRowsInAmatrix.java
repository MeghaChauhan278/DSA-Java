/*1337. The K Weakest Rows in a Matrix
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). 
The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
A row i is weaker than a row j if one of the following is true:
The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
Example 1:Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].
Example 2:Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Constraints:
m == mat.length , n == mat[i].length , 2 <= n, m <= 100 , 1 <= k <= m , matrix[i][j] is either 0 or 1. */
package Heap.GreedyWithHeap;
import java.util.*;
class Pair{
    int first;
    int sec;
    Pair(int f,int s){
        first=f;
        sec=s;
    }
}
public class P06_TheKweakestRowsInAmatrix {
     public static int[] kWeakestRows(int[][] mat, int k){
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> {
                if(a.first!=b.first)
                    return Integer.compare(b.first, a.first);
                return Integer.compare(b.sec, a.sec);
            }
        );
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            int soldiers=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    soldiers++;
                }
            }
            pq.add(new Pair(soldiers,i));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans=new int[k];
        int i=k-1;
        while(!pq.isEmpty()){
            ans[i]=pq.poll().sec;
            i--;
        }
        return ans;
     }
     public static void main(String[] args) {
        int[][] mat={{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k=3;
        int[] ans=kWeakestRows(mat, k);
        System.out.println(Arrays.toString(ans));
     }
}
// TC: O(m × n + m log k)
// Counting soldiers: O(m times n)
// Heap operations: O(mlog k)
// Extracting elements: O(klog k)
// SC: O(k)
// Data type	    Printing method
// int	            System.out.println(num)
// String	        System.out.println(str)
// int array	    Arrays.toString(arr)
// 2D int array	    Arrays.deepToString(arr)