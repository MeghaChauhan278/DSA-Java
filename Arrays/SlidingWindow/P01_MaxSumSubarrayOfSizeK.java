/*Question:Given an array of integers arr[]  and a number k. Return the maximum
 sum of a subarray of size k.
Note: A subarray is a contiguous part of any given array.
Examples:
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum. */
package Arrays.SlidingWindow;

public class P01_MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] a={100, 200, 300, 400};
        int k=2;

        int sum=0;
        int low=0,high=k-1;
        for(int i=0;i<=high;i++){//this loop calculates the sum of the first window of size k.
            sum+=a[i];
        }
        int result=sum;
        while(high<a.length-1){//sliding
            low++;
            sum-=a[low-1];
            high++;

            sum+=a[high];
            result=Math.max(sum, result);
        }
        System.out.println(result);
    }
}
