class Solution {
    public int findLCS(int t[][],int m, int n,String w1,String w2){
        for(int i=0;i<=m;i++)t[i][0]=i;
        for(int j=0;j<=n;j++)t[0][j]=j;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){

                if(w1.charAt(i-1)==w2.charAt(j-1))t[i][j]= t[i-1][j-1];
                else t[i][j] = 1 + Math.min(t[i - 1][j - 1], // Replace
                                  Math.min(t[i - 1][j],    // Delete
                                           t[i][j - 1]));
            }
        }return t[m][n];
    }
    public int minDistance(String word1, String word2) {
        int m =word1.length();
        int n =word2.length();
        int t[][]=new int[m+1][n+1];
        int lcs = findLCS(t,m,n,word1,word2);
        return lcs;

        
    }
}