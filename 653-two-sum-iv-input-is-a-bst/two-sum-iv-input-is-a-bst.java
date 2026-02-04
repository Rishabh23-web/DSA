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
    public void inorder(TreeNode root,List<Integer> inorder){
            if(root==null)return;
            inorder(root.left,inorder);
            inorder.add(root.val);
            inorder(root.right,inorder);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder =new ArrayList<>();
        inorder(root,inorder);
        int i=0;
        int j=inorder.size()-1;
        while(i<j){
            if(inorder.get(i)+inorder.get(j)==k)return true;
            if(inorder.get(i)+inorder.get(j)<k)i++;
            else j--;    
        }return false;
    }
}