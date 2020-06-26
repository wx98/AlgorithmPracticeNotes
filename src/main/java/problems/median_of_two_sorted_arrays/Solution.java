package problems.median_of_two_sorted_arrays;

public class Solution {

    /**
     * 归并
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        int helpSize = nums1.length + nums2.length;
        if (helpSize % 2 != 0) {
            result = getNum(nums1, nums2, helpSize / 2);
        } else {
            result = getNum(nums1, nums2, helpSize / 2 - 1) / 2 + getNum(nums1, nums2, helpSize / 2) / 2;
        }
        return result;
    }

    public double getNum(int[] nums1, int[] nums2, int k) {
        int[] result = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int cur = 0;
        while (i < nums1.length && j < nums2.length && cur <= k) {
            if (nums1[i] < nums2[j]) {
                result[cur++] = nums1[i++];
            } else {
                result[cur++] = nums2[j++];
            }
        }
        while (i < nums1.length && cur <= k) {
            result[cur++] = nums1[i++];
        }
        while (j < nums2.length && cur <= k) {
            result[cur++] = nums2[j++];
        }
        return result[cur - 1];
    }


    /**
     * 时间复杂度变为O(log(min(m,n)))
     *
     * @param nums1
     * @param nums2
     * @return
     */
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

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .findMedianSortedArrays2(
                                new int[]{0, 13, 23, 45, 72, 88, 99},
                                new int[]{2, 6, 9, 13, 16, 27, 38, 49, 78, 99}
                        )
        );
    }
}
