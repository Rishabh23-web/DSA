class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        int longest=1;
        if(n==0)
            return 0;
        Map <Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],Boolean.FALSE);
        }
        for(int num:nums){
            int currLen =1;
            int nextNum=num+1;
            while(map.containsKey(nextNum) && map.get(nextNum)==false){
                currLen++;
                map.put(nextNum,Boolean.TRUE);
                nextNum++;
            }
            int prevNum=num-1;
            while(map.containsKey(prevNum) && map.get(prevNum)==false){
                currLen++;
                map.put(prevNum,Boolean.TRUE);
                prevNum--;
            }
            longest = Math.max(longest,currLen);
        }return longest;
        
    }
}