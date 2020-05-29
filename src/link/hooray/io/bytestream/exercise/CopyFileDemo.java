package link.hooray.io.bytestream.exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFileDemo {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream(new File("/Users/mac/Downloads/产品图片/1.jpg"));

        FileOutputStream fos = new FileOutputStream(new File("/Users/mac/Downloads/产品图片/2.jpg"));

        byte[] bytes = new byte[1024];

        int len = 0;
        while ( (len = fis.read(bytes)) != -1) {
            fos.write(bytes);
        }
        fos.close();
        fis.close();
    }
}
