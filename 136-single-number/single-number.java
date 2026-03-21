class Solution {
    public int singleNumber(int[] arr) {
        int n=arr.length;
        int result=0;
        if(n==1)return arr[0];
        for(int i=0;i<=31;i++){
            int temp = 1<<i;
            int ones=0;
           for(int k:arr){
            
            if((k & temp)==0){}
            else ones++;
           }
           if(ones%2==1)result |=temp;

        }return result;
    }
}