## Eclipse/Java/Papyrus插件使用与SysML预先研究

刘恒利（成都电子科技大学），田超（傲势科技）

### 引言

Eclipse是一个孵化IDE（集成开发环境）的插件平台系统，可以在Eclipse平台基础上通过扩展开发插件的方式形成用户定制的IDE。在Java诞生之初，Eclipse曾在相当长的一段时间，作为Java的主要开发平台。但Eclipse不仅仅是只用于Java的开发，在气质上开发的Python IDE（PyDev）还有C/C++ IDE（CDT）都是很不错的IDE。

SysML（系统建模语言）是UML（统一建模语言）的超集合，都是用来辅助现实世界抽象化的框图类标记工具。如果说UML是软件开发IT相关人员的“共同语言”，用于纯软件系统的设计与开发，那么SysML应该算是系统工程师的“共同语言”，用于生产制造环境中工业产品的需求、功能、逻辑、设计等环节。此类共同语言的存在，可以协调面向领域特定的开发人员，可以通过图表的方式，快速获得各方的设计理念，也极其方便了技术分工与协作。

SysML与UML有很多的相通之处，但也有其本身的特点。SysML中的图要素分为结构型图、行为型图、需求图三大类；而结构、行为、需求、参数是SysML的四大支柱。这四个支柱保证了SysML在描述工业产品时的完备性。详细可参考此[链接](http://www.omgsysml.org/what-is-sysml.htm) 。

Papyrus就是Eclipse这一IDE孵化器孵化出来的专门用于SysML建模的专用工具，当然Papyrus可以但不限于用于SysML建模，也可以用于UML的建模，但仅仅完成SysML的建模只是这一工具的一方面的功能，最为重要的功能是其中的模型执行器（Model Enabler）。

AOSSCI公司发起的Java-Eclipse-Papyrus项目，旨在完成SysML在Papyrus的完整应用流程，包括SysML各类图的建立与关联，行为图的有效化与模型的执行运行，定制的模型行为如何嵌入Papyrus环境等。





### SysML图

#### 概述各类类图

#### 举例一个完整例子串联各种类图



### 模型有效化与执行

#### SysML模型在Papyrus中的执行机理

#### SysML建模流程

#### SysML的执行流程



### 定制模型行为与外部Java代码嵌入

#### 定制模型行为机理

#### Java代码的执行举例 



### 参考

1. Papyrus的举例参见[链接](https://github.com/webgme/sysml/tree/master/examples/Papyrus)。这之中的链接应该非常直观，对研究Papyrus很有帮助。
2. OMG官方的SysML教程参见[链接](http://www.omgsysml.org/INCOSE-OMGSysML-Tutorial-Final-090901.pdf)。
3. 参考[举例](https://www.modeliosoft.com/en/resources/sysml-example.html) 。
4. SysML有一OMG官方链接[参见](http://www.omg.org/ocsmp/HSUV.pdf)。

