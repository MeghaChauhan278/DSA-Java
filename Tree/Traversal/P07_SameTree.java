/*100. Same Tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
Example 1: Input: p = [1,2,3], q = [1,2,3]  ,  Output: true
Example 2:
Constraints:
The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104 */
package Tree.Traversal;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
    }
}
public class P07_SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        root1.left=new TreeNode(2);
        root1.right=new TreeNode(3);
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(2);
        root2.right=new TreeNode(3);
        boolean res=isSameTree(root1,root2);
        System.out.println(res);
    }
}
// TC: O(n)
// SC: O(h), worst case O(n)