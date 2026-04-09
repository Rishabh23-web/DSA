class Solution {
    
    public int reverse(int x) {
        int t =x;
        double revNum=0;
            while(t!=0){
                double dig = t%10;
                revNum = (10*revNum) + dig;
                if(revNum>=Integer.MAX_VALUE||revNum<=Integer.MIN_VALUE)return 0;
                t /=10;
            }
            
            return (int)revNum;
        
    }
}