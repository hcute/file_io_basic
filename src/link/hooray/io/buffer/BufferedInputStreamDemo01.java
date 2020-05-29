package link.hooray.io.buffer;

import java.io.*;

/**
 * BufferedInputStream 字节缓冲输入流
 * 构造方法
 *      BufferedInputStream(InputStream is);
 *      BufferedInputStream(InputStream os, int size);
 * 使用步骤
 *      1，创建基本的字节输入流
 *      2，创建缓冲输入流
 *      3，调用read方法
 *      4，释放资源
 */
public class BufferedInputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis =
                new FileInputStream(new File("/Users/mac/IdeaProjects/file_io_basic/buffered.txt"));

        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }
}
