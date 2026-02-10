class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue <>();
    int maxSize=0;
    public KthLargest(int k, int[] nums) {
        int n = nums.length;
        for(int i=0;i<n ;i++){
            minHeap.add(nums[i]);
            if(minHeap.size()>k)minHeap.poll();
        }maxSize=k;
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size()>maxSize)minHeap.poll();
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */