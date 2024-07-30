package com.mrru.hot100.leetcode.editor.cn;

import java.util.*;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * -2³¹ <= val <= 2³¹ - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 10⁴ 次
 * <p>
 * <p>
 * Related Topics 栈 设计 👍 1794 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {


    private Stack<Integer> list;

    private Stack<Integer> minStack;

    public MinStack() {
        list = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        list.push(val);
        if (minStack.size() == 0 || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (list.size() > 0) {
            int pop = list.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (list.size() > 0) {
            return list.peek();
        } else {
            return -1;
        }

    }

    public int getMin() {
        if (minStack.size() > 0) {
            return minStack.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
