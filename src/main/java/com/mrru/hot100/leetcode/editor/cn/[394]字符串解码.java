package com.mrru.hot100.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 30
 * <p>
 * s 由小写英文字母、数字和方括号
 * '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为
 * [1, 300]
 * <p>
 * <p>
 * Related Topics 栈 递归 字符串 👍 1792 👎 0
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution394 {
    public static void main(String[] args) {
        String s = new Solution394().decodeString("3[a2[c]]");
        System.out.println(s);
    }

    // 栈要考虑放进去什么东西？以及什么时候取出？  一个栈够不够？
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        //存放中间的倍数
        LinkedList<Integer> stackMulti = new LinkedList<>();
        //存放中间的结果
        LinkedList<String> stackRes = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                multi = multi * 10 + Integer.parseInt(cur + ""); //100[leetcode]  这种情况
            } else if (cur == '[') {
                stackMulti.addLast(multi);
                stackRes.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (cur == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stackMulti.removeLast();
                for (int j = 0; j < cur_multi; j++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stackRes.removeLast() + tmp);
            } else {
                res.append(cur);
            }

        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
