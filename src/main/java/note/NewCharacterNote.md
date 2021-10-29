### **序言**

面试官经常会问到新版JDK新的特性， 尤其是JDK8的特性。

下面将首先讲解JDK版本发布情况，概括性介绍JDK8的主要新的特征。

主要包括：

- 新的语言特性
- 集合对象的修改
- JVM新特性
- HashMap的修改

###   关注私信，回复***JDK文档\*** 获取JDK官方文档。

### **为什么面试经常问JDK8新的特性**

JDK8是2014年3月发行版本， 面试官会在面试中问JDK8的一些新的特性。

Java从已经从JDK1.0版本发展到了最新的JDK13, 为什么目前Jdk8经常被问到呢？

大概有一些原因：

第一、JDK8仍然是最受欢迎的JDK版本。

从skyn网站的**[《2018年JVM生态报告》](https://zhuanlan.zhihu.com/p/110858204/生态报告https://snyk.io/blog/jvm-ecosystem-report-2018/)**中可以看到截止到2018年， JDK8仍然是生成环境使用最多的JDK版本。



![img](https://pic2.zhimg.com/v2-e5fd07c34b8239804fa47381abd40a69_b.jpg)

 第二、新的发版周期，让很多公司无所适从。JDK9非LTS版本。

JDK8之后Oracle使用了新的发布周期。

![img](https://pic4.zhimg.com/v2-dcff0c006f30a99949171afe9ca9a257_b.jpg)

见**[《javaSE support roadMap》》](https://www.oracle.com/java/technologies/java-se-support-roadmap.html)**

从JDK版本历史发行看， Oracle从Java9开始实行了新的版本发布规则，缩短了新版本发布周期。

JDK1.6到JDK1.7经过了5年的时间

JDK1.7到JDK1.8经过了3年

JDK1.8到JDK1.9经过了3年

之后的版本 每6个月发布一个版本

每3年发布一个LTS版本（最新的LTS版本是JDK11）

![img](https://pic3.zhimg.com/v2-d746b6b165f842a60df6643ef613343a_b.jpg)

几乎 **三分之一** 的开发人员还不知道他们将如何应对新的发布周期。

第三、JDK8 引入了很多非常实用和长期的影响

1. JDK8引入新的语法特性，比如Lambda表达式，默认方法，方法引用，新增新的日期处理类
2. JDK8为Collection新增Stream流式接口， 修改HashMap和ConcurrentHashMap实现
3. JDK8修改了JVM内存模型， 实用metaSpace代替永久代
4. JDK新增并发接口和实现， 包括新增CompletableFuture、为ConcurrentHashMap新增支持Stream方法、新增StampedLock

下面介绍几个面试过程经常被问到的几个新特性

### **Lambda表达式、方法引用和默认方法**

**1. Lambda表达式**

Lambda表达式允许把函数作为一个方法的参数。

有几种常见的Lambda表达式：

```text
// 1. 不需要参数,返回值为 5  
() -> 5  
  
// 2. 接收一个参数(数字类型),返回其2倍的值  
x -> 2 * x  
  
// 3. 接受2个参数(数字),并返回他们的差值  
(x, y) -> x – y  
  
// 4. 接收2个int型整数,返回他们的和  
(int x, int y) -> x + y  
  
// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)  
(String s) -> System.out.print(s)
```

**2. 方法引用**

JDK8支持了四种方式方法引用

**类型方法引用**引用静态方法ContainingClass::staticMethodName引用特定对象的实例方法containingObject::instanceMethodName引用特定类型的任意对象的实例方法String::compareToIngoreCase引用构造函数ClassName::new

**3. 默认方法和静态方法**

JDK1.8支持在接口中定义默认方法和静态方法， 默认方法可以被接口实现引用。

```text
package defaultmethods;
 
import java.time.*;

public interface TimeClient {
    void setTime(int hour, int minute, int second);
    void setDate(int day, int month, int year);
    void setDateAndTime(int day, int month, int year,
                               int hour, int minute, int second);
    LocalDateTime getLocalDateTime();
    
    // 静态方法
    static ZoneId getZoneId (String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString +
                "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }
    
    // 默认方法
    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
}
```

### **Colletion的修改**

JDK1.8增强了Collection FrameWork， 支持了lambda， 流和聚合操作。

## **改动有两个方面：**

- 支持了lambda， 流和聚合操作
- 改进的类型推断

**改进的类型推断**

Java编译器利用目标类型来推断通用方法调用的类型参数。

考虑以下示例：

```text
List <String> stringList = new ArrayList <>（）;
stringList.add（"A"）;
stringList.addAll（Arrays.asList（））;
```

Java管理扩展（JMX）提供了对诊断命令的远程访问。

目前，不考虑泛型，该方法addAll将Collection实例作为其参数，然后该方法Arrays.asList返回一个List实例。这是有效的，因为List是的子类型Collection。

现在考虑泛型，的目标类型addAll为Collection<? extends String>，并Arrays.asList返回一个List实例。在此示例中，Java SE 8编译器可以推断类型变量的T值为String。编译器从目标类型推断出这一点Collection<? extends String>。

Java SE 7和更早版本的编译器不接受此代码，因为它们不使用目标类型来推断方法调用参数的类型。例如，Java SE 7编译器生成类似于以下内容的错误消息：

```text
error: no suitable method found for addAll(List<Object>) ...
method List.addAll(Collection<? extends String>) is not applicable (actual argument List<Object> cannot be converted to Collection<? extends String> by method invocation conversion)
```

因此，在Java编译器无法推断类型的情况下，必须使用显式指定类型变量的值。例如，以下在Java SE 7中有效：

```text
List <String> stringList = new ArrayList <>（）;
stringList.add（“ A”）;
stringList.addAll（Arrays.<String> asList（））;
```

### **JVM新特性**

JDK8在JVM中修改重要有：

- 新增JVM工具：jdeps提供了用于分析类文件的命令行工具。
- 使用metaSpace代替永久区
- 新增NMT(Native Memeory Trace)本地内存跟踪器，参见**[NMT](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/nmt-8.html)**

### **HashMap变化**

JDK8优化了HashMap的实现， 主要优化点包括：

- 将链表方式修改成链表或者红黑树的形式
- 修改resize的过程，解决JDK7在resize在并发场景下死锁的隐患
- JDK1.7存储使用Entry数组， JDK8使用Node或者TreeNode数组存储

当链表长度大于8是链表的存储结构会被修改成红黑树的形式。

查询效率从O(N)提升到O(logN)。链表长度小于6时，红黑树的方式退化成链表。

JDK7链表插入是从链表头部插入， 在resize的时候会将原来的链表逆序。

JDK8插入从链表尾部插入， 因此在resize的时候仍然保持原来的顺序。