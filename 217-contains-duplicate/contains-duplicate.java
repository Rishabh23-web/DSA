class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();
        map.put(nums[0],1);
        for(int i=1;i<nums.length;i++){
            if(!map.containsKey(nums[i]))map.put(nums[i],i);
            else return true;
        }return false;
    }
}