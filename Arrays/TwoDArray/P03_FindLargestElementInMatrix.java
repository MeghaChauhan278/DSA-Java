/*Question:
  Find the largest element present in a matrix. */
package Arrays.TwoDArray;
public class P03_FindLargestElementInMatrix {
    public static void main(String[] args) {
        int largest=1;
        int[][] a={{1,34,9},
                   {7,98,16}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j]>largest){
                    largest=a[i][j];
                }
            }
        }  
        System.out.println(largest);                 
    }
}
