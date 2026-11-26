/*107. Binary Tree Level Order Traversal II
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. 
(i.e., from left to right, level by level from leaf to root).
Example 1:Input: root = [3,9,20,null,null,15,7]  ,  Output: [[15,7],[9,20],[3]]
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000*/
package Tree.Traversal;
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
public class P06_BinaryTreeLevelOrderTraversalII {
     public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> temp=new ArrayList<>();
            while (levelsize-->0) {
                TreeNode t=q.poll();
                temp.add(t.val);

                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
     }
    public static void main(String[] args) {
        TreeNode root =new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.left.left=null;
        root.left.right=null;
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> result = levelOrderBottom(root);

        System.out.println(result);
    }
}
// Time Complexity: O(n) – Each node is visited exactly once, and reversing the result list takes O(h) time, where h is the number of levels. Overall, the complexity is O(n).
// Space Complexity: O(n) – The queue and result list require O(n) space in the worst case.