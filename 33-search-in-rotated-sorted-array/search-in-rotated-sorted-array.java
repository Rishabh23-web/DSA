class Solution {
    public int bisrch(int[] arr,int low,int high,int k){
        while(low<=high){
            int mid =low+(high-low)/2;
            if(arr[mid]==k)return mid;
            if(arr[mid]<k) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    public int search(int[] arr, int k) {
        int n= arr.length;
        int index=-1;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1)return bisrch(arr,0,n-1,k);
        if(arr[index]==k)return index;
        if(k>=arr[0]){
            return bisrch(arr,0,index,k);
        }
        if(k<arr[0]) return bisrch(arr,index+1,n-1,k);
        return -1;
    }
}