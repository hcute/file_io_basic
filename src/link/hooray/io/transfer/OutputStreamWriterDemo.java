package link.hooray.io.transfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 父类是Writer 是一个字符流
 *
 * 构造方法
 *      OutputStreamWriterDemo(OutputStream out)
 *      创建一个使用默认字符编码的OutputStreamWriter。
 *      OutputStreamWriterDemo(OutputStream out, String charsetName)
 *      创建一个使用命名字符集的OutputStreamWriter。字符集不区分大小写
 *
 * 使用步骤
 *      1，创建一个OutputStreamWriter，构造中传入字节输出流，指定编码字符集
 *      2，使用OutputStreamWriter的write方法，将字符转换成字节存储到缓冲区中
 *      3，调用flush 将缓冲区中的内容写入文件
 *      4，释放资源
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {

//        write_utf_8();
        write_gbk();

    }

    private static void write_gbk() throws IOException{
        FileOutputStream fos = new FileOutputStream("5.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        osw.write("你好");
        osw.flush();
        osw.close();
    }

    /**
     * 使用OutputStreamWriter转换流写入utf-8的数据到文件
     */
    private static void write_utf_8() throws IOException  {
        FileOutputStream fos = new FileOutputStream("5.txt");
//        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("你好");
        osw.flush();
        osw.close();
    }

}
