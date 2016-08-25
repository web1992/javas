package cn.web1992.utils.demo;

import java.io.*;

/**
 * Created by web1992 on 2016/8/25.
 *
 * @desc 对象的深复制，对象的浅复制
 *      设计模式，主要解决对象的创建， 对象的唯一性，对象的兼容等问题（普遍适用的方法，或者最佳实践）
 *
 * @blog http://zz563143188.iteye.com/blog/1847029
 *
 */
public class ClazzClone {


    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype1 = new Prototype();
        prototype1.setString("1");
        prototype1.setVal(1);
        System.out.println("clone="+prototype1.getString().toString());

        Prototype prototype2 = (Prototype) prototype1.clone();

        System.out.println("clone="+prototype2.getString().toString());


        Prototype prototype3 = (Prototype) prototype1.depClone();

        System.out.println("depClone="+prototype3.getString().toString());

    }


    static class Prototype implements Cloneable, Serializable {


        private static final long serialVersionUID = 1L;
        private String string;
        private int val;


        @Override
        public String toString() {
            return this.getString() + "-" + this.getVal();
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        private SerializableObject obj;


        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        public SerializableObject getObj() {
            return obj;
        }

        public void setObj(SerializableObject obj) {
            this.obj = obj;
        }

        /**
         * @return
         * @throws CloneNotSupportedException
         * @desc 对象的浅复制
         */
        @Override
        public Object clone() throws CloneNotSupportedException {
            Prototype prototype = (Prototype) super.clone();
            return prototype;
        }

        /**
         * @return
         * @desc 对象的深复制
         */
        public Object depClone() throws IOException, ClassNotFoundException {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bis);

            return objectInputStream.readObject();
        }

    }

    class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
    }

}


