class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n){ 
        int l= m-1;
        int r=n-1;
        int k=m+n-1;
        while(r>=0){
            if(l>=0 && arr1[l]>arr2[r])arr1[k--]=arr1[l--];
            else arr1[k--]= arr2[r--];
        }
    }
}