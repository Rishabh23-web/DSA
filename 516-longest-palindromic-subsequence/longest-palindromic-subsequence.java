class Solution {
    public int helper(int[][] t,int m,int n,String s,String r){
        if(n==0 || m==0)return 0;
        if(t[m][n] !=-1)return t[m][n];
        if(s.charAt(m-1)==r.charAt(n-1)){
            t[m][n] = 1+ helper(t,m-1,n-1,s,r);
        }else{
            t[m][n] = Math.max(helper(t,m,n-1,s,r),helper(t,m-1,n,s,r));
            }
            return t[m][n];
        }
    public int longestPalindromeSubseq(String s) {
        int n= s.length();
        int [][] t=new int[n+1][n+1];
        for(int[] i:t){
            Arrays.fill(i,-1);
        }
        StringBuilder sb = new StringBuilder(s);
        return helper(t,n,n,s,sb.reverse().toString());
    }
}