# 1. 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。   
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
>示例:
>给定 nums = [2, 7, 11, 15], target = 9   
>因为 nums[0] + nums[1] = 2 + 7 = 9   
>所以返回 [0, 1]
 
* Code:[Solution.java](src\main\java\problems\two_sum\Solution.java)
   
* 暴力解法
```java
public class Solution {
    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] ==  target){
                    return   new int [] {i,j};
                }
            }
        }
        return   new int [] {-1,-1};
    }
}
```
* 利用HasMap
```java
public class Solution {
    /**
     * 利用HasMap
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
```