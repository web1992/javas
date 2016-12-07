package cn.web1992.utils.demo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author web1992
 * @deta 2016/12/7
 * @desc 使用传统的方法来进行文件的复制
 * <p>
 * java NIO中使用ByteBuffer 进行数据的读写
 * -> 不需要告诉通道要写入多数据。缓冲区的内部统计机制会跟踪它包含多少数据以及还有多少数据要写入
 * -> {java.nio.Buffer#flip} 使用 position limit 确定要写入，读取的数据大小，长度，这也是
 * -> 不需要告诉通道要写入多数据的原因
 * <p>
 * 而在传统的IO中需要 outputStream.write(readByte,0,len); 来执行需要写入的数据的开始位置和长度
 */
public class CopyFileOldIO {

    final static String FILE_NAME = "README.md";
    final static String FILE_NAME_2 = "README_2.md";

    public static void main(String[] args) throws Exception {
        File file = new File(FILE_NAME);
        if (file.exists()) {

            FileInputStream inputStream = new FileInputStream(file);

            FileOutputStream outputStream = new FileOutputStream(new File(FILE_NAME_2));
            byte[] readByte = new byte[100];
            int len = 0;
            while ((len = inputStream.read(readByte)) != -1) {
                outputStream.write(readByte, 0, len);
                // 这里不能使用 readByte 进行写数据，底层使用 readByte.length 进行数据的写入
                // 存在 inputStream.read 读取的数据与 readByte数组的长度不一样的状态
                //outputStream.write(readByte);
            }
            inputStream.close();
            outputStream.close();

        } else {
            System.out.println("file not exist");
        }
    }
}
