package cn.web1992.leet.code.字符串匹配;

/**
 * @author web1992
 * @date 2022/4/6  23:17
 * @link {https://www.bilibili.com/video/BV1xJ411b7rH} RK 算法的思想
 * @link {https://www.bilibili.com/video/BV1xJ411b7rH} RK 算法问题：hash冲突+数字溢出
 */
public class PK字符串匹配算法 {

    public static void main(String[] args) {


        System.out.println(RK("abc", "bc"));
        System.out.println(RK("abcdef", "af"));

    }

    /**
     * Brute Force 暴力匹配算法
     *
     * @param a
     * @param b
     * @return
     */
    public static int bF(String a, String b) {
        int m = a.length(), n = b.length(), k;
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        for (int i = 0; i <= m - n; i++) {
            k = 0;
            for (int j = 0; j < n; j++) {
                if (a1[i + j] == b1[j]) {
                    k++;
                } else
                    break;
            }
            if (k == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * RK 算法 (Rabin-Karp 人名的缩写)
     *
     * @param a
     * @param b
     * @return
     */
    public static int RK(String a, String b) {
        int m = a.length(), n = b.length(), s, j;
        int[] hash = new int[m - n + 1];
        int[] table = new int[26];
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        s = 1;
        //将26的次方存储在一个表里，取的时候直接用,虽然溢出，但没啥问题
        for (j = 0; j < 26; j++) {
            table[j] = s;
            s *= 26;
        }
        for (int i = 0; i <= m - n; i++) {
            s = 0;
            for (j = 0; j < n; j++) {
                s += (a1[i + j] - 'a') * table[n - 1 - j];
            }
            hash[i] = s;
        }
        s = 0;
        for (j = 0; j < n; j++) {
            s += (b1[j] - 'a') * table[n - 1 - j];
        }
        for (j = 0; j < m - n + 1; j++) {
            if (hash[j] == s) {
                return j;
            }
        }
        return -1;
    }

}
