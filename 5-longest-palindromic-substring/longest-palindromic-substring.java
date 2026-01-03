class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<=1) return s;

        String LPS = "";
        for(int i=1; i< n ;i++){
            int low =i;
            int high = i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low ==-1 || high ==n) break;
            }
            String pallindrome = s.substring(low+1,high);
            if(pallindrome.length() > LPS.length()) LPS=pallindrome;

            low= i-1;
            high =i;
            while(s.charAt(low)== s.charAt(high)){
                low--;
                high++;

                if(low ==-1 || high ==n)break;
            }
            pallindrome = s.substring(low+1,high);
            if(pallindrome.length() >LPS.length()) LPS=pallindrome;
        }
        return LPS;
    }
}