# 3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:   
>输入: "abcabcbb"   
>输出: 3    
>* 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。   

示例 2:   
>输入: "bbbbb"   
>输出: 1   
>* 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。   

示例 3:   
>输入: "pwwkew"      
>输出: 3      
>* 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。    
>* 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。   


* Code:[Solution.java](Solution.java)
* 
* 滑动窗口   
~~这个没看明白~~
```java
public class Solution {
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
}
```
* 双指针
```java
public class Solution {
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
}
```
* 队列
```java
public class Solution {
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
}
```
* 还是队列思想(Set代替Queue)
```java
public class Solution {
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
}
```
* 上面的优化
```java
public class Solution {
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
}
```