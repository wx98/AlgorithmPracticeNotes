# 4. 寻找两个正序数组的中位数
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。      
请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。      
你可以假设 nums1 和 nums2 不会同时为空。      

示例 1:
>nums1 = [1, 3]   
nums2 = [2]   
则中位数是 2.0   

示例 2:
>nums1 = [1, 2]   
nums2 = [3, 4]   
则中位数是 (2 + 3)/2 = 2.5   

* Code:[Solution.java](Solution.java)
   
* 这个就讲的很好->[点这个](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/4-xun-zhao-liang-ge-zheng-xu-shu-zu-de-zhong-we-15/) ,思维方式很值得学习
```java
public class Solution {
   public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
       int length = nums1.length + nums2.length;
       //选择长度较小的那个数组进行查找
       if (nums1.length > nums2.length) {
           return findMedianSortedArrays(nums2, nums1);
       }
       if (nums1.length == 0) {
           if (nums2.length % 2 != 0) {
               return nums2[length / 2];
           } else {
               return (nums2[length / 2 - 1] + nums2[length / 2]) / 2.0;
           }
       }
       ////初始化二分查找的边界
       int L_edge = 0, R_edge = nums1.length;
       int cur1 = 0, cur2 = 0;
       double result = 0;
       while (L_edge <= R_edge) {
           cur1 = L_edge + (R_edge - L_edge) / 2;
           cur2 = (length + 1) / 2 - cur1;
           //计算出L1，R1，L2，R2
           double L1 = cur1 == 0 ? Integer.MIN_VALUE : nums1[cur1 - 1];
           double R1 = cur1 == nums1.length ? Integer.MAX_VALUE : nums1[cur1];
           double L2 = cur2 == 0 ? Integer.MIN_VALUE : nums2[cur2 - 1];
           double R2 = cur2 == nums2.length ? Integer.MAX_VALUE : nums2[cur2];
           //二分查找，重新划定边界
           if (L1 > R2) {
               R_edge = cur1 - 1;
           } else if (L2 > R1) {
               L_edge = cur1 + 1;
           } else {
               //注意长度为奇数偶数的问题，奇数取中间的那个值，偶数则取两边的和的一半
               if (length % 2 != 0) {
                   result = Math.max(L1, L2);
               } else {
                   result = (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
               }
               break;
           }
       }
       return result;
   }
}
```