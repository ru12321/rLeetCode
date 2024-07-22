package com.mrru.hot100.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "()"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 4486 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final List<Character> LEFT_CHAR = new ArrayList<>(Arrays.asList('(', '[', '{'));
    private static final List<Character> RIGHT_CHAR = new ArrayList<>(Arrays.asList(')', ']', '}'));

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (LEFT_CHAR.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (RIGHT_CHAR.contains(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!match(stack.pop(), s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    private boolean match(Character left, Character cur) {
        switch (left) {
            case '(':
                return cur == ')';
            case '[':
                return cur == ']';
            case '{':
                return cur == '}';
            default:
                return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
