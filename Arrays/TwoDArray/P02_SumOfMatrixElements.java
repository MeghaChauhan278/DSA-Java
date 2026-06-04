/*Question:
Find the sum of all elements in a matrix. */

package Arrays.TwoDArray;

public class P02_SumOfMatrixElements {
    public static void main(String[] args) {
        int sum = 0;

        int[][] a = { { 1, 2 },
                      { 3, 4 }
        };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }
}
