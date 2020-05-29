package link.hooray.io.stringstream.write;

import java.io.*;

/**
 * jdk1.7 之前
 *      try {
 *          可能产生异常的代码
 *      }catch(Exception e) {
 *          异常处理逻辑
 *      }finally{
 *          if(fw !=null) {
 *              释放资源
 *          }
 *
 *      }
 *
 *  jdk1.7 之后 包含jdk1.7
 *     try() {
 *
 *     }catch(Exception e) {
 *
 *     }
 *  jdk1.9 => 这种还需要抛出异常
 *     InputStream is  = new InputStream();
 *     OutputStream os  = new OutputStream();
 *     try (is;os) {
 *
 *     }catch(Exception e){
 *
 *     }
 *
 */
public class FileWriterDemoException {
    public static void main(String[] args) {
//        basicException();
        showJdk17Exception();
    }

    private static void basicException() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("/Users/mac/IdeaProjects/file_io_basic/3.txt"),true);
            for (int i = 0; i < 10; i++) {
                fw.write("hello\r");
            }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void showJdk17Exception(){
        try (
                FileInputStream fis = new FileInputStream(new File("/Users/mac/Downloads/产品图片/1.jpg"));
                FileOutputStream fos = new FileOutputStream(new File("/Users/mac/Downloads/产品图片/2.jpg"));
                ){
            byte[] bytes = new byte[1024];
            int len = 0;
            while ( (len = fis.read(bytes)) != -1) {
                fos.write(bytes);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 以下代码需要在jdk9的环境下才能运行，一般用jdk7的新特性来处理就可以了
//    private static void showJdk19Exception() throws IOException{
//        FileInputStream fis = new FileInputStream(new File("/Users/mac/Downloads/产品图片/1.jpg"));
//        FileOutputStream fos = new FileOutputStream(new File("/Users/mac/Downloads/产品图片/2.jpg"));
//        try (fis;fos){
//            byte[] bytes = new byte[1024];
//            int len = 0;
//            while ( (len = fis.read(bytes)) != -1) {
//                fos.write(bytes);
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
