# 1. 两数之和
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