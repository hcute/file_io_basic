package link.hooray.io.buffer;

import java.io.*;

/**
 * 字符缓冲输出流 BufferedWriter
 * BufferedWriter(Writer out)
 * BufferedWriter(Writer out, int sz)
 *
 * 特有的方法
 *      void	newLine()
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/mac/IdeaProjects/file_io_basic/4.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < 10; i++) {
            bw.write("传智播客");
//            bw.write("\r");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
