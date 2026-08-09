/*11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn 
such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container
contains the most water. Return the maximum amount of water a container can store.
Notice that you may not slant the container.
Example 1: Input: height = [1,8,6,2,5,4,8,3,7]  ,  Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
Constraints: n == height.length
2 <= n <= 105
0 <= height[i] <= 104 */
package Patterns.TwoPointer;
public class P17_ContainerWithMostWater {
    public static int maxArea(int[] height){

        int start=0, end=height.length-1 , maxwater=0;

        while(start<end){
            
            int base=end-start;
            int ht=Math.min(height[start], height[end]);
            int area=base*ht;
            maxwater=Math.max(area, maxwater);

            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxwater;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int ans=maxArea(height);
        System.out.println(ans);
    }
}
//T.C=O(n)
//S.C=O(1)