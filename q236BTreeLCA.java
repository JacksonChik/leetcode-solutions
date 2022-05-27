/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){ 
            if(haveNode(root.left, p) && haveNode(root.left, q)) root = root.left;
            else if(haveNode(root.right,p) && haveNode(root.right, q)) root = root.right;
            else break;
        }
        return root;

    }
    
    public boolean haveNode(TreeNode root, TreeNode target){
        if(root == target) return true;
        if(root == null) return false;
        return haveNode(root.left, target) || haveNode(root.right, target); 
    }
}