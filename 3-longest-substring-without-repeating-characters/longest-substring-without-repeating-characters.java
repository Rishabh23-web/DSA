class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)return 0;
        int n =s.length();
        HashSet <Character> set = new HashSet<>();
        int maxCount = 0;
        int i=0;
        int j=0;
        while(j<n){

            while(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxCount = Math.max(maxCount,j-i+1);
            j++;
        }
        return maxCount;
    }
}