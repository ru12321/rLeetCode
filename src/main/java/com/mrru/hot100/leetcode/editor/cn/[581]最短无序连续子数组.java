package com.mrru.hot100.leetcode.editor.cn;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,4,1,5]
 * 输入：nums = [3,4,8,5,3,2,1]
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁵ <= nums[i] <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 1151 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution581 {
    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        int[] arr2 = {6, 2, 8, 1, 15};
        //System.out.println(new Solution().findUnsortedSubarray(arr));
        System.out.println(new Solution581().findUnsortedSubarray2(arr2));
    }

    //自己默写一遍
    public int findUnsortedSubarray(int[] nums) {
        // 2 4 5(左边界)   x x x x  (右边界)8 9 10
        // 整体是【升序】的，所以左边界 <= 右边界
        // 因此找右边界，从左到右依次找，遇到小的就替换下标
        // 因此找左边界，从右到左依次找，遇到大的替换下标

        int max = nums[0], end = -1;
        int min = nums[nums.length - 1], begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[nums.length - i - 1] > min) {
                begin = nums.length - i - 1;
            } else {
                min = nums[nums.length - i - 1];
            }
        }
        return end - begin + 1;
    }


    public int findUnsortedSubarray2(int[] nums) {
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int begin = 0, end = -1;
        for (int i = 0; i < len; i++) {

            if (nums[i] < max) {
                //从左到右维持最大值，寻找右边界end
                end = i;
            } else {
                max = nums[i];
            }

            if (nums[len - i - 1] > min) {
                //从右到左维持最小值，寻找左边界begin
                //左边界的意思是：保证左边界的左侧的值都比我小。所以如果遍历的当前值A大于左边界，那就替换A的index为左边界的index
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
