/*102. Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. 
(i.e., from left to right, level by level).
Example 1: Input: root = [3,9,20,null,null,15,7]  ,  Output: [[3],[9,20],[15,7]]
Example 2: Input: root = [1]  ,  Output: [[1]]
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000 */
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
public class P04_BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> temp=new ArrayList<>();
            while(levelsize-->0){
                TreeNode t=q.poll();
                temp.add(t.val);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root =new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.left.left=null;
        root.left.right=null;
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        List<List<Integer>> result = levelOrder(root);

        System.out.println(result);

    }
}
// - Time Complexity (TC): O(N) — Every node is visited and processed exactly once.
// - Space Complexity (SC): O(N) — Queue can store up to O(N) nodes in the widest level.
// N = Total number of nodes in the binary tree.