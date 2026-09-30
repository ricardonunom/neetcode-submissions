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
    private List<Integer> sideView = new ArrayList<>();
    private int level = -1;

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return sideView;
        
        level++;
        if(sideView.size() <= level) sideView.add(root.val);
        rightSideView(root.left);
        rightSideView(root.right);
        sideView.set(level, root.val);
        level--;
        
        return sideView;
    }
}
