public class LongestPalindrome {
    public int indexOfPalindrom(int start, int end, int maxLen, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
        return end - start - 1;
    }

    public String longestPalindrome(String s) {
//        if (s.length() == 0) {
        if (s == "") {
            return "";
        }
        int start = 0, end = 0, maxLen = 0;
        for (int p = 0; p < s.length() - 1; p++) {
            if (s.charAt(p + 1) == s.charAt(p)) {
                maxLen = Math.max(maxLen, indexOfPalindrom(p, p + 1, maxLen, s));
            }
            if (p > 0 && (s.charAt(p - 1) == s.charAt(p + 1))) {
                maxLen = Math.max(maxLen, indexOfPalindrom(p - 1, p + 1, maxLen, s));
            }
            if (end - start + 1 < maxLen) {
                start = p - (maxLen - 1) / 2;
                end = p + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
//        String s = "huasdc|dcdeedcd|mk";
//        String s = "aa";
        String s = "ccc";
//        h u a s d c | d c d  e  e  d  c  d  |  m  k
//        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17

//        h u a s d c | d c d  e  x  e  d  c  d  |  m  k
//        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18

        LongestPalindrome Ob = new LongestPalindrome();

        System.out.println(Ob.longestPalindrome(s));
    }
}
