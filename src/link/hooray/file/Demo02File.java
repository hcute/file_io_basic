package link.hooray.file;

import java.io.File;

/**
 * 路径：
 *      绝对路径：是一个完整的路径，Windows以盘符开始，Linux 以 / 开始
 *      相对路径：是一个简化路径，相对于当前项目的根目录/Users/mac/IdeaProjects/file_io_basic
 *
 *
 * 注意：
 *      不区分大小写
 *      路径分隔符 windows 和  linux的区别
 */
public class Demo02File {

    public static void main(String[] args) {
        /*
         * File 类的构造方法
         */
//        show02("/Users/mac/IdeaProjects/file_io_basic","c.txt");
        show03();
    }

    /**
     * File(File parent, String child)
     *      Creates a new File instance from a parent abstract pathname and a child pathname string.
     * 好处：
     *      路径可以随时变化
     *      父路径是File 类型，可以使用File类的方法对路径进行相应的操作
     */
    private static void show03() {
        File parent = new File("/Users/mac/IdeaProjects/file_io_basic/file/parent");
        File file = new File(parent,"hello.java");
        System.out.println(file);

    }

    /**
     * File(String parent, String child)
     *      Creates a new File instance from a parent pathname string and a child pathname string.
     * 参数：
     *      String parent 父路径
     *      String child 子路径
     *
     * 好处：
     *      父路径和子路径可以单独书写，更加灵活
     */
    private static void show02(String parent,String child) {
        File file = new File(parent,child);
        System.out.println(file);
    }

    /**
     * File(String pathname)
     *         Creates a new File instance by converting the given pathname string into an abstract pathname.
     *
     *  pathname : 可以是文件或者文件夹
     *             可以是绝对路径，也可以是相对路径
     *             路径可以是存在的也可以是不存在的
     *             创建File对象，只是把字符串封装为File对象，不考虑路径的真假
     */
    public static void show01(){
        File file = new File("/Users/mac/IdeaProjects/file_io_basic/a.txt");
        System.out.println(file);
        File file1 = new File("/Users/mac/IdeaProjects/file_io_basic/file");
        System.out.println(file1);
        File file3 = new File("b.txt");
        System.out.println(file3);
    }

}
