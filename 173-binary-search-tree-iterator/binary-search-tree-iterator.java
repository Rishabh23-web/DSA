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
class BSTIterator {
    List<Integer> bstList;
    TreeNode root;
    int currind;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.bstList = new ArrayList<>();
        this.currind =0;
        this.inorder(root,this.bstList);
    }
    
    public int next() {
        return bstList.get(currind++);
        
    }
    public void inorder(TreeNode root, List<Integer> bstList){
        if(root==null)return;
        inorder(root.left,bstList);
        bstList.add(root.val);
        inorder(root.right,bstList);
    }
    
    public boolean hasNext() {
        return currind<bstList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */