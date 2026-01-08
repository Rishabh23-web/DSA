class Solution {

    public boolean compare(String s1,String s2,int idx){
        int n1= s1.length();
        int n2 = s2.length();
        for(int i=0; i<n2;i++){
            if(idx>=n1) return false;
            if(s1.charAt(idx++) !=s2.charAt(i))return false;
        }
        return true;
    }
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();

        for(int i=0;i<n1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(compare(haystack,needle,i)==true)return i;
            }
        }return -1;
    }
}