class Solution {
    public String minWindow(String s, String t) {

        int n =s.length();

        if(t.length()>n)return "";

        Map<Character,Integer> map = new HashMap<>();

        for(char ch:t.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        int reqCount = t.length();
        int i=0,j=0;

        int minWinSize = Integer.MAX_VALUE ;
        int st_i =0;

        while(j<n){
            char ch = s.charAt(j);

            if(map.containsKey(ch) && map.get(ch)>0)reqCount--;

            map.put(ch,map.getOrDefault(ch,0)-1);

            while(reqCount==0){

                int currWinSize = j-i+1;

                if(currWinSize< minWinSize){
                    minWinSize=currWinSize;
                    st_i = i;
                }

                char startChar= s.charAt(i);
                map.put(startChar,map.getOrDefault(startChar,0)+1);

                if(map.containsKey(startChar) && map.get(startChar)>0)reqCount++;
                i++;
            }
            j++;
        }
        return minWinSize==Integer.MAX_VALUE?"":s.substring(st_i,st_i+minWinSize);

    }
}