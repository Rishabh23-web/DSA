class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int n=x;
        int revnum=0;
        while(n>0){
            int dig = n%10;
            revnum = 10*revnum+dig;
            n = n/10; 
        }
        
        return (revnum == x);
    }
}