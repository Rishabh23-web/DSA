class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        int n=arr.length;
        int result =0;
        int currSum =0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            currSum +=arr[i];

            if(map.containsKey(currSum-k))result +=map.get(currSum-k);
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }return result;
    }
}