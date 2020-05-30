package link.hooray.io.printstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream extends OutputStream
 *
 * 特点：
 *      只负责数据的输出，不会抛出IOException
 *      特有的方法print和println
 *      可以输出到文件或者字节输出流
 *
 * 注意实现
 *      如果要使用write方法 ，查看数据的时候会查看编码表 比如 97 -> a
 *      但是使用print和println那么会原样输出 97 -> 97
 *
 *
 * System.setOut 方法可以改变输出语句的目的地
 */
public class PrintStreamDemo {

    public static void main(String[] args) throws FileNotFoundException {
//        printVsWrite();
        changePrintDestination();
    }

    private static void printVsWrite() throws FileNotFoundException {
        PrintStream printStream = new PrintStream("7.txt");
        printStream.print(97);
        printStream.write(97);
        printStream.close();
    }

    private static void changePrintDestination() throws FileNotFoundException {
        PrintStream ps = new PrintStream("8.txt");
        System.setOut(ps);
        System.out.println("你好");
        ps.close();
    }
}
