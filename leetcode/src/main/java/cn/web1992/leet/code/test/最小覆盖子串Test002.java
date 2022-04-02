package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @implNote 最小覆盖子串
 * @link {https://www.bilibili.com/video/BV1qX4y1V7EC}
 * @link {https://leetcode-cn.com/problems/minimum-window-substring/}
 * @date 2022/2/25  9:29 下午
 */
public class 最小覆盖子串Test002 {
    public static void main(String[] args) {
        String target = "ABC";
        String searchTxt = "ADOBECODEBANC";

        String search = minWindow(searchTxt, target);
        System.out.println(search);
    }


    public static String minWindow(String maxStr, String minStr) {

        int minLen = minStr.length();
        int maxLen = maxStr.length();
        int[] map = new int[128];

        int left = 0;
        int right = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;
        int minCount = minLen;

        for (int i = 0; i < minLen; i++) {
            map[minStr.charAt(i)]++;
        }


        while (right < maxLen) {
            char c = maxStr.charAt(right++);
            if (map[c]-- > 0) { // 重点（默认是0）
                minCount--;
            }

            while (minCount == 0) {
                if (minWindow > right - left) {
                    start = left;
                    minWindow = right - left;
                }

                c = maxStr.charAt(left++);
                if (map[c]++ >= 0) { // 重点
                    minCount++;
                }
            }
        }

        return minWindow == Integer.MAX_VALUE ? "" : maxStr.substring(start, start + minWindow);
    }


}
