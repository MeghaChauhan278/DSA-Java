/*1186. Maximum Subarray Sum with One Deletion
Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements)
 with at most one element deletion. In other words, you want to choose a subarray and optionally
  delete one element from it so that there is still at least one element left and the sum of the
remaining elements is maximum possible.
Note that the subarray needs to be non-empty after deleting one element
Example 1:
Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
 */
package Arrays.KadaneAlgorithm;

public class P04_MaxSubarraySumWithOneDel {
    public static void main(String[] args) {
        int[] arr={1,-2,0,3};
        int nodel=arr[0];
        int onedel=Integer.MIN_VALUE, ans=arr[0];
        for(int i=1;i<arr.length;i++){
            int prev_nodel=nodel;
            int prev_onedel=onedel;
            nodel =Math.max(arr[i],prev_nodel+arr[i]);
            int v1;
            if(onedel==Integer.MIN_VALUE){
                v1=arr[i];
            }else{
                v1=arr[i]+prev_onedel;
            }
            onedel=Math.max(v1, prev_nodel);
            ans=Math.max(ans,Math.max(onedel, nodel));
        }
        System.out.println(ans);
    }
}
