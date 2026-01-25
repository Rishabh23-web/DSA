import java.util.HashMap;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        
        // Map to store value -> index for O(1) lookup in inorder array
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return build(postorder, 0, postorder.length - 1, 
                     inorder, 0, inorder.length - 1, 
                     inMap);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd, 
                           int[] inorder, int inStart, int inEnd, 
                           HashMap<Integer, Integer> inMap) {
        
        // Base case: If the range is invalid, return null
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        // 1. The root of the current (sub)tree is the LAST element in postorder
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // 2. Find where this root is in the inorder array
        int inRootIdx = inMap.get(root.val);
        
        // 3. Calculate how many nodes are in the left subtree
        int numsLeft = inRootIdx - inStart;

        // 4. Recursive calls
        // Left Subtree: 
        // Inorder: From inStart to inRootIdx - 1
        // Postorder: From postStart to (postStart + numsLeft - 1)
        root.left = build(postorder, postStart, postStart + numsLeft - 1, 
                          inorder, inStart, inRootIdx - 1, 
                          inMap);

        // Right Subtree:
        // Inorder: From inRootIdx + 1 to inEnd
        // Postorder: From (postStart + numsLeft) to postEnd - 1
        root.right = build(postorder, postStart + numsLeft, postEnd - 1, 
                           inorder, inRootIdx + 1, inEnd, 
                           inMap);

        return root;
    }
}