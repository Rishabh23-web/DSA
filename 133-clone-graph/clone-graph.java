/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void DFS(Node node,Node clone,HashMap<Node,Node> mp ){
        for(Node n : node.neighbors){
            if(!mp.containsKey(n)){
                Node cloneNode = new Node(n.val);
                mp.put(n,cloneNode);
                clone.neighbors.add(cloneNode);
                DFS(n,cloneNode,mp);
            }
            else{
                clone.neighbors.add(mp.get(n));
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node,Node> mp = new HashMap<>();
        Node clone = new Node(node.val);
        mp.put(node,clone);
        DFS(node,clone,mp);
        return clone;
    }
}