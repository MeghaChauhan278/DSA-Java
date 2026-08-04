/*1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
Given an array of integers arr and two integers k and threshold, return the number of
sub-arrays of size k and average greater than or equal to threshold.
Example 1: Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively.
All other sub-arrays of size 3 have averages less than 4 (the threshold).
Constraints:
1 <= arr.length <= 105
1 <= arr[i] <= 104
1 <= k <= arr.length
0 <= threshold <= 104 */
package Patterns.SlidingWindow;

public class P12_NoOfSubarraysOfSizeK {
    public static int numOfSubarrays(int[] arr, int k, int threshold){
        int low=0,high=k-1,count=0,sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        double res= (double) sum/k;
        if(res>=threshold){
            count++;
        }
        while(high<arr.length-1){
            low++;
            sum-=arr[low-1];
            high++;
            sum+=arr[high];
            double avg=(double) sum/k;
            if(avg>=threshold){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr={2,2,2,2,5,5,5,8};
        int k=3;
        int threshold = 4;
        int ans=numOfSubarrays(arr,k,threshold);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)
