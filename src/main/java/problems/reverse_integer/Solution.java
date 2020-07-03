package problems.reverse_integer;
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

    public static void main(String[] args) {
        int nums = 1231231231;
        System.out.println(
                new Solution().reverse(nums)
        );
    }
}
