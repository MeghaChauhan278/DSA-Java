/*2215. Find the Difference of Two Arrays
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
Example 1: Input: nums1 = [1,2,3], nums2 = [2,4,6]  ,  Output: [[1,3],[4,6]]
Example 2: Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]  ,  Output: [[3],[]]
Constraints:
1 <= nums1.length, nums2.length <= 1000
-1000 <= nums1[i], nums2[i] <= 1000 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P09_DifferenceOfTwoArrays {
    public static List<List<Integer>>findDifference(int[] nums1, int[] nums2){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int x:nums1){
            set1.add(x);
        }
        for(int x:nums2){
            set2.add(x);
        }
        for(int x:set1){
            if(!set2.contains(x)){
                list1.add(x);
            }
        }
        for(int x:set2){
            if(!set1.contains(x)){
                list2.add(x);
            }
        }
        res.add(list1);
        res.add(list2);
        return res;
    }
    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={2,4,6};
        List<List<Integer>> ans=findDifference(nums1,nums2);
        System.out.println(ans);
    }
}
// Time: O(n+m) in the avg case
// Space: O(n + m)