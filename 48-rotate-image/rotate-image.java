class Solution {
public static void swap(int[][] arr,int a,int b,int i ,int j){
    int temp =arr[a][b];
    arr[a][b]=arr[i][j];
    arr[i][j]=temp;
}
public static void rotate(int[][] arr) {
    int n = arr.length;

    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            swap(arr,i,j,j,i);
            }
        }


    for(int i=0;i<n;i++){
        for(int j=0;j<n/2;j++){
            swap(arr,i,j,i,n-j-1);
            }
        }
    }
}