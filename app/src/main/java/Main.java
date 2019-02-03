/**
 * Created by Administrator on 2016/11/29.
 *
 * @desc 第一个 2333 能被 2或者3整除的正整数
 * 被2或者被3整除的正整数依次是：2,3,4,6,8,9,10,12,14,15,16,18…。
 */
public class Main {
    public static void main(String[] args) {
        int c = 2333;
        int start = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                start++;
            }
            if (start == c) {
                System.out.println(i);
                return;
            }
        }
    }
}
