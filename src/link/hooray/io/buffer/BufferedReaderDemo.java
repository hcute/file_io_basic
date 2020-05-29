package link.hooray.io.buffer;

import java.io.*;

/**
 * BufferedReader 字符缓冲输入流
 *  BufferedReader(Reader in)
 *  BufferedReader(Reader in, int sz)
 *
 *  特有方法
 *      readLine
 */
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/mac/IdeaProjects/file_io_basic/4.txt");
        final FileReader fileReader = new FileReader(file);
        final BufferedReader br = new BufferedReader(fileReader);

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
