/*54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1: Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2: Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100 */
package Arrays.TwoDArray;

import java.util.ArrayList;
import java.util.List;

public class P09_SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int rowbegin=0,rowend=m-1,colbegin=0,colend=n-1;
        while(rowbegin<=rowend && colbegin<=colend){
            for(int i=colbegin;i<=colend;i++){
                list.add(matrix[rowbegin][i]);
            }
            rowbegin++;
            for(int i=rowbegin;i<=rowend;i++){
                list.add(matrix[i][colend]);
            }
            colend--;
            if(rowbegin<=rowend){
                for(int i=colend;i>=colbegin;i--){
                list.add(matrix[rowend][i]);
                }
            }
            rowend--;
            if(colbegin<=colend){
                for(int i=rowend;i>=rowbegin;i--){
                list.add(matrix[i][colbegin]);
                }
            }
            colbegin++;
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ans=spiralOrder(matrix);
        System.out.println(ans);
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans1=spiralOrder(matrix1);
        System.out.println(ans1);
    }
}
// TC:O(m*n);
