class Solution {
    public int minDistance(String s1, String s2) {
        final int m=s1.length();
        final int n = s2.length();
        int [][] t = new int[m+1][n+1];
        for(int i=0;i<=m;i++)t[i][0]=i;
        for(int i=0;i<=n;i++)t[0][i]=i;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) t[i][j]=t[i-1][j-1];
                else{
                    t[i][j] =1+ Math.min(t[i-1][j-1],Math.min(t[i][j-1],t[i-1][j]));
                }
            }
        }return t[m][n];
    }
}