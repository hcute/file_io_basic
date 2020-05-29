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

  - 如何续写【File的构造函数传入true】和换行

    > 换行说明：
    >
    > ​	Windows ：\n\r
    >
    > ​    Linux : \n
    >
    > ​    Mac : \r

- 字节输入流 inputStream

- 中文字符的问题

  - 如果读取的字节是GBK 编码 占用两个字节，而utf-8占3个字节，一个一个读取可能产生乱码，此时就需要使用字符流

### 字符流

- 字符输入流 Reader
- 字符输出流 Writer
  - 需要调用flush方法将内存缓冲区中的字节流刷新到文件
  - flush 和 close的区别
    - flush刷新缓冲区，流对象可以继续使用
    - close 将缓冲区中的数据刷新到文件中，通知系统释放资源，流对象被关闭，不能再使用

### 属性集

> 继承自Hashtable



### 缓冲流

- 概述

  - 都是在基本数据流的上面包装而来的
  - 目的是为了提高读取和写入的效率，给基本的字节流添加缓冲区 BufferedInputStream，BufferedOutputStream

- 分类

  - 字节缓冲输入流 BufferedInputStream
  - 字节缓冲输出流 BufferedOutputStream

- 比较实用buffer 和不使用buffer拷贝文件的效率

  ```java
  package link.hooray.io.buffer;
  
  import java.io.*;
  
  /**
   * 对比使用缓冲流和不使用缓冲流的复制文件的效果
   */
  public class CopyFileDemo {
  
      public static void main(String[] args) {
  	      copyFileBasic(); //770毫秒
          copyFileByBuffer(); // 1毫秒
      }
  
      private static void copyFileByBuffer() {
          File inFile = new File("/Users/mac/Downloads/产品图片/1.jpg");
          File outFile = new File("/Users/mac/Downloads/产品图片/2.jpg");
          try (
                  FileInputStream fis = new FileInputStream(inFile);
                  FileOutputStream fos = new FileOutputStream(outFile);
                  BufferedInputStream bis = new BufferedInputStream(fis);
                  final BufferedOutputStream bos = new BufferedOutputStream(fos);
          ){
              long start = System.currentTimeMillis();
              byte[] bytes = new byte[1024];
              int len = 0;
              while ((len = bis.read(bytes)) != -1){
                  bos.write(bytes);
              }
              long end = System.currentTimeMillis();
              System.out.println("共计耗时："+ (end - start) + "毫秒");
          }catch (IOException e){
              e.printStackTrace();
          }
  
      }
  
      private static void copyFileBasic() {
          File inFile = new File("/Users/mac/Downloads/产品图片/1.jpg");
          File outFile = new File("/Users/mac/Downloads/产品图片/2.jpg");
          try (
                  FileInputStream fis = new FileInputStream(inFile);
                  FileOutputStream fos = new FileOutputStream(outFile)
                  ) {
              long start = System.currentTimeMillis();
              int len = 0;
              while ((len = fis.read()) != -1) {
                  fos.write(len);
              }
              long end = System.currentTimeMillis();
              System.out.println("共计耗时："+ (end - start) + "毫秒");
          }catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

  

