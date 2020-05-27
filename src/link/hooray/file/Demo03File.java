package link.hooray.file;

import java.io.File;

public class Demo03File {
    public static void main(String[] args) {
        show04();
    }

    /**
     * long	length()
     *       Returns the length of the file denoted by this abstract pathname.
     *       返回文件的大小，不能返回文件夹的大小，如果是文件夹返回的大小为0，如果文件不存在，返回的大小也是0
     */
    private static void show04() {
        File file = new File("/Users/mac/Desktop/1.jpg");
        File f2 = new File("/Users/mac/Desktop/1.png");
        File f3 = new File("/Users/mac/IdeaProjects/file_io_basic");
        System.out.println(file.length());
        System.out.println(f2.length());
        System.out.println(f3.length());

    }

    /**
     * String	getName()
     *       Returns the name of the file or directory denoted by this abstract pathname.
     *       获取文件末尾的字符串，文件返回文件名，文件夹返回最后一级文件夹名称
     */
    private static void show03() {
        File f1 = new File("/Users/mac/IdeaProjects/file_io_basic/1.txt");
        System.out.println(f1.getName());
        File f2 = new File("/Users/mac/IdeaProjects/file_io_basic");
        System.out.println(f2.getName());
    }

    /**
     * String	getPath()
     *   Converts this abstract pathname into a pathname string.
     *   返回构造函数中传入的字符串
     */
    private static void show02() {
        File f1 = new File("/Users/mac/IdeaProjects/file_io_basic/1.txt");
        System.out.println(f1.getPath());
        File f2 = new File("1.txt");
        System.out.println(f2.getPath());
    }

    /**
     * String	getAbsolutePath()
     *      Returns the absolute pathname string of this abstract pathname.
     *      输出构造函数中的路径，无论构造传入的是什么都返回绝对路径
     */
    private static void show01() {
        File f1 = new File("/Users/mac/IdeaProjects/file_io_basic/1.txt");
        System.out.println(f1.getAbsolutePath());
    }
}
