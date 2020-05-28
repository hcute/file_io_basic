package link.hooray.io.bytestream.input;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * 文件输入流：将硬盘文件中的数据读取到内存中
 */
public class FileInputStreamDemo {

    /*
        FileInputStream(File file)
        FileInputStream(String name)
     */
    public static void main(String[] args) throws Exception {
        String path = "/Users/mac/IdeaProjects/file_io_basic/1.txt";
        input02(path);
    }

    private static void input01(String path) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        int len = 0;
        while (( len = fis.read()) != -1) {
            System.out.println((char)len);
        }
        fis.close();
    }

    private static void input02(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        byte[] bytes = new byte[2]; // 这里一般是1024的整数倍
        int read = 0;
        while ((read = fis.read(bytes)) != -1){
            System.out.println(new String(bytes));
        }
    }
}
