package cn.web1992.leet.code;

/**
 * @author web1992
 * @implNote 最小覆盖子串
 * @link {https://www.bilibili.com/video/BV1qX4y1V7EC}
 * @link {https://leetcode-cn.com/problems/minimum-window-substring/}
 * @date 2022/2/25  9:29 下午
 */
public class 最小覆盖子串2 {
    public static void main(String[] args) {
        String target = "ABC";
        String searchTxt = "ADOBECODEBANC";

        String search = search(searchTxt, target);
        System.out.println(search);
        assert "BANC".equalsIgnoreCase(search);
    }


    private static String search(String maxStr, String minStr) {

        if (maxStr.length() <= 0 || maxStr.length() < minStr.length()) {
            return "";
        }

        int minLen = minStr.length();
        int maxLen = maxStr.length();
        int[] map = new int[128];

        int left = 0;
        int right = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;
        int leftCount = minLen;

        for (int i = 0; i < minLen; i++) {
            map[minStr.charAt(i)]++;
        }

        while (right < maxLen) {
            char c = maxStr.charAt(right++);// 移动right指针
            if (map[c]-- > 0) {
                leftCount--;
            }

            while (leftCount == 0) {
                if (right - left < minWindow) {
                    minWindow = right - left;
                    start = left;
                }
                c = maxStr.charAt(left++);// 移动left指针
                if (map[c]++ >= 0) {
                    leftCount++;
                }

            }

        }

        return minWindow == Integer.MAX_VALUE ? "" : maxStr.substring(start, start + minWindow);

    }


}
