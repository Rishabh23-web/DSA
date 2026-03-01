class Solution {
    public int maxProfit(int[] arr) {
        int n =arr.length;
        int profit =0;
        int min = arr[0];
        for(int i=1;i<n;i++){
            int cost = arr[i]-min;
            profit = Math.max(profit,cost);
            min = Math.min(min,arr[i]);
        }return profit;
    }
}