class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1)return 0;
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0]=false;
        arr[1]=false;
        for(int i=2; i*i<=n;i++){
            if(arr[i]==true){
                for(int j=2; i*j<=n;j++)arr[i*j]=false;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==true)count++;
        }return count;
    }
}