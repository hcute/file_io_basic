package link.hooray.file;

import java.io.File;

/**
 * java.io.File 类
 * 文件和目录的抽象表示形式
 * java把电脑中的文件和文件夹（目录）封装成了一个File类，我们可以使用File对文件和文件夹进行操作
 * 可以使用File的方法
 *  创建一个文件或者文件夹
 *  删除文件或者文件夹
 *  获取文件或者文件夹
 *  判断文件或文件夹是否存在
 *  对文件夹进行便利
 * File 是和操作系统无关的类，任何操作系统都可以使用File类
 * 重点：记住三个单词
 *  File 文件
 *  Directory 文件夹/目录
 *  Path 路径
 */
public class Demo01File {
    public static void main(String[] args) {
//        static String	pathSeparator
//        The system-dependent path-separator character, represented as a string for convenience.
//        static char	pathSeparatorChar
//        The system-dependent path-separator character.
//        static String	separator
//        The system-dependent default name-separator character, represented as a string for convenience.
//        static char	separatorChar
//        The system-dependent default name-separator character.
        // 操作路径不能指定 / 或者  \
        String pathSeparator = File.pathSeparator; // 路径分隔符 windows ; linux :
        System.out.println(pathSeparator);
        char pathSeparatorChar = File.pathSeparatorChar;
        System.out.println(pathSeparatorChar);
        String separator = File.separator; // 文件名称分隔符 windows \ linux /
        System.out.println(separator);
    }
}
