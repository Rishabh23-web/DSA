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

    public TreeNode construct(int sti,int endi,int[] nums){
        if(sti>endi)return null;
        int mid = (sti-endi)/2+endi;  
        TreeNode root =new TreeNode(nums[mid]);
        root.left=construct(sti,mid-1,nums);
        root.right=construct(mid+1,endi,nums);
        return root;
}

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return construct(0,nums.length-1,nums);
    }

}