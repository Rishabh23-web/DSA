class Solution {
    public void reverse(int st, int end , int[] arr){
        while(st<end){
        int temp = arr[st];
        arr[st]=arr[end];
        arr[end]=temp;
        st++;
        end--;
        }
    }
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) return ;
        k = k % n;
        reverse(0,n-1,arr);
        reverse(0,k-1,arr);
        reverse(k,n-1,arr);
    }
}