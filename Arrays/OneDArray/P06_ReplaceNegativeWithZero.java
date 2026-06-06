/*Question: Replace all negative numbers with 0. */
package Arrays.OneDArray;

public class P06_ReplaceNegativeWithZero {
    public static void main(String[] args) {
        int[] a={12,-9,-26,88,0,-2,6,-1};

        for(int i=0;i<a.length;i++){
            if(a[i]<0){
                a[i]=0;
            }
        }
        for (int i=0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
