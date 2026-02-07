class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxWindow = 0;
        int left = 0;

        // Slide the window with 'right' pointer
        for (int right = 0; right < n; right++) {
            // If the condition is violated, shrink from the left
            while (nums[right] > (long)nums[left] * k) {
                left++;
            }
            // Update the maximum number of elements we can keep
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        // The result is total elements minus the ones we kept
        return n - maxWindow;
    }
}