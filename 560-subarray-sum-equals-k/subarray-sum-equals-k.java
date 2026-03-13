class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        int n=arr.length;
        int result =0;
        int curSum =0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            curSum +=arr[i];
        
        if(map.containsKey(curSum-k))result +=map.get(curSum-k);
        map.put(curSum,map.getOrDefault(curSum, 0) + 1);
        }return result;
    }
}