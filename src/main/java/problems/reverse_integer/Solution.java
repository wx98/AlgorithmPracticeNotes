package problems.reverse_integer;

public class Solution {



    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            int newRes = res * 10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t) / 10 != res) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }

    public int reverse1(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
            if (-2147483648 > ans || ans > 2147483647)
                return 0;
        }
        return (int) ans;
    }


    /**
     * 当初自己写的垃圾方法
     * @param x
     * @return
     */
    public int reverse2(int x) {
        boolean flag = x < 0;
        x = Math.abs(x);
        StringBuilder ret = new StringBuilder(x + "");
        ret.reverse();
        if (flag) {
            ret.insert(0, '-');
        }
        try {
            x = Integer.parseInt(ret.toString());
        } catch (Exception e) {
            x = 0;
        }
        return x;
    }

    public static void main(String[] args) {
        int nums = 1534236469;
        System.out.println(
                new Solution().reverse1(nums)
        );
    }
}
