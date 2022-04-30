package cn.web1992.leet.code.字符串匹配;

/**
 * @author web1992
 * @date 2022/4/6  22:25
 */
public class FB匹配算法 {

    public static void main(String[] args) {

        System.out.println(new FB匹配算法().match("abc", "bc"));
        System.out.println(new FB匹配算法().match("aaabbccddee", "de"));
        System.out.println(new FB匹配算法().match("aaabbccddee", "zzz"));
    }

    public int match(String s1, String s2) {

        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return -1;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        return match0(c1, c2);
    }

    public int match0(char[] c1, char[] c2) {

        int i = 0, j = 0, p = -1;

        while (i < c1.length) {

            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == c2.length) {
                p = i;
                break;
            }

        }


        return p - j;
    }

}
