class nodeVal {
    public int minNode, maxNode, sum; // Changed maxSize to sum
    nodeVal(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}

class Solution {
    private int maxBSTSum = 0; // Added global variable to track the result

    private nodeVal maxSumBSTHelper(TreeNode root) {
        if (root == null) return new nodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        nodeVal left = maxSumBSTHelper(root.left);
        nodeVal right = maxSumBSTHelper(root.right);

        // Check if current subtree is a valid BST
        if (left.maxNode < root.val && root.val < right.minNode) {
            int currentSum = root.val + left.sum + right.sum;
            maxBSTSum = Math.max(maxBSTSum, currentSum); // Update global max sum
            
            return new nodeVal(
                Math.min(root.val, left.minNode), 
                Math.max(root.val, right.maxNode), 
                currentSum
            );
        }

        // If not a BST, return values that force all ancestors to also be invalid
        // We return MIN_VALUE for minNode and MAX_VALUE for maxNode to break parent comparisons
        return new nodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public int maxSumBST(TreeNode root) {
        maxBSTSum = 0; // Reset for the test case
        maxSumBSTHelper(root);
        return maxBSTSum; // Return the global max found, not the root's value
    }
}