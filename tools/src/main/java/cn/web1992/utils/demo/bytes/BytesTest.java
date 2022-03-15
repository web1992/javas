package cn.web1992.utils.demo.bytes;

/**
 * @author web1992
 * @date 2022/3/15  5:06 下午
 * @link {http://ckjava.com/2018/05/03/java-byte-0XFF/}
 */
public class BytesTest {
    final static char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) {
        byte[] bs = new byte[2];
        bs[0] = -1;
        bs[1] = 1;
        int v = bs[0] & 0xFF;
        System.out.println(v);

        System.out.println(Integer.toHexString(v));
        System.out.println(Integer.toHexString(-1));
        System.out.println("-1 & 0xFF=" + Integer.toHexString(-1 & 0xFF));
        System.out.println(Integer.toHexString(1));
    }

    public static String bytes2string(byte[] src) {
        char[] hexChars = new char[src.length * 2];
        for (int j = 0; j < src.length; j++) {
            int v = src[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
