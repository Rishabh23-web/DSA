class Solution {
    public void setZeroes(int[][] arr) {
        int n = arr.length ;
        int m= arr[0].length;
        boolean firstRowImpacted = false;
        boolean firstColImpacted = false;
        
        for(int j=0;j<m;j++){
            if(arr[0][j]==0){
                firstRowImpacted = true;
                break;
            } 
        }

        for(int i=0;i<n;i++){
            if(arr[i][0]==0){
                firstColImpacted = true;
                break;
            } 
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][j]==0){
                    arr[i][0]=0;
                    arr[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i][0]==0 || arr[0][j]==0){
                        arr[i][j]=0;
                }
            }
        }

        if(firstRowImpacted){
            for(int j=0;j<m;j++){
                arr[0][j]=0;
            }
        }

        if(firstColImpacted){
            for(int j=0 ; j<n;j++){
                arr[j][0]=0;
            }
        }
    }
}