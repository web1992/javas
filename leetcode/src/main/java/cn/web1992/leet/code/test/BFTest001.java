package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/4/29  10:44
 */
public class BFTest001 {

    public static void main(String[] args) {
        System.out.println(bF("aabcfdef", "bcf"));
        System.out.println(bF("aabcfdef", "bca"));
    }


    //aabcdef
    //  bcf
    public static int bF(String main, String sub) {

        int maxLen = main.length();
        int minLen = sub.length();

        if (minLen > maxLen) {
            return -1;
        }

        char[] charMax = main.toCharArray();
        char[] charMin = sub.toCharArray();

        for (int i = 0; i < maxLen - minLen; i++) {

            int k = 0;
            for (int j = 0; j < minLen; j++) {
                if (charMax[i + j] == charMin[j]) {
                    k++;
                } else {
                    break;
                }
            }

            if (k == minLen) {
                return k; // 字符串长度
                // return i; // 返回 indexOf
            }
        }

        return -1;
    }
}
