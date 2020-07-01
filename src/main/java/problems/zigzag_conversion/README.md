# 6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 `"LEETCODEISHIRING"` 行数为 3 时，排列如下：   

```
L   C   I   R   
E T O E S I I G   
E   D   H   N   
```
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：`"LCIRETOESIIGEDHN"`。   

请你实现这个将字符串进行指定行数变换的函数：   
`string convert(string s, int numRows);`      

示例 1:      

>输入: s = "LEETCODEISHIRING", numRows = 3   
输出: "LCIRETOESIIGEDHN"   

示例 2:
>输入: s = "LEETCODEISHIRING", numRows = 4   
输出: "LDREOEIIECIHNTSG"   

解释:   
```
L     D     R
E   O E   I I
E C   I H   N
T     S     G
```

* Code:[Solution.java](Solution.java)

详解界面->[z-zi-xing-bian-huan-by-leetcode/](https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/)

* 按行排序
```java
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
}
```

*  按行访问
```java
public class Solution {
    public String convert(String s, int numRows) {
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
}
```