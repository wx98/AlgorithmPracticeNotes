package problems.longest_palindromic_substring;

public class Solution {

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //如果当前枚举的字符串长度最长，且当前枚举字符串为有效回文串
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;//更新当前字符串长度
                    begin = i;//更新当前字符串起始位置
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 判断是否为有效回文字符串
     *
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 中心扩散
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);

            int curMax = Math.max(oddLen, evenLen);
            if (curMax > maxLen) {
                maxLen = curMax;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散可达到最长长度
     *
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenter(char[] charArray, int left, int right) {
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i > 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return j - i - 1;
    }


    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        //初始化结果表格
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {//头尾不相等得到结论不是回文串
                    dp[i][j] = true;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * Manacher 算法
     * @param s
     * @return
     */
    public String longestPalindrome4(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String str = AddDivders(s, "#");
        int sLen = len * 2 + 1;
        int[] p = new int[sLen];
        int maxRight = 0;
        int center = 0;

        int maxLen = 1;
        int begin = 0;

        char[] charArray = str.toCharArray();
        for (int i = 0; i < sLen; i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);
            while (left >= 0 && right < sLen && charArray[left] == charArray[right]) {
                p[i]++;
                left--;
                right++;
            }
            if (p[i] + i > maxRight) {
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen) {
                maxLen = p[i];
                begin = (i - maxLen) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private String AddDivders(String s, String divider) {
        if (s.indexOf(divider) != -1) {
            throw new IllegalArgumentException("'" + divider + "'在字符串'" + s + "'中已存在");
        }
        char[] charArray = s.toCharArray();
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(divider);
            stringBuilder.append(charArray[i]);
        }
        stringBuilder.append(divider);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .longestPalindrome4(
                                "slfuhasiduhaifgiqwvefhdscauieiq"
                        )
        );
    }
}
