/* Question: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects 
of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]                     in actual ques we dont have to return anything*/

import java.util.Arrays;

public class P10_SortColor {
    public static void main(String[] args) {
        int[] a={2,0,2,1,1,0};
        int low=0,mid=0,high=a.length-1;

        while(mid<high){
            if(a[mid]==0){
                int temp=a[mid];
                a[mid]=a[low];
                a[low]=temp;
                low++;
                mid++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else{
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;

            }
        }
        System.out.println(Arrays.toString(a));
    }
}
