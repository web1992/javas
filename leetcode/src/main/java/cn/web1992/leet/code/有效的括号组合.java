package cn.web1992.leet.code;


import java.util.ArrayList;
import java.util.List;

/**
 * @author web1992
 * @date 2022/3/21  8:50 上午
 * @link {https://www.bilibili.com/video/BV1Y44y1s7zn}
 * @link {https://leetcode-cn.com/problems/bracket-lcci/}
 *
 * <pre>
 * 输入：3
 *
 * 输出：
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 * </pre>
 */
public class 有效的括号组合 {


    public static void main(String[] args) {


        for (String an : generateParenthesis(2)) {
            System.out.println(an);
        }
    }

    private static List<String> generateParenthesis(int num) {

        List<String> listAns = new ArrayList<>();

        run(listAns, new ArrayList<>(), num, 0, 0);

        return listAns;
    }


    /**
     * 递归 + 穷举 + 回溯 算法
     *
     * @param cur
     * @param n
     * @param r
     * @param l
     */
    private static void run(List<String> listAns,
                            List<String> cur,
                            int n,
                            int r,
                            int l) {

        if (2 * n == cur.size()) {
            // 括号是成对的，因此 size = 2倍的n
            listAns.add(String.join("", cur));
            return;
        }

        if (n - l > 0) {
            List<String> _list = new ArrayList<>(cur);
            _list.add("(");
            run(listAns, _list, n, r, l + 1);
        }

        if (n - r > 0 && r < l) {
            List<String> _list = new ArrayList<>(cur);
            _list.add(")");
            run(listAns, _list, n, r + 1, l);
        }
    }

}
