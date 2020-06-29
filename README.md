

# MybatisStudy

Mybatis学习资料总结

Mybatis框架使用例子大全+简易mybatis框架
[更多实用知识合集连接](https://www.gameboys.cn)



另外，项目里面附了一个简易mybatis的框架，用于学习

## 项目简介：
simplebatis为笔者理解mybatis的产物，通过学习mybatis的使用，然后自己亲自写一个简易orm框架，加深印象，也能理解mapper中的很多设定，例如：
mapper中为啥需要resultMap，typeHandler？
为啥需要把mapper注册到config呢？
为啥返回的对象bean里面必须有set方法？
为啥mybatis需要配置jdbc？
为啥？？？
以上问题其实你如果亲身去设计mybatis，应该能理解，这些框框条条，目的就是告诉框架一些必要的东西，不然在执行的时候由于条件缺失而无法正确执行。
至于缓存，插件==，这些在mybatis基础上面衍生的新功能目的就是增强mybatis的作用。
最后说明，mybatis和spring一样，都是超级优秀的框架，每次阅读源码都会有很深的感触，每一个分支都处理得这么完美！


## 依赖：
该简易框架只需要依赖jdk1.7+

## 目的：
为了演示mybatis的核心流程，很多对象未做缓存，也未对异常做处理，目的是理解，并非代替mybatis。


## 注意：
xml配置改成了注解SqlLogicAnno

数据库的jdbc操作这里使用一个模拟数据库SimulateDatabase来代替，方便演示。

最核心的方法在MapperMethod里面的execute方法

例子只演示了insert和selectOne两种操作，其他的可以自行拓展execute方法。。。









