class Solution {

    public int solve(int grid[][],int i,int j,int[][]t){
        if(i>=grid.length || j>=grid[0].length)return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1)return grid[i][j];
        if(t[i][j]!=-1){
            return t[i][j];
        }
        t[i][j]= grid[i][j]+Math.min(solve(grid,i+1,j,t),solve(grid,i,j+1,t));
        return t[i][j];

    }

    public int minPathSum(int[][] grid) {
        int t[][] =new int[201][201];
        for(int[] row: t) Arrays.fill(row,-1);
        return solve(grid,0,0,t);
    }
}