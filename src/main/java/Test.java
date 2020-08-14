public class Test {
    /**
     * 寻找数组中心索引
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0, leftsum = 0, rightsum = 0;
        for (int n : nums) {
            sum += n;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                leftsum = 0;
            } else {
                leftsum = leftsum + nums[i - 1];
            }
            rightsum = sum - leftsum - nums[i];
            if (leftsum == rightsum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 搜索插入位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 合并区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        int[][] ints;
        for (int i = 0; i < intervals.length; i++) {
            int curA = intervals[i][1];
            int curB = intervals[i + 1][0];
            if (curA > curB){

            }else {

            }
        }


        return intervals;

    }


    public static void main(String[] args) {
        System.out.println(

                new Test().merge(new int[][]{{1, 4}, {4, 5}})

        );
    }
}