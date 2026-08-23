/*881. Boats to Save People
You are given an array people where people[i] is the weight of the ith person, and an infinite 
number of boats where each boat can carry a maximum weight of limit. Each boat carries at most 
two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.
Example 1: Input: people = [1,2], limit = 3     ,      Output: 1
Explanation: 1 boat (1, 2)
Example 2: Input: people = [3,2,2,1], limit = 3
Output: 3       Explanation: 3 boats (1, 2), (2) and (3)
Constraints:
1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104 */

package Patterns.TwoPointer;
import java.util.Arrays;
public class P19_BoatstoSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0,j=people.length-1,count=0;
        while(i<=j){
            int sum=people[i]+people[j];
            if(sum<=limit){
                i++;
                j--;
            }else{
                j--;
            }
            count++;
        }
        return count;//Because every iteration puts at least one person into a boat.
    }
    public static void main(String[] args) {
        int[] people = {1,2};
        int limit = 3;
        int ans=numRescueBoats(people,limit);
        System.out.println(ans);
        int[] people1 = {3,2,2,1};
        int limit1 = 3;
        int ans1=numRescueBoats(people1,limit1);
        System.out.println(ans1);
    }
}
