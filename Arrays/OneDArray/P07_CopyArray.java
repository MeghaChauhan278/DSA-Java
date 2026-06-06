/*Question: Copy elements from one array to another. */
package Arrays.OneDArray;

public class P07_CopyArray {
    public static void main(String[] args) {
        int[] a={23,67,9,45,80};
        int[] b=new int[a.length];

        for (int i=0; i<a.length; i++) {
            b[i]=a[i];
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
            
        }
    }
}
