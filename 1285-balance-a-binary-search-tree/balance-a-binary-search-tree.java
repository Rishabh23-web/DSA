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
    public void inorder(TreeNode node,List<Integer>ans){
        if(node==null)return;
        inorder(node.left,ans);
        ans.add(node.val);
        inorder(node.right,ans);

    }
    public TreeNode construct(int stind,int endind,List <Integer> nums){
        if(stind>endind)return null;
        int mid = (stind-endind)/2 +endind;
        TreeNode root =new TreeNode(nums.get(mid));
        root.left=construct(stind,mid-1,nums);
        root.right=construct(mid+1,endind,nums);
        return root;

    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)return root;
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return construct(0,ans.size()-1,ans);
    }
}