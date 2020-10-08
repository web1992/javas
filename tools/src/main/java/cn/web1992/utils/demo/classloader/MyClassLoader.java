package cn.web1992.utils.demo.classloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author web1992
 * @date 2020/10/8  14:51
 */
public class MyClassLoader extends ClassLoader {

    private String fileDir;


    public MyClassLoader(ClassLoader parent, String fileDir) {
        super(parent);
        this.fileDir = fileDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {

            byte[] bytes = getClassBytes(fileDir, name);

            Class<?> aClass = defineClass(name, bytes, 0, bytes.length);

            System.out.println("load class success!" + name);
            return aClass;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private byte[] getClassBytes(String fileDir, String className) throws IOException {

        String fileName = className + ".class";
        String fullPath = "";
        if (fileDir.endsWith(File.separator)) {
            fullPath = fileDir + fileName;
        } else {
            fullPath = fileDir + File.separator + fileName;
        }
        System.out.println("load class form " + fullPath);
        byte[] bytes = Files.readAllBytes(Paths.get(fullPath));
        return bytes;
    }

}
