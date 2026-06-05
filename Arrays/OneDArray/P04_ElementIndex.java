/*Question: Find the index of a given element. */
package Arrays.OneDArray;

public class P04_ElementIndex {
    public static void main(String[] args) {
        int[] a={23,69,45,31,66};
        int target=31;
        int index=-1;

        for (int i=0;i<a.length; i++) {
            if(a[i]==target){
                index=i;
                break;
            }
            
        }
        System.out.println("Index= "+index);
    }
    
}
