package cn.web1992.utils.demo.nio;// $Id$

import java.nio.ByteBuffer;

public class TypesInByteBuffer {

    static public void main(String args[]) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(30);
        buffer.putLong(7000000000000L);
        buffer.putDouble(Math.PI);
        buffer.putInt("ABC".length());
        buffer.put("ABC".getBytes());

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());

        int bLen = buffer.getInt();
        byte[] bytes = new byte[bLen];

        for (int i = 0; i < bLen; i++) {
            byte b = buffer.get();
            bytes[i] = b;
        }

        System.out.println(new String(bytes));
    }

}
