class Solution {
    public int[] decode(int[] arr) {
        int totalXOR =0;
        int n= arr.length+1;
        for(int i=1;i<=n;i++)totalXOR ^=i;
        int x=0;
        for(int i=1;i<n-1;i+=2) x ^=arr[i];

        int f=x^totalXOR;
        int[] ans=new int[n];
        ans[0]=f;
        for(int i=0;i<n-1;i++)ans[i+1]=ans[i]^arr[i];
        return ans;
    }
}