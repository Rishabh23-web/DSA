class Solution {
    public int slidingWin(int[] arr, int k){
        Map <Integer,Integer> map = new HashMap<>();
        int n= arr.length;
        int i=0;
        int j=0;

        int count=0;

        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>k){
                map.computeIfPresent(arr[i], (key, v) -> v > 1 ? v - 1 : null);
                i++;
            }
            count +=(j-i+1);
            j++;
        }return count;
    }
    public int subarraysWithKDistinct(int[] arr, int k) {
        return slidingWin(arr,k)-slidingWin(arr,k-1);
    }
}