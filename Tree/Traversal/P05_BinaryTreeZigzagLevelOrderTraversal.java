/*103. Binary Tree Zigzag Level Order Traversal
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
(i.e., from left to right, then right to left for the next level and alternate between).
Example 1: Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Constraints:
The number of nodes in the tree is in the range [0, 2000].
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
public class P05_BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return res;
        }
        q.add(root);
        boolean LeftToRight=true;
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
            if(!LeftToRight){
                Collections.reverse(temp);
            }
            res.add(temp);
            LeftToRight=!LeftToRight;
        }
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
        List<List<Integer>> result = zigzagLevelOrder(root);

        System.out.println(result);
    }
}
// Time Complexity: O(n) – Each node is visited exactly once, and reversing the level lists takes O(n) time in total.
// Space Complexity: O(n) – The queue and result list can each require O(n) space in the worst case.