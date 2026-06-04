/*Question:
  Search for a given element in a matrix and print its position. */

package Arrays.TwoDArray;

public class P04_SearchElementInMatrix {
    public static void main(String[] args) {
        int[][] a = { { 1, 23, 6 },
                { 9, 67, 12 } };

        int element = 12;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (element == a[i][j]) {
                    System.out.println("Element found at row " + i + " and column " + j);
                }
            }
        }
    }
}
