class Solution {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
    public void moveZeroes(int[] arr) {
        int i=0;
        int n=arr.length;
        for(int j=i+1;j<n;j++){
            if(arr[i]!=0)i++;
            if(arr[i]==0 && arr[j]!=0){
                swap(arr,i,j);
                i+=1;
            }
        }
    }
}