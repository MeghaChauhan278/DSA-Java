/*Question:
  Find the sum of elements in each column of a matrix. */
package Arrays.TwoDArray;

public class P06_ColumnWiseSum {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        for (int j = 0; j < a[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i][j];
            }
            System.out.println("Sum of column " + j + " is " + sum);
        }
    }
}
