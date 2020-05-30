package link.hooray.io.stringstream.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter extends OutputStreamWriterDemo extends Writer
 * 把内存中的字符数据写入到文件中，
 * 构造方法
 *      FileWriter(File file)
 *      FileWriter(File file, boolean append)
 *      FileWriter(FileDescriptor fd)
 *      FileWriter(String fileName)
 *      FileWriter(String fileName, boolean append)
 *
 *      作用
 *          会创建 FileWriter 对象
 *          会根据构造方法中的路径创建文件
 *          会把FileWriter对象指向创建的文件
 * 基本使用
 *      构造 FileWriter
 *      将FileWriter中的write方法，把数据写入到内存缓冲去中，将字符流转换成字节流的过程  ---> 这里需要特别注意
 *      使用flush方法将缓冲区内的数据刷新到文件中
 *      释放资源
 *
 * 其他写数据的方法
 *      void	write(char[] cbuf)
 *      void	write(char[] cbuf, int off, int len)
 *      void	write(String str)
 *      void	write(String str, int off, int len)
 *
 *
 * 续写和换行
 *      FileWriter(File file, boolean append) // 续写
 */
public class FileWriterDemo {

    public static void main(String[] args) throws IOException {
//        basic();
//        otherMethod();
        goonWrite();
    }

    private static void basic() throws IOException {
        FileWriter fw = new FileWriter(new File("/Users/mac/IdeaProjects/file_io_basic/3.txt"));
        fw.write(97);
        fw.flush();
        fw.close();
    }

    private static void otherMethod() throws IOException{
        FileWriter fw = new FileWriter(new File("/Users/mac/IdeaProjects/file_io_basic/3.txt"));
        char[] chars = {'你', '好', '中', '国'};
        fw.write(chars);
        fw.write(chars,2,2);
        fw.write(",加油！");
        fw.write("我爱你",1,2);
        fw.flush();
        fw.close();
    }

    private static void goonWrite() throws IOException{
        // 续写的构造方法
        FileWriter fw = new FileWriter(new File("/Users/mac/IdeaProjects/file_io_basic/3.txt"),true);
        fw.write(",go on");
        // 换行 linux \n windows \r\n mac \r
        fw.write("\r");
        fw.write("hello");
        fw.flush();
        fw.close();

    }
}
