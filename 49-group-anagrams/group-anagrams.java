class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)return new ArrayList<>();
        HashMap<String,List<String>> map =new HashMap<>();
        for(String w: strs){
            char [] ch = w.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(w);
        }return new ArrayList<>(map.values());
    }
}