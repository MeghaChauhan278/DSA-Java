/*Question: Find Second largest Element. */

package Arrays.OneDArray;

public class P09_SecondLargestElement {
    public static int secondLargestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest && nums[i] != largest) {
                secondLargest = nums[i];
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = {8, 8, 7, 6, 5};

        int result = secondLargestElement(nums);
        System.out.println("Second largest element: " + result);
    }
}