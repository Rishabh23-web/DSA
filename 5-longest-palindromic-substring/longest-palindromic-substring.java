class Solution {
    private int [][]t;
    public boolean solve(String s,int i,int j){
        if(i>=j)return true;
        if(t[i][j]!=-1)return t[i][j]==1;
        if(s.charAt(i)== s.charAt(j))t[i][j]= solve(s,i+1,j-1)?1:0;
        else t[i][j]=0;
        return t[i][j]==1;
    }

    public String longestPalindrome(String s) {
        int n =s.length();
        int maxLen = Integer.MIN_VALUE;
        int sp=0;
        t = new int [n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(t[i], -1);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j) == true){
                    if(j-i+1>maxLen){
                        maxLen =j-i+1;
                        sp=i;
                    }
                }
            }
        }return s.substring(sp,sp+maxLen);
    }
}