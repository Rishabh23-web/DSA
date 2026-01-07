class Solution {

    public ArrayList<Integer> computeLPS(String pattern){
        int m= pattern.length();
        ArrayList <Integer> lps =new ArrayList<>();
        lps.addAll(Collections.nCopies(m, 0));
        int i=1;
        int len=0;

        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps.set(i,len) ;
                i++;
            }
            else{
                if(len!=0){
                    len= lps.get(len-1);
                }
                else{
                    lps.set(i,0);
                    i++;
                }
            }
        }
        return lps;
    }




    public int KMPSearch(String text, String pattern){
        int m=pattern.length();
        int n=text.length();
        ArrayList<Integer> lps =computeLPS(pattern);
        int i=0;
        int j=0;

        while(i<n){
            if(text.charAt(i) ==pattern.charAt(j)){
                i++;
                j++;
            }

            if(j==m){
                return i-j;
                }
            else if(i<n && text.charAt(i) != pattern.charAt(j)){
                if(j!=0){
                    j=lps.get(j-1);
                }
                else{
                    i++;
                }
            }
        }return -1;
    }


    public int repeatedStringMatch(String a, String b) {
        int m=a.length();
        int n=b.length();
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        
         while (sb.length() < n) {
            sb.append(a);
            count++;
        }
        if (KMPSearch(sb.toString(), b) != -1) {
            return count;
        }

        sb.append(a);
        if (KMPSearch(sb.toString(), b) != -1) {
            return count + 1;
        }
        return -1;
    }
}