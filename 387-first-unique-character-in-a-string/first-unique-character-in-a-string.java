class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap <Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int j=0;
        while(j<n){
            if(map.get(s.charAt(j))==1)return j;
            j++;
        }
        return -1;
    }
}