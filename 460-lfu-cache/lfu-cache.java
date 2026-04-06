class LFUCache {

    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        int frequency;
        public Node(int k,int v){
            this.key=k;
            this.val=v;
            this.frequency=1;
        }
    }
    class DoubleLinkedList{
        int listSize;
        Node head;
        Node tail;
        public DoubleLinkedList(){
            this.listSize=0;
            this.head=new Node(0,0);
            this.tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }
        public void addNode(Node currNode){
            Node nextNode = head.next;
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            listSize++;
        }
        public void removeNode(Node currNode){
            Node nextNode = currNode.next;
            Node prevNode = currNode.prev;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }
    Map <Integer,DoubleLinkedList> freqMap;
    Map <Integer,Node> cache ;
    final int capacity;
    int minfreq;
    int currSize;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.currSize=0;
        this.minfreq =0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node currNode = cache.get(key);
        if(currNode==null)return -1;
        updateNode(currNode);
        return currNode.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0)return;
        if(cache.containsKey(key)){
            Node currNode=cache.get(key);
            currNode.val = value;
            updateNode(currNode);
        }else{
            currSize++;
            if(currSize>capacity){
                DoubleLinkedList minFreqList=freqMap.get(minfreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }minfreq=1;
            Node newNode =new Node(key,value);

            DoubleLinkedList currList =freqMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            freqMap.put(1,currList);
            cache.put(key,newNode);
        }
    }
    public void updateNode(Node currNode){
        int currFreq = currNode.frequency;
        DoubleLinkedList currList= freqMap.get(currFreq);
        currList.removeNode(currNode);
        if(currFreq==minfreq && currList.listSize==0)minfreq++;
        currNode.frequency++;
        DoubleLinkedList newList = freqMap.getOrDefault(currNode.frequency,new DoubleLinkedList());
        newList.addNode(currNode);
        freqMap.put(currNode.frequency,newList);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */