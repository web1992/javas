package cn.web1992.sort.select.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * SelectSort 选择排序
 *
 * @author web1992
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = new int[]{11, 34, 5, 6, 32, 123, 98};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void selectSort(int[] ints) {

        ArrayList<Integer> list = arrToList(ints);

        int i = 0;
        for (int j = 0; j < ints.length; j++) {
            int si = findSmallestInt(list);
            ints[i++] = list.remove(si);
        }

    }

    private static ArrayList<Integer> arrToList(int[] ints) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            list.add(ints[i]);
        }
        return list;
    }

    /**
     * 每次找到最小的
     *
     * @param integers
     * @return
     */
    private static int findSmallestInt(ArrayList<Integer> integers) {

        int si = 0;
        for (int i = 1; i < integers.size(); i++) {

            if (integers.get(si) > integers.get(i)) {
                si = i;
            }
        }
        return si;
    }
}
