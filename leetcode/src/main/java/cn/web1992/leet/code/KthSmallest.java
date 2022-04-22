package cn.web1992.leet.code;

/**
 * @author wangjunwei87
 * @since 2019-03-10
 */
public class KthSmallest {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 99, 33, 1, -3, 4, 11, 22, 34, -1};
        // [-3, -2, -1, 1, 4, 11, 22, 33, 34, 99]
        System.out.println("findK=" + kthSmallest(arr, 4));
    }

    public static int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }

        int partition = partition(arr, 0, arr.length - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition + 1, arr.length - 1);
            } else {
                partition = partition(arr, 0, partition - 1);
            }
        }

        return arr[partition];
    }


    private static int partition(int[] arr, int start, int end) {

        int val = arr[end];
        int i = start;
        for (int j = i; j < end; j++) {
            if (arr[j] <= val) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

//    private static int partition(int[] arr, int p, int r) {
//        int pivot = arr[r];
//
//        int i = p;
//        for (int j = p; j < r; j++) {
//            // 这里要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
//            if (arr[j] <= pivot) {
//                swap(arr, i, j);
//                i++;
//            }
//        }
//
//        swap(arr, i, r);
//
//        return i;
//    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
