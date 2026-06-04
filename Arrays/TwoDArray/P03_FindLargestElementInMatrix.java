/*Question:
  Find the largest element present in a matrix. */
package Arrays.TwoDArray;

public class P03_FindLargestElementInMatrix {
    public static void main(String[] args) {
        int[][] a = { { 1, 34, 9 },
                { 7, 98, 16 } };

        int largest = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > largest) {
                    largest = a[i][j];
                }
            }
        }
        System.out.println(largest);
    }
}
