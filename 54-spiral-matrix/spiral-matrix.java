class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        
        int rowmax =arr.length-1;
        int colmax = arr[0].length-1;
        List <Integer> ans = new ArrayList<>();
        int row=0,col=0;
        while(row<=rowmax && col<=colmax){
            for(int j=col;j<=colmax;j++){
                ans.add(arr[row][j]);
            }row++;
            for(int i=row; i<=rowmax;i++){
                ans.add(arr[i][colmax]);
            }colmax--;
            if(row<=rowmax){for(int j =colmax;j>=col;j--){
                ans.add(arr[rowmax][j]);
            }rowmax--;}
            
            if(col<=colmax){for(int i=rowmax;i>=row;i--){
                ans.add(arr[i][col]);
            }col++;}
        }return ans;

    }
}