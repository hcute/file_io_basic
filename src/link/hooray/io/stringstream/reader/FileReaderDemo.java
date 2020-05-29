package link.hooray.io.stringstream.reader;

import java.io.File;
import java.io.FileReader;

/**
 * FileReader extends InputStreamReader extends Reader
 * 以字符的方式将文件中的内容读取到内存中
 * 构造方法
 *      FileReader(File file)
 *      FileReader(String fileName)
 *          构造方法的作用
 *              创建FileReader对象，并将FileReader 指向指定的文件
 */
public class FileReaderDemo {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(new File("/Users/mac/IdeaProjects/file_io_basic/1.txt"));
//        int len = 0;
//        while ((len =fileReader.read()) != -1) {
//            System.out.print((char)len);
//        }
        char[] cs  = new char[1024];
        int len  = 0;
        while ((len = fileReader.read(cs)) != -1) {
            System.out.println(new String(cs));
        }
    }
}
