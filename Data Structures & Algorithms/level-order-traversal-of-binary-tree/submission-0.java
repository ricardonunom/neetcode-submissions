/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private List<List<Integer>> order = new ArrayList<>();
    private int level = 0;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
       dfs(root);
       return order;
    }

    private void dfs(TreeNode root){
        if(root == null) return;

        if(order.size() == level) order.add(new ArrayList<>());

        order.get(level).add(root.val);

        level++;
        dfs(root.left);
        dfs(root.right);
        level--;
    }
}
