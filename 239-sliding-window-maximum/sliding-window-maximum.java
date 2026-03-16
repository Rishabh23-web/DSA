class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        Deque <Integer> dq = new LinkedList<>();
        int n =arr.length;
        List <Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.pollLast();

            }
            dq.offerLast(i);

            if(i>=k-1){ans.add(arr[dq.peekFirst()]);}
        }
        int[] answer = new int[ans.size()];
        for(int z=0;z<ans.size();z++){
            answer[z]= ans.get(z);
        }
        return answer;
    }
}