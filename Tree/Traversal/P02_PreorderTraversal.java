/*144. Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.
Example 1: Input: root = [1,null,2,3]  ,  Output: [1,2,3]
Example 2: Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]  ,  Output: [1,2,4,5,6,7,3,8,9]
Example 3: Input: root = []  ,  Output: []
Constraints:
The number of nodes in the tree is in the range [0, 100].
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
public class P02_PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ans =new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
    static void preorder(TreeNode root,List<Integer> ans){
        if(root==null){
            return ;
        }
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=null;
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);

        List<Integer> result = preorderTraversal(root);

        System.out.println(result);
    }
}
// TC,SC:O(n)