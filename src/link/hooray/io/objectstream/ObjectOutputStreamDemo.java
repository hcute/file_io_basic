package link.hooray.io.objectstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ObjectOutputStream 是一个字节流，将对象写入到文件中，序列化到文件
 *
 * 构造方法
 *      ObjectOutputStream(OutputStream os);
 *
 * 特有的成员方法
 *      writeObject(Object obj);
 */
public class ObjectOutputStreamDemo {

    public static void main(String[] args) {

        try (ObjectOutputStream oos
                    = new ObjectOutputStream(new FileOutputStream(new File("person.txt")))){
            Person hooray = new Person("hooray", 35);
            oos.writeObject(hooray);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
