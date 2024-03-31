### JAVA基本概念  
类(Class)
> - 包含属性、方法  
> - 属性定义了对象的状态，而方法定义了对象可以执行的操作
> - 不占据内存空间，只是一个描述对象的规范
 
对象/实例(Object/Instance) 
> 对象是根据类创建的可操作实体

继承（Inheritance）
>继承是指一个类可以派生出另一个类，派生类继承了父类的属性和方法。通过继承，子类可以重用父类的代码，并可以扩展或修改其功能。

多态（Polymorphism）
> 多态是指同一个方法可以在不同的对象上产生不同的行为。它通过方法的重写和方法的重载来实现。多态提供了灵活性和可扩展性，使得代码更加通用和可维护。

封装（Encapsulation）
> 封装是将数据和方法封装在一个单元（类）中，以实现信息隐藏和保护数据的安全性。通过封装，我们可以将数据隐藏起来，只提供公共的操作方法来访问数据。

抽象类（Abstract Class）
> 抽象类是指不能被实例化的类，它只能作为其他类的父类。抽象类可以包含抽象方法和非抽象方法，抽象方法没有具体的实现，而是由子类来实现。

接口（Interface）
> 接口是一种抽象的数据类型，它定义了一组方法的规范，但没有具体的实现。类可以实现一个或多个接口，并提供接口中定义的方法的具体实现。

包（Package）
> 包是用于组织和管理类的一种机制。它将相关的类放在同一个包中，以便更好地组织和管理代码。包可以提供命名空间，避免类名冲突，并提供访问控制的机制。

异常处理（Exception Handling）
> 异常处理是一种机制，用于处理程序运行过程中的异常情况。通过捕获和处理异常，可以使程序更加健壮和可靠

包 {接口、类、异常}   
类{字段、构造器（构造方法）、成员方法（方法）}
### JAVA的组成    

JVM(java虚拟机) < JRE(java运行环境) < JDK(java编程调试环境)   
JDK
1. JVM
2. 核心类库
3. 开发工具
   1. javac编译工具
   2. java运行工具
   3. jdb调试工具
   4. jhat内存分析工具

---

### JAVA基础语法
#### 关键字
- 关键字字母全部小写
- 编辑器中有高亮显示
1. class
    1. 用于定义一个类,类是Java的最基本组成单元
2.

#### 字面量(数据类型)   
##### 基本数据类型
1. 整数&小数  
   ***在java中，所有数都有符号（java中没有无符号数）***
byte[1]、short[2]、int[4]、long[8]
float[4]、double[8] 
 * 1.1默认为double类型，1.1F为float类型     
直接书写   
1. 字符串&字符   
    字符串  `""`   
    字符 char[2],unicode编码`''`   
* char和(byte、short)之间不会自动相互转换，它们计算时均转为int
* 实例：byte b1,b2;    
  byte b3=b2+b1;//错，b2+b3 为int型
1. 布尔类型
    boolean[1]
    `true`
    `false`不可用0或非0值代替  
* 布尔类型不参与自动类型转换 
1. 空类型 `null` 
* 自动类型转换：低精度->高精度
* 强制类型转换：高精度->低精度
* char类型可以保存int常量值，但不能保存int变量值，需要强制转换    
  
***其他基本数据类型和string类型的转换***   
    其他基本数据类型+"" -> string类型   
    string类型 -包装类-> 其他基本数据类型   
    * string的内容必须符合自动类型转换规则   
    parse();   
    `Double.parseDouble(str)`
    `Integer.parseInt(str)`   
    `str.charAt(0)//将字符串转为字符`
##### 引用数据类型
1. 类 class
2. 接口 interface
3. 数组 []
```java
{
import java.util.scanner;
public class Input{
    public static void main(String[] args){
        //创建Scanner对象，Scanner是类，myScanner是对象
        Scanner myScanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = myScanner.next();
        System.out.println("请输入年龄");
        int age = myScanner.nextInt();
        System.out.println("请输入薪水");
        double sal = myScanner.nextDouble();
        System.out.println("用户信息如下");
        System.out.println("姓名" + name + "年龄" + age + "薪水" + sal);
    }
}

}
```
#### \t 制表符
> 在打印时把前面的字符串长度补齐到8   

语法   
System.out.println("id"+'\t'+"123");    
#### 变量
> 数据类型 变量名 = 数据值
> 变量使用前必须赋值,否则语法错误   

### 运算
#### `\`整除   
bouble a=12\5; 
> a=2.0   

double Ftemperature=134.5;   
double Ctemperature=5/8*(Ftemperature+273.0);
> 不论Ftemperature等于多少，Ctemperature=0.0
> 因为5/8为int型=0，在之后的计算中始终是0.0*(Ftemperature+273.0)=0.0

#### `%`取模
`公式：a%b=a-a/b*b`   
double a=10%(-3);   
double b=-10%3;   
double c=-10%(-3);   
> a=1.0 b=-1.0 c=-1.0
#### 自增自减
int a=1;   
int a=a++;
>int temp=a;   
>a++;   
>a=temp;   
>结果a=1
#### 复合赋值运算符
从右往左赋值   
会进行强制类型转换
> byte b+=3; //True 
#### 三元运算符
赋值内容必须能够通过自动类型转换 
> int c = a>b ? a:b;//ab为double或float等将报错
#### 运算符优先级
> 1. .:对象运算符 、()、 {}、;、,
> 2. 单目运算符
> 3. 算数运算符
> 4. 移位运算符
> 5. 比较运算符
> 6. 逻辑运算符
> 7. 三元运算符
> 8. 赋值\复合赋值运算符

#### 标识符命名规范
1. 包名：小写字母+. 
> aaa.bbb.ccc
2. 类名、接口名：大驼峰
>BinaryTreeDataBase
3. 变量名、方法名：小驼峰
> binaryTreeSearch
4. 常量名：大写字母
>WEIGHT

### \* 补充：计算机中的数据存储   
**各进制代码表示：**    
二进制：`0b`开头   
十进制：无前缀   
八进制：`0`开头   
十六进制：`0x`开头   

### 进制转换  
**任意进制转十进制：**   
系数\*基数的权次幂 累加
**十进制转任意进制**   
除基取余法   
> 不断的除以基数得到余数，直到商为0，再将余数倒着拼起来即可   
### 编码方式
1. ASCII：1字节，可表示128个字符   
2. unicode：英文和汉字都占用2字节，unicode兼容ASCII。优点，没有乱码问题；缺点，浪费空间
3. UTF-8：变长编码方式，1-6字节，其中英文字母1字节，汉字3字节

### 控制语句
#### 分支语句
```java
if{} 
else if{} 
else{}    
switch(表达式){
    case ""://1.表达式的数据类型必须能自动转成可与case后的内容作比较的类型
    break;//2.表达式的数据类型只能是byte,short,int,char,enum枚举,String
    default://3.case子句中的值必须是常量，而不能说变量
    ;
}
```
