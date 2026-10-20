/*Aggressive Cows
Given an integer array arr[], which denotes the positions of stalls. All the positions are distinct. 
There are k aggressive cows.
Assign the cows to the stalls such that the minimum distance between any two cows is maximized.
Examples: Input: arr[] = [1, 2, 4, 8, 9], k = 3  ,  Output: 3
Input: arr[] = [10, 1, 2, 7, 5], k = 3  ,  Output: 4
Constraints:
arr.size() ≤ 106
0 ≤ arr[i] ≤ 108
2 ≤ k ≤ arr.size() */
package Patterns.BinarySearch;
import java.util.*;
public class P08_AggressiveCows {
    public static  int aggressiveCows(int[] arr, int k){
        int n=arr.length;
        Arrays.sort(arr);
        int low=1,high=arr[n-1]-arr[0], res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            if(fun(arr,n,k,guess)){
                res=guess;
                low=guess+1;
            }else{
                high=guess-1;
            }
        }
        return res;
    }
    public static  boolean fun(int[] arr,int n,int k,int guess){
        int cow=1;
        int prevpos=arr[0];
        for(int i=1;i<n;i++){
            int dist=arr[i]-prevpos;
        
            if(dist<guess){
                continue;
            }
            cow++;
            prevpos = arr[i];

            if(cow>=k){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 9};
        int k=3; 
        int[] arr1 = {10, 1, 2, 7, 5};
        int k1=3; 
        int ans=aggressiveCows(arr,k);
        System.out.println(ans);
        int ans1=aggressiveCows(arr1,k1);
        System.out.println(ans1);
    }
}
// TC:O(nlogn+nlogD)
// SC:O(1)