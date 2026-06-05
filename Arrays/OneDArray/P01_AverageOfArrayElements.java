/*Question:Find the average of array elements. */
package Arrays.OneDArray;

public class P01_AverageOfArrayElements {
    public static void main(String[] args) {
        int[] a={10,15,5};
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        double avg=(double)sum/a.length;
        System.out.println(avg);
    }
}
