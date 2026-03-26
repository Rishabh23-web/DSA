class Solution {
    public int maxProduct(String[] arr) {
        int n = arr.length;
        
        int ans=0;
        int[] state = new int[n];
        for(int i=0;i<n;i++){
           for(int c=0;c<arr[i].length();c++){
            state[i] |= 1<<(arr[i].charAt(c)-'a');}
           for(int j=0;j<i;j++){
            if((state[i]&state[j])==0){
                if(arr[i].length()*arr[j].length()>ans)ans=arr[i].length()*arr[j].length();
            }

           }
        }return ans;
    }
}