package link.hooray.io.transfer;

import java.io.*;

/**
 * 文件编码转换
 */
public class ExeciseTransfer {
    public static void main(String[] args) {
        try (
                InputStreamReader isr
                        = new InputStreamReader(new FileInputStream(new File("5.txt")),"gbk");

                OutputStreamWriter osw
                        = new OutputStreamWriter(new FileOutputStream(new File("6.txt")),"utf-8")
        ) {
            int len = 0;
            while ((len = isr.read()) != -1) {
                osw.write(len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
