/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue <Node> q= new LinkedList<>();
        if (root==null || root.left==null)return root;
        q.offer(root);
        q.offer(null);
        Node prev =null;
        while(!q.isEmpty()){
            Node curr =q.peek();
            q.poll();
            if(curr==null){
                if(q.size()==0)break;
                q.offer(null);
            }else{
                if(curr.left !=null){
                    q.offer(curr.left);
                }

                if(curr.right !=null){
                    q.offer(curr.right);
                }
                if(prev!=null){
                    prev.next=curr;
                }
            }prev =curr;
        }return root;
    }
}