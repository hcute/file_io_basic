# File和IO基础
## File

### File 类的概述

- java.io.File

  - 文件和目录的抽象表示，进行创建、查找、删除等操作

- 类变量

  - 路径分隔符 pathSeparator
  - 文件分隔符 separator

- 构造方法

  ```java
  File(File parent, String child)
  // Creates a new File instance from a parent abstract pathname and a child pathname string.
  File(String pathname)
  // Creates a new File instance by converting the given pathname string into an abstract pathname.
  File(String parent, String child)
  // Creates a new File instance from a parent pathname string and a child pathname string.
  ```

- 常用方法

  - 获取功能的方法

    ```java
    String	getAbsolutePath()
    // Returns the absolute pathname string of this abstract pathname.
    String	getPath()
    // Converts this abstract pathname into a pathname string.
    String	getName()
    // Returns the name of the file or directory denoted by this abstract pathname.
    long	length()
    // Returns the length of the file denoted by this abstract pathname.
    ```

  - 判断功能的方法

    ```java
    boolean	exists()
    // Tests whether the file or directory denoted by this abstract pathname exists.
    // 判断文件或者文件夹是否真实存在
    boolean	isDirectory()
    // Tests whether the file denoted by this abstract pathname is a directory.
    boolean	isFile()
    // Tests whether the file denoted by this abstract pathname is a normal file.
    ```

  - 创建删除功能的方法

    ```java
    boolean createNewFile()
    // 当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
    // 路径不存在的时候会抛出io异常
    boolean delete()
    // 删除由此File表示的文件或目录
    // 文件夹中有数据无法删除返回false
    boolean mkdir()
    // 创建此File表示的目录
    // 创建单级目录
    boolean mkdirs()
    // 创建由此File表示的目录，包括任何必需单不存在的父目录 
    // 创建多级目录
    ```

  - 目录的遍历

    ```java
    String[]	list()
    // Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname.
    File[]	listFiles()
    // Returns an array of abstract pathnames denoting the files in the directory denoted by this abstract pathname.
      
    // 可以获取隐藏的文件或者文件夹，但是遍历的是文件或者文件夹的路径不存在的时候会抛出NullPointException
    ```

  - 过滤器的使用





## 递归

- 概述：方法自己调用自己

- 分类

  - 直接递归

    ```java
    void a(){
    	a();
    }
    ```

  - 间接递归

    ```java
    void a(){
    	b();
    }
    
    void b(){
    	c();
    }
    
    void c(){
    	a();
    }
    
    ```

- 注意事项

  - 递归一定要有结束条件，否则会发生栈内存溢出
  - 即使有结束条件，也不能递归太多次数，否则也会发生栈内存溢出
  - 构造方法不准许递归





## IO流

### 概述

> I -> input 输入 (读取)
>
> O ->output 输出(写入)
>
> 流 -> 数据（字符、字节）一个字符2个字节，一个字节8个bit

将硬盘中的数据**读取**到内存中输入，将内存中数据**写入**到硬盘上输出



|        | 输入        | 输出         |
| ------ | ----------- | ------------ |
| 字节流 | InputStream | OutputStream |
| 字符流 | Reader      | Writer       |



### 字节流

- 一切皆为字节

  数据存储在次盘上都是二进制的数据的，都是以字节为单位存储的，在数据传输的时候也是以字节的方式来读取，可以读取任意的文件

- 字节输出流 OutputStream

  - 都是按照字节的方式写入文件，可以写入一个字节和多个字节

  - 如何续写和换行

    > 换行说明：
    >
    > ​	Windows ：\n\r
    >
    > ​    Linux : \n
    >
    > ​    Mac : \r

- 字节输入流 inputStream

  