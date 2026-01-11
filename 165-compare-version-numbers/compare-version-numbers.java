class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0;
        int j=0;
        
        String v1[] =version1.split("\\.");
        String v2[] =version2.split("\\.");
        int m=v1.length;
        int n=v2.length;
        while(i<v1.length || i<v2.length){
            int a = i<m?Integer.valueOf(v1[i]):0;
            int b =i<n?Integer.valueOf(v2[i]):0;
            if(a<b)return -1;
            if(a>b)return 1;
            i++;
        }
        return 0;
    }
}