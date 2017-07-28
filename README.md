## Eclipse/Java/Papyrus插件使用与SysML预先研究

### 工程目的：

介绍SysML系统建模语言的基本特点，完成SysML模型在Papyrus插件上的完整应用流程。包括SysML各类图的建立与关联，行为图的有效化与模型的执行运行，定制的模型行为如何嵌入Papyrus环境等，并通过一个或多个具体项目的构建进行解释。



### 项目内容

工程的文档主要包括Papyrus SysML Explore系统建模语言探究、Species Competition Model种群竞争问题建模、Reference主要参考文献和Tutorial建模教程组成。系统建模语言探究文档的依赖文件有各章节引用的图片、可执行代码和示例系统模型；种群竞争问题的文件中包括可执行Java代码及其仿真模型。

```java
Java-Eclipse-Papyrus/
├── Papyrus SysML Explore/
│   ├── Images-Chap1
│   ├── Images-Chap2
│   ├── Caculator test-DecisionNode Test
│   ├── CarStatistics-Examples Model
│   ├── BasicActive-Executable UML
│   ├── IncrementalClass-Executable SysML
│   └── Incremental-Reverse Engineering
├── Species Competition Model/
│   ├── SpeciesRelation-Executable Java
│   ├── SpeciesCompetition-Executable SysML
│   └── Images-Model
├── Reference
└── Tutorial
```



### 部署环境

1. 项目基于Eclipse Java EE IDE for Web Developers平台上，Version: Neon.3 Release；

2. 安装[Papyrus UML Modeller(2.0)](https://www.eclipse.org/papyrus/download.html)，它能够和Eclipse Neon完美配合，请务必一同选择SysML相关组件；

   ​	可以参考[Papyrus_User_Guide](https://wiki.eclipse.org/Papyrus_User_Guide#Create_a_new_Model)，阅读这个指南，通过Papyrus来建立一个模型

3. 如需要对模型进行仿真，请安装Papyrus 上的[Moka(2.0)](http://download.eclipse.org/modeling/mdt/papyrus/components/moka/neon)工具，你可以在Addition Components上找到它；

   ​	参考[ModelExecution](https://wiki.eclipse.org/Papyrus/UserGuide/ModelExecution)，指导如何让模型正常地运行起来

4. 完成Java代码与SysML模型之间的相互转换，请安装[Java reverse engineering](http://download.eclipse.org/modeling/mdt/papyrus/components/designer/)，逆向工程能够自动地完成它；

5. 搭建模型时建议使用SysML1.4，相关指导参见此处[文档](http://www.omg.org/spec/SysML/1.4/)。





### 此处开始

[Papyrus SysML Explore.md](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore.md)

License:Copyright @LiuHenglee. Released under AOSSCI.



### 相关链接

一直在在更新的Papyrus视频教程[[Papyrus Youtube channel](https://www.youtube.com/playlist?list=PL9nkS1KDTMm7XBenuBonLyAch1xFXiiuw)]，建议观看

Papyrus源代码位于Eclipse Git代码仓库,参见[链接](https://git.eclipse.org/c/?q=papyrus)，有需要可以进行下载

