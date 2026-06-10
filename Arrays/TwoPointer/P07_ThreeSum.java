package Arrays.TwoPointer;
import java.util.*;
public class P07_ThreeSum {
    public static void main(String[] args) {
        int[] a={-1,0,1,2,-1,-4};
        Arrays.sort(a);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(i>0 && a[i]==a[i-1]){
                continue;
            }
            int start=i+1;
            int end=a.length-1;
            int target=-a[i];

            while(start<end){
                int sum=a[start]+a[end];
                if(sum==target){
                    result.add(Arrays.asList(a[i],a[start],a[end]));
                    start++;
                    end--;

                    while(start<a.length && a[start]==a[start-1]){
                        start++;
                    }
                    while (start<end && a[end] == a[end+1]){
                        end--;
                    }
                }
                else if(sum<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(result);
    }
}
