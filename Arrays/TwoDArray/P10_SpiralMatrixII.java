/*59. Spiral Matrix II
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Example 1: Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2: Input: n = 1
Output: [[1]]
Constraints:
1 <= n <= 20 */
package Arrays.TwoDArray;

import java.util.Arrays;

public class P10_SpiralMatrixII {
    public static  int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int rowb=0,rowe=n-1,colb=0,cole=n-1, num=1;
        while(rowb<=rowe && colb<=cole){
            for(int i=colb;i<=cole;i++){
                ans[rowb][i]=num++;
            }
            rowb++;
            for(int i=rowb;i<=rowe;i++){
                ans[i][cole]=num++;
            }
            cole--;
            if(rowb<=rowe){
                for(int i=cole;i>=colb;i--){
                    ans[rowe][i]=num++;
                }
            }
            rowe--;
            if(colb<=cole){
                for(int i=rowe;i>=rowb;i--){
                    ans[i][colb]=num++;
                }
            }
            colb++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n=3;
        int[][] ans=generateMatrix(n);
        System.out.println(Arrays.deepToString(ans));
        int n1=1;
        int[][] ans1=generateMatrix(n1);
        System.out.println(Arrays.deepToString(ans1));
    }
}
// TC:O(n^2)