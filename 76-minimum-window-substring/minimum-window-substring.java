class Solution {
    public String minWindow(String s, String t) {

        if(t.length()>s.length())return "";
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int reqCount = t.length();
        int i=0,j=0;
        int minWinSize = Integer.MAX_VALUE ;
        int st_i =0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)&& map.get(ch)>0)reqCount--;
            map.put(ch,map.getOrDefault(ch,0)-1);
            while(reqCount==0){
                int currWinSize = j-i+1;
                if(currWinSize<minWinSize){
                    minWinSize =  currWinSize;
                    st_i=i;
                }
                char start = s.charAt(i);
                map.put(start,map.getOrDefault(start,0)+1);
                if(map.containsKey(start) && map.get(start)>0)reqCount++;
                i++;
            }j++;
        }return  minWinSize==Integer.MAX_VALUE?"":s.substring(st_i,st_i+minWinSize);       

    }
}