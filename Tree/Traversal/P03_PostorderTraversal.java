/* 145. Binary Tree Postorder Traversal
Given the root of a binary tree, return the postorder traversal of its nodes' values.
Example 1: Input: root = [1,null,2,3]  ,  Output: [3,2,1]
Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100 */
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
public class P03_PostorderTraversal {
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    static void postorder(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        List<Integer> result = postorderTraversal(root);

        System.out.println(result);
    }
}
// TC,SC:(n)