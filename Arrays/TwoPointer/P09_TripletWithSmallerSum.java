/*Question: Given an array arr[] of distinct integers and a value sum, find the count of triplets (i, j, k),
  having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.
Examples :
Input: sum = 2, arr[] = [-2, 0, 1, 3]
Output:  2
Explanation: Triplets with sum less than 2 are (-2, 0, 1) and (-2, 0, 3).  */
package Arrays.TwoPointer;
import java.util.*;
public class P09_TripletWithSmallerSum {
    public static void main(String[] args) {
        int[] a={-2, 0, 1, 3};
        int sum=2;

        int count=0;
        Arrays.sort(a);

        for(int i=0;i<a.length-2;i++){
            int start=i+1;
            int end=a.length-1;

            while(start<end){
                int result=a[i]+a[start]+a[end];

                if(result<sum){
                    count+=end-start;
                    start++;
                }
                else{
                    end--;
                }

            }
        }
        System.out.println(count);
    }
}
