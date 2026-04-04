class LRUCache {


    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key,int val){
            this.key=key;
            this.val = val;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer,Node> map = new HashMap<>();
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        head.next= tail;
        tail.prev = head;
    }
    public void addFirst(Node node){
        Node temp = head.next;
        head.next =node;
        node.next=temp;
        node.prev = head;
        temp.prev = node;
    }
    public void delNode(Node delnode){
        delnode.prev.next=delnode.next;
        delnode.next.prev = delnode.prev;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int res = resNode.val;
            map.remove(key);
            delNode(resNode);
            addFirst(resNode);
            map.put(key,head.next);
            return res;
        }return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node existingNode = map.get(key);
            map.remove(key);
            delNode(existingNode);
        }
        if(map.size()==cap){
            map.remove(tail.prev.key);
            delNode(tail.prev);
        }
        addFirst(new Node(key,value));
        map.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */