/*Merge k Sorted Arrays
Given a 2D matrix mat[][] of size n x m. Each row in the matrix is sorted in non-decreasing order, 
merge all the rows and return a single sorted array that contains all the elements of the matrix.
Examples : Input: mat[][] = [[1, 3, 5, 7], [2, 4, 6, 8], [0, 9, 10, 11]]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Explanation: Merging all elements from the 3 sorted arrays and sorting them results in: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Input: mat[][] = [[1, 2, 3, 4], [2, 2, 3, 4], [5, 5, 6, 6], [7, 8, 9, 9]]
Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9] 
Explanation: Merging all elements from the 4 sorted arrays and sorting them results in:[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
Constraints:
1 ≤ n * m ≤ 105
0 ≤ mat[i][j] ≤ 106 */
package Heap.HeapAsPointer;

import java.util.*;
class Node{
    int value;
    int row;
    int col;
    Node(int v,int r,int c){
        value=v;
        row=r;
        col=c;
    }
}
public class P01_MergeksortedArrays {
    public static ArrayList<Integer> mergeArrays(int[][] mat){
        PriorityQueue<Node> pq=new PriorityQueue<>(
            (a,b)-> Integer.compare(a.value, b.value)
        );
        int m=mat.length;
        int n=mat[0].length;

        for(int i=0;i<m;i++){
            pq.add(new Node(mat[i][0], i, 0));
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            Node curr=pq.poll();

            int value=curr.value;
            int row=curr.row;
            int col=curr.col;

            ans.add(value);

            if (col<n-1) {
                pq.add(new Node(mat[row][col+1], row, col+1));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] mat={{1, 3, 5, 7},{2, 4, 6, 8},{0, 9, 10, 11}};
        int[][] mat1={{1, 2, 3, 4},{2, 2, 3, 4},{5, 5, 6, 6},{7, 8, 9, 9}};
        ArrayList<Integer> ans=mergeArrays(mat);
        ArrayList<Integer> ans1=mergeArrays(mat1);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
// Time Complexity: O(m × n × log m)
// Space Complexity: O(m × n)