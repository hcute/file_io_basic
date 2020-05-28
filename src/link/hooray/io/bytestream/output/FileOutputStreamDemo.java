package link.hooray.io.bytestream.output;

import java.io.*;
import java.nio.charset.Charset;

/**
 * FileOutputStream : 文件输出流：把内存中的数据写入到文件中
 */
public class FileOutputStreamDemo {
    /*
        FileFileOutputStream(File file)
        FileOutputStream(String name)
    */

    /**
     * 将内存中的数据写入到文件
     * java 程序 - jvm - os - 写入数据
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String path = "/Users/mac/IdeaProjects/file_io_basic";
//        output01(path);
        output02(path);
    }

    /**
     * windows：的换行 \r\n
     * linux: \n
     * mac: \r
     * @param path
     * @throws IOException
     */
    private static void output02(String path) throws IOException {
        FileOutputStream fos  = new FileOutputStream(new File(path,"2.txt"),true);

        for (int i = 0; i < 10 ; i++) {
            fos.write("hello".getBytes("utf-8"));
            fos.write("\r\n".getBytes());
        }
        fos.close();
    }

    private static void output01(String path) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(path + File.separator + "1.txt"));
            fos.write("你好".getBytes(Charset.forName("UTF-8")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
