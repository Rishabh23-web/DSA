class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char lChar = s.charAt(left);
            char rChar = s.charAt(right);


            if (!Character.isLetterOrDigit(lChar)) {
                left++;
            } 

            else if (!Character.isLetterOrDigit(rChar)) {
                right--;
            } 

            else {
                if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}