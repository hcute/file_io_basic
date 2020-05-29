package link.hooray.io.buffer;

import java.io.*;

/**
 * 对比使用缓冲流和不使用缓冲流的复制文件的效果
 */
public class CopyFileDemo {

    public static void main(String[] args) {
//        copyFileBasic(); //770毫秒
        copyFileByBuffer(); // 1毫秒
    }

    private static void copyFileByBuffer() {
        File inFile = new File("/Users/mac/Downloads/产品图片/1.jpg");
        File outFile = new File("/Users/mac/Downloads/产品图片/2.jpg");
        try (
                FileInputStream fis = new FileInputStream(inFile);
                FileOutputStream fos = new FileOutputStream(outFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                final BufferedOutputStream bos = new BufferedOutputStream(fos);
        ){
            long start = System.currentTimeMillis();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes);
            }
            long end = System.currentTimeMillis();
            System.out.println("共计耗时："+ (end - start) + "毫秒");
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void copyFileBasic() {
        File inFile = new File("/Users/mac/Downloads/产品图片/1.jpg");
        File outFile = new File("/Users/mac/Downloads/产品图片/2.jpg");
        try (
                FileInputStream fis = new FileInputStream(inFile);
                FileOutputStream fos = new FileOutputStream(outFile)
                ) {
            long start = System.currentTimeMillis();
            int len = 0;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }
            long end = System.currentTimeMillis();
            System.out.println("共计耗时："+ (end - start) + "毫秒");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}
