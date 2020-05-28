package link.hooray.file;

import java.io.File;

/**
 * boolean	exists()
 *      Tests whether the file or directory denoted by this abstract pathname exists.
 *      判断文件或者文件夹是否真实存在
 * boolean	isDirectory()
 *      Tests whether the file denoted by this abstract pathname is a directory.
 *      判断File是否以文件夹结尾
 * boolean	isFile()
 *      Tests whether the file denoted by this abstract pathname is a normal file.
 *      判断File是否以文件结尾
 *
 *      isFile 和 isDirectory 是互斥方法，但是在文件路径不存在的情况下，都返回false
 *      所以最好先调用exists方法之后再调用这两个方法
 */
public class Demo04File {

    public static void main(String[] args) {

//        show01();
        show02();
    }

    /**
     * 测试 exists 方法
     */
    private static void show01() {
        File f1 = new File("/Users/mac/IdeaProjects/file_io_basic/1.txt");
        boolean f1_exists = f1.exists();
        System.out.println(f1_exists);

        File f2 = new File("/Users/mac/IdeaProjects/file_io_basic");
        boolean f2_exists = f2.exists();
        System.out.println(f2_exists);

    }

    /**
     * 测试 isDirectory
     */
    private static void show02(){
        // 这种情况下 文件不存在，即使是文件isFile也返回false，同样，如果是文件夹不存在，isDirectory 也返回false，所以最好先调用exists
        File f1 = new File("/Users/mac/IdeaProjects/file_io_basic/1.txt");
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        f1 = new File("/Users/mac/IdeaProjects/file_io_basic");

        if (f1.exists()) {
            System.out.println(f1.isFile());
            System.out.println(f1.isDirectory());
        }
    }

}
