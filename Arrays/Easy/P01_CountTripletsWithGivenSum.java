/*Question:
  Program to count the number of triplets whose sum is equal to the given value x */

public class P01_CountTripletsWithGivenSum {
    public static void main(String[] args) {
        int[] a = { 1, 4, 5, 6, 3 };
        int target = 12;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (target == a[i] + a[j] + a[k]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
