package link.hooray.file;

import java.io.File;

public class Demo06File {

    /**
     * String[]  list()
     *      返回文件夹下的文件的名字 调用的是文件的getName()获取的文件名
     * @param args
     */
    public static void main(String[] args) {
        String path = "/Users/mac/Downloads";
        File file = new File(path);
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
        //
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1.getAbsolutePath() + File.separator +file1.getName());
        }
    }

}
