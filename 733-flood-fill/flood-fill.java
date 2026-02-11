class Solution {

    private void dfs(int row,int col ,int[][]ans,int[][] image,int newColor,int[]drow ,int[]dcol,int iniColor){

        ans[row][col]=newColor;
        int n= image.length;
        int m= image[0].length;

        for(int i=0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow<n && ncol>=0 && ncol <m && image[nrow][ncol] == iniColor && ans[nrow][ncol] !=newColor)
            dfs(nrow,ncol,ans,image,newColor,drow,dcol,iniColor);
        }
    }



    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int ans[][] = image;
        int [] drow={-1,0,1,0};
        int [] dcol={0,1,0,-1};
        dfs(sr,sc,ans,image,color,drow,dcol,iniColor);
        return ans;
        }
    
}