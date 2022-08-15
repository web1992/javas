package cn.web1992.utils.demo.files;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FilesDemo {
    public static void main(String[] args) throws Exception {

        if (null == args || args.length == 0) {
            System.out.println("args is null");
            return;
        }

        String file = args[0];

//        String file = "D:\\dev\\github\\read";
//        String file = "D:\\dev\\github\\read\\redis\\Redis核心";
        processPath(Paths.get(file));

    }

    public static void processPath(Path path) {
        try {
            Files.list(path)
                    .filter(FilesDemo::filterHide)
                    .filter(FilesDemo::filterMD)
                    .forEach(FilesDemo::lines);

            Files.list(path)
                    .filter(FilesDemo::filterHide)
                    .filter(FilesDemo::filterDir)
                    .forEach(FilesDemo::processPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean filterDir(Path path) {

        boolean isDir = path.toFile().isDirectory();
        return isDir;
    }

    public static boolean filterHide(Path path) {
        Path fileName = path.getFileName();
        String name = fileName.toFile().getName();
        return !name.startsWith(".");
    }

    public static boolean filterMD(Path path) {
        Path fileName = path.getFileName();
        String name = fileName.toFile().getName();
        return name.endsWith(".md");
    }

    /**
     * ---
     * title: "Read"
     * date:
     * draft: false
     * tags: ["hugo2"]
     * categories: ["ABC"]
     * ---
     *
     * @param path
     */
    public static void lines(Path path) {

        try {


            File file = path.getParent().getFileName().toFile();
            String name = file.getName();


            String line = Files.lines(path).findFirst().orElse("");

            String ss = line.replace("#", "");
            if (ss.startsWith(" ")) {
                ss = ss.substring(1, ss.length());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("---\n");
            sb.append("title: \"" + name + "/" + ss + "\"" + "\n");
            // 2022-08-12T13:55:28+08:00
            sb.append("date: " + getDateStr(path.toFile()) + "\n");
            sb.append("tags: [\"" + name + "\"]\n");
            sb.append("categories: [\"" + name + "\"]\n");
            sb.append("draft: false\n");
            sb.append("---\n");
//            System.out.println(line);
//            System.out.println(sb.toString());

            try {
                appendFileHeader(sb.toString().getBytes(StandardCharsets.UTF_8), path.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static String getDateStr(File file) {

        BasicFileAttributes bAttributes = null;
        try {
            bAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileName = file.getName();

        // 修改时间
        long changeTime = bAttributes.lastModifiedTime().to(TimeUnit.MILLISECONDS);
        // 修正格式和时区
        Date date = new Date(changeTime);

        System.out.println(new Date().toString());

        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat s2 = new SimpleDateFormat("HH:mm:ss");
        // 2022-08-12T13:55:28+08:00
        String s = s1.format(date).toString() + "T" + s2.format(date).toString() + "+08:00";
        System.out.println(s);
        return s;
    }

    private static void appendFileHeader(byte[] header, String srcPath) throws Exception {
        RandomAccessFile src = new RandomAccessFile(srcPath, "rw");
        int srcLength = (int) src.length();
        byte[] buff = new byte[srcLength];
        src.read(buff, 0, srcLength);
        src.seek(0);
        src.write(header);
        src.seek(header.length);
        src.write(buff);
        src.close();
    }

}
