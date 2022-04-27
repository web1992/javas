package cn.web1992.leet.code.文件合并;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author web1992
 * @date 2022/4/27  16:05
 */
public class MergeFile {
    public static void main(String[] args) throws IOException {
        // file1,file2,file3 需要是有序的文件
        String file1 = "/Users/zl/Documents/DEV/github/javas/leetcode/src/main/java/cn/web1992/leet/code/文件合并/f1.txt";
        String file2 = "/Users/zl/Documents/DEV/github/javas/leetcode/src/main/java/cn/web1992/leet/code/文件合并/f2.txt";
        String file3 = "/Users/zl/Documents/DEV/github/javas/leetcode/src/main/java/cn/web1992/leet/code/文件合并/f3.txt";

        List<String> fileLine1 = Files.readAllLines(Paths.get(file1));
        List<String> fileLine2 = Files.readAllLines(Paths.get(file2));
        List<String> fileLine3 = Files.readAllLines(Paths.get(file3));

        PriorityQueue<FileObj> queue = new PriorityQueue<>();

        FileObj fileObj1 = new FileObj(fileLine1);
        FileObj fileObj2 = new FileObj(fileLine2);
        FileObj fileObj3 = new FileObj(fileLine3);

        queue.offer(fileObj1);
        queue.offer(fileObj2);
        queue.offer(fileObj3);

        while (!queue.isEmpty()) {
            FileObj fObj = queue.poll();
            System.out.println("fObj= " + fObj.getCurVal());
            if (!fObj.isEnd()) {
                fObj.incCurIndex();
                queue.offer(fObj);
            }
        }

    }

    public static class FileObj implements Comparable<FileObj> {

        List<String> fileLine;
        int curIndex;
        String curVal;

        String getCurVal() {
            return fileLine.get(curIndex);
        }

        void incCurIndex() {
            this.curIndex++;
        }

        boolean isEnd() {
            return this.curIndex == this.fileLine.size() - 1;
        }

        public FileObj(List<String> fileLine) {
            this.fileLine = fileLine;
            this.curIndex = 0;
            this.curVal = fileLine.get(curIndex);
        }

        @Override
        public int compareTo(FileObj o) {
            return this.getCurVal().compareTo(o.getCurVal());
        }
    }
}
