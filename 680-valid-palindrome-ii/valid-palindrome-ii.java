class Solution {
    private boolean isPalindrome(String  s ,int l,int r){
        while(l<r){
            if(s.charAt(l)==s.charAt(r)){
                l++;
                r--;
            }else return false;
        }return true;
    }
    public boolean validPalindrome(String s) {
        int n =s.length();
        int i=0;
        int count =0;
        int j= n-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
            
        }return true;
    }
}