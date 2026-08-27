/*1598. Crawler Log Folder
The Leetcode file system keeps a log each time some user performs a change folder operation.
The operations are described below:
-> "../" : Move to the parent folder of the current folder. (If you are already in the main folder, 
remain in the same folder).
-> "./" : Remain in the same folder.
-> "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.
The file system starts in the main folder, then the operations in logs are performed.
Return the minimum number of operations needed to go back to the main folder after the change folder operations.
Example 1: Input: logs = ["d1/","d2/","../","d21/","./"]  ,   Output: 2
Explanation: Use this change folder operation "../" 2 times and go back to the main folder.
Example 2:  Input: logs = ["d1/","../","../","../"]  ,  Output: 0
Constraints:
1 <= logs.length <= 103
2 <= logs[i].length <= 10
logs[i] contains lowercase English letters, digits, '.', and '/'.
logs[i] follows the format described in the statement.
Folder names consist of lowercase English letters and digits. */

import java.util.Stack;

public class P17_CrawlerLogFolder {
     public static int minOperations(String[] logs) {
        Stack<String> st=new Stack<>();
        for(String log:logs){
            if(log.equals("../")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(log.equals("./")){
                continue;
            }else{
                st.push(log);
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(minOperations(logs));
        String[] logs1 = {"d1/","../","../","../"};
        System.out.println(minOperations(logs1));
    }
}
// TC:O(n)
// SC:O(n)


/*sc:O(n)
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            }
            else if (log.equals("./")) {
                continue;
            }
            else {
                depth++;
            }
        }
        return depth;
    */
