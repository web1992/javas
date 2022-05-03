package cn.web1992.leet.code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author web1992
 * @date 2022/5/3  21:19
 * @link {https://leetcode-cn.com/problems/combinations/}
 * @link {https://programmercarl.com/0077.%E7%BB%84%E5%90%88.html#%E5%9B%9E%E6%BA%AF%E6%B3%95%E4%B8%89%E9%83%A8%E6%9B%B2} 回溯
 */
public class 组合 {

    public static void main(String[] args) {

        // n = 4, k = 2

        //System.out.println(new Solution().combine(4, 2));
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> pack = new LinkedList<>();

        combine(n, k, 1, ans, pack);

        return ans;
    }

    public static void combine(int n,
                               int k,
                               int startIndex,
                               List<List<Integer>> ans,
                               LinkedList<Integer> pack) {

        if (k == pack.size()) {
            ans.add(new ArrayList<>(pack));
            return;
        }

        for (int i = startIndex; i <= (n - (k - pack.size()) + 1); i++) {
            pack.add(i);
            combine(n, k, i + 1, ans, pack);
            pack.removeLast();
        }

    }

    public static class Solution {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            combineHelper(n, k, 1);
            return result;
        }

        /**
         * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
         *
         * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
         */
        private void combineHelper(int n, int k, int startIndex) {
            //终止条件
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);
                combineHelper(n, k, i + 1);
                path.removeLast();
            }
        }
    }
}