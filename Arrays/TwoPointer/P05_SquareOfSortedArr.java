/*Question: Input: a = [-4,-1,0,3,10]
            Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100]. */
package Arrays.TwoPointer;

import java.util.Arrays;

public class P05_SquareOfSortedArr {
    public static void main(String[] args) {
        int[] a = { -4, -1, 0, 3, 10 };
        int[] square = new int[a.length];

        int j = 0;
        while (j < a.length && a[j] <= 0) {
            j++;
        }
        int i = j - 1;
        int k = 0;
        while (i >= 0 && j < a.length) {
            int leftsquare = a[i] * a[i];
            int rightsquare = a[j] * a[j];

            if (leftsquare >= rightsquare) {
                square[k] = rightsquare;
                j++;
            } else {
                square[k] = leftsquare;
                i--;
            }
            k++;
        }
        while (i >= 0) {
            square[k] = a[i] * a[i];
            i--;
            k++;
        }
        while (j < a.length) {
            square[k] = a[j] * a[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(square));
    }
}
