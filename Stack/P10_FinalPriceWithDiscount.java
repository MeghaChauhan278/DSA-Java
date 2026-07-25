/*1475. Final Prices With a Special Discount in a Shop
You are given an integer array prices where prices[i] is the price of the ith item in a shop.
There is a special discount for items in the shop. If you buy the ith item, then you will
receive a discount equivalent to prices[j] where j is the minimum index such that j > i and 
prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
Return an integer array answer where answer[i] is the final price you will pay for the ith 
item of the shop, considering the special discount.
Example 1: Input: prices = [8,4,6,2,3] ,Output: [4,2,4,2,3]
Constraints: 1 <= prices.length <= 500 , 1 <= prices[i] <= 1000*/
import java.util.*;
public class P10_FinalPriceWithDiscount{
    public static int[] finalPrices(int[] prices){
        int n=prices.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>prices[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=prices[i];
            }else{
                ans[i]=prices[i]-st.peek();
            }
            st.push(prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices={8,4,6,2,3};
        int[] res=finalPrices(prices);
        System.out.println(Arrays.toString(res));
    }
}
//T.C,S.C=O(n)