package link.hooray.io.buffer;

import java.io.*;

/**
 * BufferedOutputStream
 *      构造方法
 *          BufferedOutputStream(OutputStream out)
 *              入参：FileOutputStream 可以提高写入效率，使用默认的缓冲区大小
 *          BufferedOutputStream(OutputStream out, int size)
 *              入参：int size 指定缓冲区大小
 *
 *
 *      使用步骤
 *          1，创建字节输出流 FileOutputStream 对象绑定我们需要输出的目的地
 *          2，创建缓冲流BufferedOutputStream
 *          3，使用Buffered的write将数据写入到缓冲区
 *          4，调用flush 把缓冲区数据到文件
 *          5，释放资源
 */
public class BufferedOutputStreamDemo01 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos =
                new FileOutputStream(new File("/Users/mac/IdeaProjects/file_io_basic/buffered.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("我把数据写入到缓冲区中".getBytes());
        bos.flush();
        bos.close();
    }
}
