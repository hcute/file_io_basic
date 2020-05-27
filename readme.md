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

    

