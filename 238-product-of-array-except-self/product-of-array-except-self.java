class Solution {
    public int[] productExceptSelf(int[] arr) {
        List <Integer> ans = new ArrayList<>();
        int n= arr.length;
        int prod=1;
        int zeroCount =0;
        boolean zero=false;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                zero= true;
                zeroCount++;
            }else {
                prod *= arr[i];
            }
        }
        if(zeroCount>1){prod=0;}
        for(int i=0;i<n;i++){
            if(zero==true && arr[i]!=0){
                ans.add(0);
            }else if(zero==true && arr[i]==0){
                ans.add(prod);
            }
            else{
                ans.add(prod/arr[i]);
            }
        }
        int[] answer= new int[ans.size()];
        for(int i=0;i<n;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}