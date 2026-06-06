/*Question: Merge two arrays into a single array. */
package Arrays.OneDArray;

public class P08_MergeTwoArrays {
    public static void main(String[] args) {
        int[] a={23,4,5};
        int[] b={83,90,12,89,7};
        int[] c=new int[a.length+b.length];

        for (int i=0; i < a.length; i++) {
            c[i]=a[i];
        }
        for (int i=0;i<b.length; i++) {
            c[a.length+i]=b[i];
        }
        for (int i=0;i<c.length;i++) {
            System.out.print(c[i]+" ");
            
        }
    }
}
