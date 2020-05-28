package link.hooray.file;

import java.io.File;
import java.io.IOException;

public class Demo05File {

    public static void main(String[] args) throws IOException {
        show03();
    }

    /**
     * boolean delete()
     *      删除文件或文件夹,
     *          文件或文件删除不成功，返回false
     *          文件夹中有内容删除不成功，返回false
     *          删除不走回收站
     */
    private static void show03() {
        File file = new File("/Users/mac/IdeaProjects/file_io_basic/src/link/hooray/file/aaa/bbb/ccc");
        boolean delete = file.delete();
        System.out.println(delete);

        File f1 = new File("/Users/mac/IdeaProjects/file_io_basic/src/link/hooray/file/1.txt");
        boolean b1 = f1.delete();
        System.out.println(b1);
    }

    /**
     * boolean createNewFile();
     *      文件不存在，返回true
     *      文件存在，返回false
     *      只能创建文件不能创建文件夹
     *      创建文件的路径必需存在，否则会抛出异常
     */
    private static void show01() throws IOException {
        File file = new File("/Users/mac/IdeaProjects/file_io_basic/src/link/hooray/file/1.txt");
        boolean newFile = file.createNewFile();
        System.out.println(newFile);

        File file1 = new File("2.txt");
        boolean success = file1.createNewFile();
        System.out.println(success);
    }

    /**
     * boolean makeDir()
     *      只能创建单级文件夹，创建的是空文件夹
     *          文件夹不存，则创建文件夹返回true
     *          文件夹存在，则不创建文件返回false
     *          文件夹的路径不存在返回false
     * boolean makeDirs()
     *      创建多级文件夹
     */
    private static void show02(){

        File f1  = new File("/Users/mac/IdeaProjects/file_io_basic/src/link/hooray/file/aaa");
        f1.mkdir();


        File f2 = new File("/Users/mac/IdeaProjects/file_io_basic/src/link/hooray/file/aaa/bbb/ccc");
        f2.mkdirs();

    }


}
