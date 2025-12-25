class LRUCache {

    class Node{
        int key,val;
        Node next;
        Node prev;
        Node(int _key,int _val){
            key = _key;
            val = _val;
        }
    }
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    Map<Integer,Node> map= new HashMap<>();
    int cap;
    public LRUCache(int capacity) {
        cap = capacity ;
        head.next=tail;
        tail.prev=head;
    }
    
    void addFirst(Node newNode){
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next =temp;
        temp.prev= newNode;
    }

    void delNode(Node delNode){
        delNode.prev.next = delNode.next;
        delNode.next.prev = delNode.prev;
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
        } 
        return -1;
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