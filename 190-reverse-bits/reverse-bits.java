class Solution {
    public int reverseBits(int n) {
        if(n==0)return 0;
        int reverse =0;
        for(int i=31;i>=0;i--){
            reverse = reverse<<1;
            reverse = reverse|(n&1);
            n=n>>1;
        }

        return reverse;
    }

}