/*Question:
  Find the sum of elements in each row of a matrix. */
package Arrays.TwoDArray;

public class P05_RowWiseSum {
    public static void main(String[] args) {
        int[][] a = {
                        {1, 2, 3},
                        {4, 5, 6}
                    };
        for(int i=0;i<a.length;i++){
            int sum=0;
            for(int j=0;j<a[i].length;j++){
                sum+=a[i][j];
            }
            System.out.println("Sum of row "+i+" is "+sum);
        }
    }  
}
