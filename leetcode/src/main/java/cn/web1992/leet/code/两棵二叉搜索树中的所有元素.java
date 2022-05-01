package cn.web1992.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author web1992
 * @date 2022/5/1  13:26
 * @link {https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/}
 */
public class 两棵二叉搜索树中的所有元素 {
    public static void main(String[] args) {

    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> ans = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        getList(l1, root1);

        List<Integer> l2 = new ArrayList<>();
        getList(l2, root2);

        int p1 = 0;
        int p2 = 0;

        while (true) {

            if (p1 == l1.size()) {
                ans.addAll(l2.subList(p2, l2.size()));
                break;
            }

            if (p2 == l2.size()) {
                ans.addAll(l1.subList(p1, l1.size()));
                break;
            }

            if (l1.get(p1) > l2.get(p2)) {
                ans.add(l2.get(p2));
                p2++;
            } else {
                ans.add(l1.get(p1));
                p1++;
            }

        }


        return ans;
    }

    private static void getList(List<Integer> list, TreeNode root) {

        TreeNode p = root;
        if (p == null) {
            return;
        }

        getList(list, p.left);
        list.add(p.val);
        getList(list, p.right);

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
