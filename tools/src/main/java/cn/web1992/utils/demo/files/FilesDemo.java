package cn.web1992.utils.demo.files;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilesDemo {
    public static void main(String[] args) throws Exception {

        if (null == args || args.length == 0) {
            System.out.println("args is null");
            return;
        }

        String file = args[0];

//        System.out.println(new Date().toString());
//
//        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat s2 = new SimpleDateFormat("HH:mm:ss");
//        Date date = new Date();
//
//        String s = s1.format(date).toString() + "T" + s2.format(date).toString();
//        System.out.println(s);

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
     * ---
     *
     * @param path
     */
    public static void lines(Path path) {

        try {


            String name = path.getParent().getFileName().toFile().getName();

            String line = Files.lines(path).findFirst().orElse("");

            String ss = line.replace("#", "");
            if (ss.startsWith(" ")) {
                ss = ss.substring(1, ss.length());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("---\n");
            sb.append("title: \"" + name + "/" + ss + "\"" + "\n");
            //sb.append("date:");
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
