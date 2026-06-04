/*Question:
  Find the sum of elements on the main diagonal of a square matrix.
  (Main diagonal: top-left → bottom-right) */

package Arrays.TwoDArray;

public class P07_MainDiagonalSum {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i]==a[j]){
                    sum+=a[i][j];
                }
            }
        }  
        System.out.println(sum); 
    }
}
