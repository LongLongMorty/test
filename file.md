>最近学习了java中的文件，在学C的时候我就没学好这一节，可能是在日常的使用比较少。
>我写下这篇文章方便自己日后的复习。  
***
 

 ![这是图片](https://img-blog.csdnimg.cn/94f0b3cdca814bd4a89af4f5b5c83cac.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBASGVsbG8gV29ybGQ3MQ==,size_20,color_FFFFFF,t_70,g_se,x_16)  
 
  这是InputStream类所有类的超类，我们一般只会用到 close(),和两个read()方法;

1.int read():读取一个字节，返回读取的字节,读到最后没有数据时，返回-1;

2.close():关闭流资源

---------------------------------------------------------------------------------------------------------------------------------
**下面这是最常见的创建方式**  

我们的文件  

![图片alt](https://img-blog.csdnimg.cn/b3dae9aca35342089d490f6175272079.png)  

```java  

 FileInputStream fileInputStream = new FileInputStream("src//LLL")  

 //创建一个输入的类，后面括号中的是文件的路径  

 //这里也可以是"D:......."这种路径，但是要注意"\"需要写成"\\"(转义字符)  

 int num = fileInputStream;  

 while(num != -1){  
  
 System.out.println((char)num);  
  
 }  

fileInputStream.close();  
```
***
但是我们在创建的时候常常会报错，因为是IOException类型的错误，我们必须要进行处理，  

还有一个问题就是我们在打开文件后必须要进行关闭，但是我们会很容易忘记，综合这两个需求  


我设计了一种更好的模式  

```java
FileInputStream fileInputStream = null;  

        try {  
          
            int a;  
          
            fileInputStream = new FileInputStream("src//LLL");//优化了一下while()  
          
            while ((a = fileInputStream.read()) != -1) {  
              
                System.out.println((char) a);//类型转化一下  
              
            }  
          
        } catch (IOException e) {  
          
            e.printStackTrace();  
          
        }finally {  
          
            try {  
              
                if(fileInputStream != null)//将close()放入finally,保证一定会执行  
                  
                    fileInputStream.close();  
              
            }catch (IOException a){  
              
                a.printStackTrace();  
              
            }  
          
//为什么这么多try...catch,因为文件处理就是这样的，多用几个try...catch就好了  

```
*** 
**下面介绍一下read(byte[] bytes) 的使用**  

在此之前，我们先要了解一下String 的下面这个构造方法（下面为API中的解释）  


    > String(byte[] bytes)
 
    > 通过使用平台的默认字符集解码指定的字节数组来构造新的 String

    > 通俗的来说就是，将byte[]转化为String类型

 
```java
FileInputStream fileInputStream = null;  

        byte[] bytes = new byte[4];//数组大小就是一次要读入的数量  

        try {  
          
            int a;  
          
            fileInputStream = new FileInputStream("src//LLL");  
          
        //返回值：文件剩余有4个就是返回4；不足4个就返回剩余量；一个也没有就返回-1  
          
            while ((a = fileInputStream.read(bytes)) != -1) {   
              
                System.out.printf(new String(bytes));  
              
            }
        } catch (IOException e) {  
          
            e.printStackTrace();  
          
        }finally {  
          
            try {  
              
                if(fileInputStream != null)  
                  
                    fileInputStream.close();  
              
            }catch (IOException a){  
              
                a.printStackTrace();  
              
            }  
          
        }  
```  

**这种方法还是会有一个问题，这和读入时字符在byte[ ]中的储存方式有关**

 所以输出结果会是 ：  
 
```java
abcdefcd  
```  

所以我们又进行了优化（引入另一个String 构造器）：  

```java
    String(byte[] bytes, int offset, int length)  
```
    通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。  
    
>    offset 表示你输出的起始位置

>    length 表示输出长度  

```java
import java.io.*;  

/**  

 * @author LongLongMorty  
 
 * @version 1141514  
 
 */  

public class Main {  
  
    public static void main(String[] args) {  
      
        FileInputStream fileInputStream = null;  
      
        byte[] bytes = new byte[4];  
      
        try {  
          
            int a;  
          
            fileInputStream = new FileInputStream("src//LLL");  
          
            while ((a = fileInputStream.read(bytes)) != -1) {  
              
                System.out.printf(new String(bytes,0,a));  
              
            }   
          
        } catch (IOException e) {  
          
            e.printStackTrace();  
          
        }finally {  
          
            try {  
              
                if(fileInputStream != null)  
                  
                    fileInputStream.close();  
              
            }catch (IOException a){  
              
                a.printStackTrace();  
              
            }  
          
        }  
      
    }  
  
}  

```
 ~第一次写这么长的文章，有点费时间啊。~
​
