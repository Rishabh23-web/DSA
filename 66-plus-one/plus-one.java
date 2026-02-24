class Solution {
public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
        // If the current digit is less than 9, we just add 1 and we're done!
        if (digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        // If the digit was 9, it becomes 0 and the loop continues (carrying the 1)
        digits[i] = 0;
    }

    // If we reach here, it means every single digit was a 9 (e.g., [9, 9, 9])
    // We need a new array that is one size larger, starting with 1.
    int[] newDigits = new int[digits.length + 1];
    newDigits[0] = 1;
    return newDigits;
}
        
    
}