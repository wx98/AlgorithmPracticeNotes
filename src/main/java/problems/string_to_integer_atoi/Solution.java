package problems.string_to_integer_atoi;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    /**
     * 直接遍历一遍
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        int flag = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') flag = -1;
            i++;
        }
        int ans = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int temp = str.charAt(i) - '0';
            if (flag == 1 && (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > 7))) {
                return Integer.MAX_VALUE;
            }
            //以正数为列，考虑稳大于和加temp才大于的情况
            if (flag == -1 && (ans > -(Integer.MIN_VALUE / 10) || (ans == -(Integer.MIN_VALUE / 10) && temp > 8))) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + temp;
            i++;
        }
        return ans * flag;
    }

    /**
     * 正则
     *
     * @param str
     * @return
     */
    public int myAtoi2(String str) {
        String pattern = "^\\s*([+-]?\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (!m.find()) {
            return 0;
        }
        BigInteger ans = new BigInteger(m.group(1));
        if (ans.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
            return Integer.MIN_VALUE;
        }
        if (ans.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
            return Integer.MAX_VALUE;
        }
        return ans.intValue();

    }


    /**
     * 状态机做法
     *
     * @param str
     * @return
     */
    public int myAtoi1(String str) {
        Automata auto = new Automata();
        char[] temp = str.toCharArray();
        for (char c : temp) {
            auto.get(c);
        }

        return auto.sign * (int) auto.ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().myAtoi("   -42")
        );
    }

}


/**
 * 状态机
 */
class Automata {
    private int state = 0;
    private int[][] table = {{0, 1, 2, 3},
                             {3, 3, 2, 3},
                             {3, 3, 2, 3},
                             {3, 3, 3, 3}};
    long ans = 0;
    int sign = 1;

    public int gets(char c) {
        if (c == ' ') {
            return 0;//为空格
        }
        if (c == '+' || c == '-') {
            return 1;//为正负号
        }
        if (Character.isDigit(c)) {
            return 2;//为数字
        }
        return 3;//其他
    }

    //状态
    public void get(char c) {
        state = table[state][gets(c)];
        if (state == 2) {
            ans = ans * 10 + (c - '0');
            ans = sign == 1 ? Math.min(ans, Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        }
        if (state == 1 && c == '-') {
            sign = -1;
        }
    }

}

