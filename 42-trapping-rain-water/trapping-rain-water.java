class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        if(n==1)return 0;
        
        int lmax=0;
        int rmax=0;
        int r =n-1;
        int l=0;
        int trappedWater =0;
        while(l<r){
            if(arr[l]<arr[r]){
                if(lmax<arr[l])lmax=arr[l];
                else{
                    trappedWater+=(lmax-arr[l]);
                }
                l++;
            }
            else{
                if(rmax<arr[r])rmax=arr[r];
                else{
                    trappedWater+=(rmax-arr[r]);
                }r--;
            }
        }return trappedWater;
    }
}