/*Question: Merge Two Sorted Array. */

package Arrays.TwoPointer;

import java.util.Arrays;

public class P04_MergeSortedArray {
    public static void main(String[] args) {
        int[] a={1,3,5};
        int[] b={2,4,6};
        int[] c=new int[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                c[k]=a[i];
                i++;;
            }else{
                c[k]=b[j];
                j++;
            }
            k++;
        }
        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(c));
    }
}
