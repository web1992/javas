package cn.web1992.utils.demo.jarfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

/**
 * @author web1992
 * @date 2021/2/8  5:16 下午
 * <pre>
 *     jar -cfM0  classes.jar  -C .  .
 * </pre>
 */
public class JarFileMain {

    static String file = "/Users/zl/Documents/DEV/github/spring-boots/target/spring-boots-0.0.1-SNAPSHOT.jar";
    static String path = "/Users/zl/Documents/DEV/github/javas/output/";

    public static void main(String[] args) throws IOException {
        JarFile jarFile = new JarFile(file);

        File file = new File(path + "/" + "aa.jar");
        OutputStream outStream = new FileOutputStream(file);
        JarOutputStream jarOutputStream = new JarOutputStream(outStream);
        jarFile.stream().forEach(jar -> process(path, jarFile, jar, jarOutputStream));

        outStream.close();

    }

    public static void process(String path, JarFile jarFile, JarEntry jarEntry, JarOutputStream jarOutputStream)  {
        String name = jarEntry.getName();

        System.out.println("name=" + name);
        try {
            jarOutputStream.putNextEntry(jarEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            File fileTemp = new File(path);
//            if (fileTemp.exists()) {
//                fileTemp.deleteOnExit();
//            }
//
//            byte[] bs = new byte[1024];
//            InputStream inputStream = jarFile.getInputStream(jarEntry);
//            //String n = getName(name);
//            if (name.endsWith("/")) {
//                ensureDirOK(path + "/" + name);
//            } else {
//                String n = getPathName(path, name);
//                File file = new File(n);
//                OutputStream outStream = new FileOutputStream(file);
//                int len = 0;
//                while (-1 != (len = inputStream.read(bs))) {
//                    outStream.write(bs, 0, len);
//                }
//
//                inputStream.close();
//                outStream.close();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    public static void ensureDirOK(final String dirName) {
        if (dirName != null) {
            File f = new File(dirName);
            if (!f.exists()) {
                boolean result = f.mkdirs();
                //log.info(dirName + " mkdir " + (result ? "OK" : "Failed"));
            }
        }
    }

    private static String getPathName(String path, String name) {

        int i = name.lastIndexOf("/");

        if (i > 0) {
            String _name = name.substring(i + 1);
            String _dir = name.substring(0, i);
            String fullDir = path + _dir;
            ensureDirOK(fullDir);
            return fullDir + "/" + _name;
        } else {
            return path + "/" + name;
        }
    }
}
