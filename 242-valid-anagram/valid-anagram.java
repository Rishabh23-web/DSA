class Solution {
    public boolean isAnagram(String s, String t) {
        int n= s.length();
        int m= t.length();
        HashMap <Character,Integer> map= new HashMap<>();
        HashMap <Character,Integer> map2= new HashMap<>();
        for(int i=0 ; i<n;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);           
        }
        for(int i=0;i<m;i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);   
        }
        return map.equals(map2);
    }
}