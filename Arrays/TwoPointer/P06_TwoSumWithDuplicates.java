/*Questions: Given a sorted array that may contain duplicate elements and a target value,
 find all unique pairs whose sum equals the target. */

package Arrays.TwoPointer;
import java.util.Arrays;

public class P06_TwoSumWithDuplicates {
    public static void main(String[] args) {
        int[] a = { 1, 1, 1, 2, 2, 3, 3, 3 };
        int target = 4;
        int start = 0;
        int end = a.length - 1;

        while (start < end) {
            int sum = a[start] + a[end];
            if (sum == target) {
                System.out.println(Arrays.toString(new int[] { start, end }));
                start++;
                end--;
                while (start < end && a[start] == a[start - 1]) {
                    start++;
                }
                while (start < end && a[end] == a[end + 1]) {
                    end--;
                }
            } else if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            }

        }
    }
}
