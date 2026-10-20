/*240. Search a 2D Matrix II
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the 
following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example 1: Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5  ,  Output: true
Example 2: Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20  ,  Output: false
Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109 */
package Patterns.BinarySearch;
public class P11_SearchA2dMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;
        int row=m-1,col=0;
        while(row>=0 && col<n){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                col++;
            }else{
                row--;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        int[][] matrix1 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target1 = 20;
        boolean ans=searchMatrix(matrix,target);
        System.out.println(ans);
        boolean ans1=searchMatrix(matrix1,target1);
        System.out.println(ans1);
    }
}
// TC:O(m+n)
// SC:O(1)