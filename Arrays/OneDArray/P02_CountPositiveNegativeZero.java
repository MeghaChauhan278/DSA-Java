/*Question: Count positive, negative, and zero elements in an array. */
package Arrays.OneDArray;

public class P02_CountPositiveNegativeZero {
    public static void main(String[] args) {
        int[] a={11,-2,0,7,-55,20,6,-79,0};
        int positive=0;
        int negative=0;
        int zero=0;

        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                zero++;
            }else if(a[i]>0){
                positive++;
            }else if(a[i]<0){
                negative++;
            }
        }
        System.out.println("Zero " + zero);
        System.out.println("Postive "+positive);
        System.out.println("Negative "+negative); 
    }
}
