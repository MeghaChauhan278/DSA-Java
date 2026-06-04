package Arrays.TwoDArray;
import java.util.Arrays;
public class PrintMatrix {
    public static void main(String[] args) {

        int[][] a = { { 1, 2, 3 },
                      { 4, 5, 6 },
                      { 6, 7, 8 }
                };
                for(int[] row:a){
                    System.out.println(Arrays.toString(row));
                }
    }
}
