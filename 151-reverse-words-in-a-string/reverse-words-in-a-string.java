class Solution {
    public String reverseWords(String s) {
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder(s);
        reverse(0, s.length() - 1, sb);

        int n = s.length();

        int i = 0;
        while (i < n) {

            while (i < n && sb.charAt(i) != ' ') {
                sb.setCharAt(right, sb.charAt(i));
                right++;
                i++;
            }
            if (left < right) {
                reverse(left, right - 1, sb);
                if (right < n)
                    sb.setCharAt(right, ' ');

                right++;
                left = right;
            }
            i++;
        }

        return sb.toString().substring(0, right - 1);
    }

    void reverse(int left, int right, StringBuilder sb) {
        while (left < right) {
            char ch = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, ch);
            left++;
            right--;

        }

    }

}