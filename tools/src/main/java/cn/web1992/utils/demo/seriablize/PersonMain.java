
package cn.web1992.utils.demo.seriablize;

import java.io.*;

/**
 * desc: 序列化
 * <p>
 * Version		1.0.0
 *
 * @author wangerbao
 * <p>
 * Date	      2018/11/12 18:25
 */
public class PersonMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();

        person.setName("web1992");
        person.setAge(18);


        File objFile = new File("temp");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(objFile));

        out.writeObject(person);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(objFile));


        Person seriPseson = (Person) in.readObject();

        System.out.println("I am " + seriPseson.getName() + " my age is" + seriPseson.getAge());

    }
}
