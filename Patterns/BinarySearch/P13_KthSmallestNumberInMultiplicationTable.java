/* 668. Kth Smallest Number in Multiplication Table
Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat 
where mat[i][j] == i * j (1-indexed).
Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.
Example 1: Input: m = 3, n = 3, k = 5  ,  Output: 3
Explanation: The 5th smallest number is 3.
Example 2: Input: m = 2, n = 3, k = 6  ,  Output: 6
Explanation: The 6th smallest number is 6.
Constraints:
1 <= m, n <= 3 * 104
1 <= k <= m * n */
package Patterns.BinarySearch;
public class P13_KthSmallestNumberInMultiplicationTable {
    public static int findKthNumber(int m, int n, int k){
        int low=1;
        int high=m*n;
        while(low<high){
            int mid=low+(high-low)/2;
            int count=fun(m,n,mid);
            if(count<k){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
    public static int fun(int m,int n,int target){
        int count=0;
        for(int i=1;i<=m; i++){
            count+=Math.min(target/i,n);
        }
        return count;
    }
    public static void main(String[] args) {
        int m=3,n=3,k=5;
        int m1=2,n1=3,k1=6;
        int ans=findKthNumber(m,n,k);
        System.out.println(ans);
        int ans1=findKthNumber(m1,n1,k1);
        System.out.println(ans1);
    }
}
// TC: m(log(mn))
// SC: O(1)