/*Question: Find the second largest element in an array. */
package Arrays.OneDArray;

public class P03_FindSecondLargest {
    public static void main(String[] args) {
        int[] a={11,6,23,17,33};
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i]>largest){
                secondLargest=largest;
                largest=a[i];
            }
            else if(a[i] > secondLargest && a[i] !=largest){
                secondLargest=a[i];
            }
        }
        System.out.println("Second largest element= " +secondLargest);
    }
}
