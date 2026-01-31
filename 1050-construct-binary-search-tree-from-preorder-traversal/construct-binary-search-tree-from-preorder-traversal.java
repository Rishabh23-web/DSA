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
    public TreeNode buildbst(int bound,int[] i,int[] preorder){
        if(i[0]==preorder.length || preorder[i[0]]>bound)return null;
        TreeNode node = new TreeNode(preorder[i[0]++]);
        node.left=buildbst(node.val,i,preorder);
        node.right=buildbst(bound,i,preorder);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildbst(Integer.MAX_VALUE,new int[]{0},preorder);
    }
}