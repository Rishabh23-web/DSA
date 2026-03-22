class Solution {
    public int singleNumber(int[] arr) {
        int n=arr.length;
        int result=0;
        for(int i=0;i<32;i++){
            int temp= 1<<i;
            int ones=0;
            for(int j:arr){
                if((j&temp)==0){}
                else ones++;
            }
            if(ones%3==1) result|= temp;
        }return result;
    }
}