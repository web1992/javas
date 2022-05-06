package cn.web1992.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author web1992
 * @date 2022/5/6  20:12
 * @link {https://leetcode-cn.com/problems/hanota-lcci/} 汉诺塔
 */
public class 汉诺塔 {


    public static void main(String[] args) {

        List<Integer> A = new ArrayList();
        A.add(3);
        A.add(2);
        A.add(1);


        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        hanota(A, B, C);

        for (Integer i : C) {
            System.out.println(i);
        }

    }

    //    _
    //   _ _
    //  _ _ _
    //    A        B       C
    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        hanota0(A.size(), A, B, C);
    }

    public static void hanota0(int n, List<Integer> A, List<Integer> B, List<Integer> C) {

        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        // hanota0
        hanota0(n - 1, A, C, B);
        // move
        C.add(A.remove(A.size() - 1));
        // hanota0
        hanota0(n - 1, B, A, C);

    }


}
