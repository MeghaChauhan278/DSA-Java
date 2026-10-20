/*74. Search a 2D Matrix
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
Example 1:Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3  ,  Output: true
Example 2: Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13  ,  Output: false
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104 */
package Patterns.BinarySearch;
public class P10_SearchA2dMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0,high=m*n-1;
        while(low<=high){
            int mid=(low+high)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;
        int[][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target2 = 13;
        boolean ans=searchMatrix(matrix1,target1);
        System.out.println(ans);
        boolean ans2=searchMatrix(matrix2,target2);
        System.out.println(ans2);
    }
}
// TC: O(log(m×n))
// SC:O(1) 