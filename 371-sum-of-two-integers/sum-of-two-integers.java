class Solution {
    public int getSum(int a, int b) {
        int result=0;
        
        while(b!=0){
            int c=a&b;
            a=a^b;
            b=c<<1;
            }return a;
        }
    }
