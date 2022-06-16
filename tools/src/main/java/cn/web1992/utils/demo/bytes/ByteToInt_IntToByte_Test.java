package cn.web1992.utils.demo.bytes;

/**
 * @author web1992
 * @date 2022/6/10  16:12
 * @link {https://www.zhaozhizheng.com/articles/2020/12/22/1608639433807.html}
 * @link {https://www.cnblogs.com/NaughtyCat/p/little-endian-and-big-endian-based-on-bytebuffer-in-java.html} 大小端
 */
public class ByteToInt_IntToByte_Test {

    public static void main(String[] args) {

        int num = -12;
        byte[] bytes = new byte[4];

        int2bytes(num, bytes);
        int b = bytes2int(bytes);
        // 有Bug的实现
        int c = bytes2intBuggy(bytes);
        int d = bytes2int2(bytes);

        System.out.println("bytes2int b=" + b);
        System.out.println("bytes2intBuggy c=" + c);
        System.out.println("bytes2int2 d=" + d);
        System.out.println();

        System.out.println("12=" + Integer.toBinaryString(-num));
        System.out.println("-12=" + Integer.toBinaryString(num));
        System.out.println();

        System.out.println("bytes2int=" + Integer.toBinaryString(b));
        System.out.println("bytes2intBuggy=" + Integer.toBinaryString(c));

    }

    // 32位16进制的 0x45679812在内存中的存储（大小端模式）
    // 内存地址增加
    // Address       01 02 03 04
    // Little endian 12 98 67 45
    // Big endian    45 67 98 12

    // 大端，高位在最前
    // 小端，低位在最前

    // JAVA语言中所有的二进制文件都是按大端存储
    // 1字节(1byte)=8位,int占4个字节(Java语言中)
    // 因此需要4个byte存储一个int
    // >>> 逻辑位移(位移有两种，算数位移和逻辑位移，具体可参考CSAPP这本书)
    public static void int2bytes(int v, byte[] b) {
        b[3] = (byte) v;// 把最低位的8位，赋值给byte[3]
        b[2] = (byte) (v >>> 8);
        b[1] = (byte) (v >>> 16);
        b[0] = (byte) (v >>> 24);// 右移24,把最高位的8位，赋值给byte[0]
        // 如何理解上面的代码：
        // 大端存储又称网络字节序，那么进行网络传输的时候，肯定是先传输byte[0]，byte[0]肯定存储的是大端
    }

    // 12的二进制表示
    // 12=1100

    // -12 补码的表示 11111111111111111111111111110100
    // b[3]=1111 1111
    // b[2]=1111 1111
    // b[1]=1111 1111
    // b[0]=1111 0100

    // 0xFF=1111 1111
    public static int bytes2int(byte[] b) {
        // a & 0xFF 的作用：使高24位都是0，只保留低8位
        // 执行 & 的操作的时候，其实底层进行了byte->int的转化
        // byte占8位，int占32位(4*8=32),那么高位就补
        return ((b[3] & 0xFF) << 0) +
                ((b[2] & 0xFF) << 8) +
                ((b[1] & 0xFF) << 16) +
                ((b[0]) << 24);// byte[0]肯定存储的是大端,因此移动24位
    }

    // 如果把+替换成 |，则不需要 & 0xFF。
    public static int bytes2int2(byte[] b) {
        return (b[3]  << 0) |
                (b[2] << 8) |
                (b[1] << 16) |
                (b[0] << 24);
    }

    // 有bug 的实现
    public static int bytes2intBuggy(byte[] b) {
        return (b[3] << 0) +
                (b[2] << 8) +
                (b[1] << 16) +
                (b[0] << 24);
    }

}
