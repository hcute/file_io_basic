package link.hooray.io.objectstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * ObjectInputStream 对象反序列化流，从文件中读取对象到内存中
 */
public class ObjectInputStreamDemo {

    public static void main(String[] args) {
        try (
                ObjectInputStream ois
                        = new ObjectInputStream(new FileInputStream(new File("person.txt")))
        ){
            Person hooray = (Person)ois.readObject();
            System.out.println(hooray);
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
