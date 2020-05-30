package link.hooray.io.objectstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化集合
 *      存储多个对象的时候又想序列化对象，此时采用集合序列化
 *
 * 比如：
 *      采用ArrayList存储Person
 *      使用序列化流存储数据到文件
 */
public class ExeciseSerialCollection {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person zhangsan = new Person("zhangsan", 12);
        Person hooray = new Person("hooray", 14);
        list.add(zhangsan);
        list.add(hooray);
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("persons.txt")));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("persons.txt")))
        ) {
            oos.writeObject(list);

            Object o = ois.readObject();
            List<Person> persons = (ArrayList<Person>)o;

            for (Person person : persons) {
                System.out.println(person);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
