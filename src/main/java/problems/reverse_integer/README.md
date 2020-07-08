# 7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:   
>输入: 123   
输出: 321   

示例 2:   

>输入: -123   
输出: -321   

示例 3:   
>输入: 120   
输出: 21   

* 注意:   
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。<br/>请根据这个假设，如果反转后整数溢出那么就返回 0。

* Code:[Solution.java](Solution.java)
   
* 最优解
```java
public class Solution {
    public int reverse(int x) {
            long ans = 0;
            while (x != 0) {
                ans = ans * 10 + x % 10;
                x /= 10;
                if (-2147483648 > ans || ans > 2147483647){
                    return 0;
                }
            }
            return (int) ans;
        }
}
```

```java
public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t) / 10 != res){
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }
}
```