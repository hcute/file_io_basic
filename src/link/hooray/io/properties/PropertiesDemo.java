package link.hooray.io.properties;


import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Properties 集合
 *      extends Hashtable extends Map
 *      store方法将内存中的数据存储到文件
 *      load将文件中的内容加载到内存中
 *      key和value 默认都是字符串
 */
public class PropertiesDemo {
    public static void main(String[] args) throws Exception {
//        show01();
//        show02();
        showLoad();
    }

    /**
     * Object	setProperty(String key, String value)
     * String	getProperty(String key) // 返回key对应的value
     * Set<String>	stringPropertyNames() //返回key的集合
     */
    private static void show01(){
        Properties properties = new Properties();
        properties.setProperty("赵丽颖","168");
        properties.setProperty("迪丽热巴","165");
        properties.setProperty("古力娜扎","160");

        Set<String> strings = properties.stringPropertyNames();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next +" =" + properties.get(next) );
        }
    }

    /**
     * store方法
     *
     *      void	store(OutputStream out, String comments) // 字节输出流，不能使用中文，可能出现乱码
     *      void	store(Writer writer, String comments) // 字符输出流，可以使用中文
     *
     *      参数
     *          comments：说明，不能使用中文
     */
    private static void show02() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("赵丽颖","168");
        properties.setProperty("迪丽热巴","165");
        properties.setProperty("古力娜扎","160");

        FileWriter fileWriter = new FileWriter(new File("/Users/mac/IdeaProjects/file_io_basic/prop.txt"));
        properties.store(fileWriter,"");
        fileWriter.close();

    }

    /**
     * 默认键值对的连接符号一般使用=或者空格
     * 可以使用#进行注解
     * 存储的键和值都是字符串，不需要用引号
     * void	load(InputStream inStream) // 字节输入流，不能读取含有中文的字符串
     * void	load(Reader reader) // 字符输出流，可以读取含有中文的字符串
     * void	loadFromXML(InputStream in)
     */
    private static void showLoad() throws Exception {
        Properties prop = new Properties();
        FileReader fr = new FileReader(new File("/Users/mac/IdeaProjects/file_io_basic/prop.txt"));
        prop.load(fr);
        Set<String> strings = prop.stringPropertyNames();
        for (String key : strings) {
            System.out.println(key +"=" + prop.get(key));
        }
        fr.close();

    }
}
