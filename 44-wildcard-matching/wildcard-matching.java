class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int i=0;
        int j=0;
        int match =0;
        int starId =-1;
        while(i<n){

            if(j<m && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='?') ){
                i++;
                j++;
                }
            else if(j<m && p.charAt(j)=='*'){
                starId =j;
                match =i;
                j++;
            }
            else if(starId!=-1){
                j = starId+1;
                match++;
                i=match;
            }else{
                return false;
            }
        }
        while(j<m && p.charAt(j)=='*')j++;
        return j==m;
        
    }
}