class Solution {
    public int maxProduct(int[] nums) {
        long leftProduct = 1;
        long rightProduct = 1;
        int n= nums.length;
        long ans = nums[0];

        for(int i=0 ; i<n ;i++){

            leftProduct = (leftProduct==0|| leftProduct<Integer.MIN_VALUE)?1:leftProduct;
            rightProduct = (rightProduct==0 || leftProduct<Integer.MIN_VALUE)?1:rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-i-1];

            ans= Math.max(ans,Math.max(leftProduct,rightProduct));
        }
        return (int)ans;
    }
}