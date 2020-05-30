package link.hooray.io.objectstream;

import java.io.Serializable;

/**
 *
 */
public class Person implements Serializable {

    /*
        反序列化的时候会比较文件中的serialVersionUID 和 class 中的文件中serialVersionUID进行比较，
        建议手动添加serialVersionUID，防止反序列化的时候抛出InvalidClassException
     */
    private static final long serialVersionUID = 8846548369456179680L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
