class Solution {
    public int maxArea(int[] arr) {

        int i=0;
        int j= arr.length-1;
        int max=0;        
        int min=Math.min(arr[i],arr[j]);
        while(i<j){
            if((j-i)*min>max)
            {
                max=(j-i)*min;
            }
            if(arr[i]<arr[j]){
                i++;

            }else{
                j--;
            }
            min=Math.min(arr[i],arr[j]);
                
        }return max;
    }
}