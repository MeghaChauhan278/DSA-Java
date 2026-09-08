/*Ceil in a Sorted Array
Given a sorted array arr[] and an integer x, find the index (0-based) of the smallest element in arr[] 
that is greater than or equal to x. This element is called the ceil of x. If such an element does not exist, return -1.
Note: In case of multiple occurrences of ceil of x, return the index of the first occurrence.
Examples: Input1: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 5
Output: 2 Explanation: Smallest number greater than 5 is 8, whose index is 2.
Input2: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 20
Output: -1 Explanation: No element greater than 20 is found. So output is -1.
Input3: arr[] = [1, 1, 2, 8, 10, 11, 12, 19], x = 0
Output: 0 Explanation: Smallest number greater than 0 is 1, whose indices are 0 and 1. The index of the first occurrence is 0.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i] ≤ 106
0 ≤ x ≤ arr[n-1] */
package Patterns.BinarySearch;

public class P02_CeilINASortedArray {
    public static  int findCeil(int[] arr, int x){
        int low=0,high=arr.length-1,res=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=x){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return  res;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 8, 10, 11, 12, 19}; 
        int x = 5;
        int ans=findCeil(arr,x);
        int[] arr1={1, 2, 8, 10, 11, 12, 19}; 
        int x1 = 20;
        int ans1=findCeil(arr1,x1);
        int[] arr2={1, 1, 2, 8, 10, 11, 12, 19}; 
        int x2 = 0;
        int ans2=findCeil(arr2,x2);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }
    
}
// TC:O(logn)
// SC:O(1)