package com.mrru.hot100.leetcode.editor.cn; /**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * Related Topics 栈 树 深度优先搜索 二叉树 👍 2111 👎 0
 */

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        handleVal(root, list);
        return list;
    }


    private void handleVal(TreeNode root, List<Integer> list) {
        if (root != null) {
            handleVal(root.left, list);
            list.add(root.val);
            handleVal(root.right, list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
