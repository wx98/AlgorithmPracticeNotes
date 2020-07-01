package problems.zigzag_conversion;

import java.util.*;

public class Solution {


    public String convert(String s, int numRow) {

        if (numRow == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < Math.min(numRow, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRow - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();

        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();

    }


    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        /**
         * 对于所有整数 k，
         *
         * 行 0 中的字符位于索引 k(2⋅numRows−2) 处;
         * 行 numRows−1 中的字符位于索引 k(2⋅numRows−2)+numRows−1 处;
         * 内部的 行 i 中的字符位于索引 k k(2⋅numRows−2)+i 以及i(k+1)(2⋅numRows−2)−i 处;
         */
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    ret.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        int line = 5;
        String strings = "ABCDEFGHIGKLMNOPRSTUVWXYZ";
        System.out.println(new Solution().convert(strings, line)
        );
    }
}
