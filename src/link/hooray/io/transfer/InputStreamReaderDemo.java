package link.hooray.io.transfer;

import java.io.*;

/**
 * InputStreamReader extends Reader 解码的过程
 *
 * 构造方法
 *      InputStreamReader(InputStream in)
 *      创建一个使用默认字符集的InputStreamReader。
 *      InputStreamReader(InputStream in, String charsetName)
 *      创建一个使用命名字符集的InputStreamReader。
 */
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {
        read_utf_8();
        System.out.println("=======");
        read_gbk();
    }

    private static void read_gbk() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("5.txt")),"gbk");
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.print((char)len);
        }
    }

    private static void read_utf_8() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("4.txt")));
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.print((char)len);
        }
    }
}
