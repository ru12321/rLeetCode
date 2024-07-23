package com.mrru.hot100.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几
 * 天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= temperatures.length <= 10⁵
 * 30 <= temperatures[i] <= 100
 * <p>
 * <p>
 * Related Topics 栈 数组 单调栈 👍 1789 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution739 {
    public static void main(String[] args) {
        int[] input = {75, 74, 75, 71, 69, 72, 76, 73};
        int[] res = new Solution739().dailyTemperatures(input);
        System.out.println(Arrays.toString(res));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        //结果
        int[] res = new int[temperatures.length];
        //单调栈
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer lastIndex = stack.pop();
                res[lastIndex] = i - lastIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
