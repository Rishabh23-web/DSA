class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> st = new Stack<>();
        int ans[] = new int[nums1.length];
        Arrays.fill(ans, -1);
        /*int k=1;
        for(int i=0;i<nums1.length;i++){
            st.push(nums1[i]);
        }*/
        for(int k=0;k<nums1.length;k++){
            for(int i=0;i<nums2.length;i++){
                if(nums2[i]==nums1[k]){
                    for(int j=i;j<nums2.length;j++){
                        if(nums2[i]<nums2[j]){
                            ans[k]=nums2[j];
                            break;
                        }
                    }
                }
            }
        }return ans;
    }
}