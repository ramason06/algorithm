package src;

public class LongestPalindromic {
    public String longestPalindrome(String s) {
        boolean[][] isPaline = new boolean[1010][1010];
        int len = s.length();

        if(len == 0) {
            return s;
        }

        String ans = s.substring(0, 1);
        int maxx = ans.length();
        for (int i = 0; i < len; i++) {
            isPaline[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    isPaline[i][j] = isPaline[i - 1][j + 1];
                }
                if (i - j == 1) isPaline[i][j] |= s.charAt(i) == s.charAt(i-1);
                if(isPaline[i][j] && i + 1 - j > maxx) {
                    maxx = i+1-j;
                    ans = s.substring(j, i+1);
                }
            }
        }
        return ans;
    }
}
