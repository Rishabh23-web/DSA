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
    public int balFactor(TreeNode root){
        if(root==null)return 0;
        int leftht = balFactor(root.left);
        if(leftht==-1)return -1;
        int rightht =balFactor(root.right);
        
        if(rightht==-1)return -1;
        if(Math.abs(leftht-rightht)>1)return -1;
        return Math.max(leftht,rightht)+1;
    }
    
    public boolean isBalanced(TreeNode root) {
        return balFactor(root)!=-1;
    }
}