/*Question:
Count the total number of even and odd elements in a matrix.
*/
package Arrays.TwoDArray;

public class P01_CountEvenAndOddNumbers {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
        }

        System.out.println("Even Count = " + evenCount);
        System.out.println("Odd Count = " + oddCount);
    }
}
