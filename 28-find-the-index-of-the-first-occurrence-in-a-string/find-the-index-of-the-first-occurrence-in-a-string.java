class Solution {
    public int strStr(String s1, String s2) {
        int m= s1.length();
        int n =s2.length();
        for(int i =0;i<=m-n;i++){
            for(int j=0;j<n;j++){
                if(s1.charAt(i+j)!=s2.charAt(j))break;
                if(j==n-1)return i;
            }
        }return -1;
    }
}