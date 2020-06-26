package problems.longest_substring_without_repeating_characters;

import java.util.*;

public class Solution {
    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> characters = new HashSet<>();
        int length = s.length();
        int lp = -1;
        for (int i = 0; i < length; ++i) {
            if (i != 0) {
                characters.remove(s.charAt(i - 1));
            }
            while (lp + 1 < length && !characters.contains(s.charAt(lp + 1))) {
                characters.add(s.charAt(lp + 1));
                ++lp;
            }
            result = Math.max(result, lp - i + 1);
        }
        return result;
    }


    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            //有重复值则移动j指针到重复值最新出现的位置
            if (hashMap.containsKey(s.charAt(i))) {
                j = Math.max(j, hashMap.get(s.charAt(i)) + 1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);//i,j之间的距离为无重复字符串最大值
        }
        return max;
    }

    /**
     * 队列
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        //建个char队列
        Queue<Character> queue = new LinkedList<>();
        //遍历数组
        for (char c:s.toCharArray()){
            //若在队列里找到重复数据
            while (queue.contains(c)){
                //队首出队
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            //最大值为当前队列的长度
            max = Math.max(max,queue.size());
        }
        return  max;
    }

    /**
     * 还是队列思想
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            while (set.contains(s.charAt(right)))
                set.remove(s.charAt(left++));
            set.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    /**
     * lengthOfLongestSubstring3 的优化
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring4(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "sahvbqjnfqwuegvdcqlkenfqfgdhbcaypaidqonqdfasfasfsf";
        System.out.println(
                new Solution().lengthOfLongestSubstring4(s)
        );
    }
}
