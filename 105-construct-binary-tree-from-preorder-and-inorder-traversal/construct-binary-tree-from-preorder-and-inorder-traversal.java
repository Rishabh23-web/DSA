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
    public TreeNode buildTree(int []preorder,int prest,int preend,int[] inorder,int inst,int inend,Map<Integer,Integer>inMap){
        if(prest>preend || inst>inend)return null;

        TreeNode root =new TreeNode(preorder[prest]);
        int inroot = inMap.get(root.val);
        int numsleft = inroot-inst;
        root.left = buildTree(preorder,prest+1,prest+numsleft,inorder,inst,inroot-1,inMap);
        root.right = buildTree(preorder,prest+numsleft+1,preend,inorder,inroot+1,inend,inMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map <Integer,Integer> inMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inMap);
        return root;
    }
}