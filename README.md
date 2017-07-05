## Eclipse/Java/Papyrus插件使用与SysML预先研究

刘恒利（成都电子科技大学），田超（傲势科技）

### 引言

Eclipse是一个孵化IDE（集成开发环境）的插件平台系统，可以在Eclipse平台基础上通过扩展开发插件的方式形成用户定制的IDE。在Java诞生之初，Eclipse曾在相当长的一段时间，作为Java的主要开发平台。但Eclipse不仅仅是只用于Java的开发，在其之上开发的Python IDE（PyDev）还有C/C++ IDE（CDT）都是很不错的IDE。

SysML（系统建模语言）是UML（统一建模语言）的超集合，都是用来辅助现实世界抽象化的框图类标记工具。如果说UML是软件开发IT相关人员的“共同语言”，用于纯软件系统的设计与开发，那么SysML应该算是系统工程师的“共同语言”，用于生产制造环境中工业产品的需求、功能、逻辑、设计等环节。此类共同语言的存在，可以协调面向领域特定的开发人员，可以通过图表的方式，快速获得各方的设计理念，也极其方便了技术分工与协作。

SysML与UML有很多的相通之处，但也有其本身的特点。SysML中的图要素分为结构型图、行为型图、需求图三大类；而结构、行为、需求、参数是SysML的四大支柱。这四个支柱保证了SysML在描述工业产品时的完备性。详细可参考此[链接](http://www.omgsysml.org/what-is-sysml.htm) 。

Papyrus就是Eclipse这一IDE孵化器孵化出来的专门用于SysML建模的专用工具，当然Papyrus可以但不限于用于SysML建模，也可以用于UML的建模，但仅仅完成SysML的建模只是这一工具的一方面的功能，最为重要的功能是其中的模型执行器（Model Enabler）。

AOSSCI公司发起的Java-Eclipse-Papyrus项目，旨在完成SysML在Papyrus的完整应用流程，包括SysML各类图的建立与关联，行为图的有效化与模型的执行运行，定制的模型行为如何嵌入Papyrus环境等。



### SysML图

#### 概述各类类图

##### 模型与图形：

SysML消除了不同模型语言在表达法及术语上的不同，规范了符号和语义。从不同的描述角度区分定义了四种模型表示：结构模型强调系统的层次以及对象之间的相互连接关系，包括类和装配；行为模型强调系统中对象的行为，包括它们的活动、交互和状态历史；需求模型强调需求之间的追溯关系以及设计对需求的满足关系；参数模型强调系统或部件的属性之间的约束关系。

四种基本模型分别对应产生结构图(Structure Diagram)、参数图(Parametric Diagram)、需求图(Requirement Diagram)和行为图(Behavior Diagram) 。

SysML 的图形表示是SysML 的可视化表示，定义了九种基本图形来表示模型的各个方面：结构图用于显示系统中类或者部件的静态模型或者其之间的联系，包括类图(Class Diagram) 和装配图(Assembly Diagram)；参数图用于描述系统属性与属性之间的关系；需求图用于描述需求之间以及需求与其他建模元素的联系；行为图用于描述系统的动态模型和组成对象间的交互关系，包括活动图(Activity Diagram)、顺序图(Sequence Diagram)、时间图(Timing Diagram)、状态机图(State Machine Diagram)和用例图(Use Case Diagram)。

图形分类表示如下：

![SysML图结构](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E5%9B%BE%E7%BB%93%E6%9E%84.png)

##### 结构图：

结构图包括模块定义图和内部模块定义图以及包图，模块是SysML的基本结构单元，用来描述硬件、软件、设备人员以及其他系统元素。

(1) 模块定义图(BDD)定义了模块的属性以及模块之间的相互关系，这类关系包括关联、泛化和依赖。模块定义图是基于UML类和复合结构拓展而来的，可以描述系统的结构特征。模块定义图有唯一的名字，封装了若干属性和操作，操作的每个参数都有名称和类型。

模块定义图中可以包含包、模型、模型库、视图、模块和约束模块。其中最为重要和常见的是模块和约束模块。模块其对应于系统中的任意实体，通过带有<<block>>标识的矩形框表示，其后带有模块的名称，模块的其他组成的标识包含值属性和操作属性等。

如下图所示，表示一个模块的各组成部分：

![模块表示](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E6%A8%A1%E5%9E%8B%E8%A1%A8%E7%A4%BA.png)

属性包含行为属性和结构属性。结构属性表达了实体的结构组成该部分，而行为属性则表达了实体所具有的行为特征。结构特性包含值属性、组成属性、引用属性、约束属性、端口共 5 种类型；行为属性是对系统或结构的行为的表达，包括 操作和接收，操作表示一种调用后执行的行为，也就说操作是基于调用事件触发的。

模块的属性结构如图所示：

![SysML模块定义图](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E6%A8%A1%E5%9D%97%E5%AE%9A%E4%B9%89%E5%9B%BE.png)

SysML模块间存在关联、泛化和依赖关系，其中关联又可以分为引用关联和组合关联。引用关联表示双方存在一种连接，双方可以相互访问；组合关联表达的是一种构成关系，组合段的模块实例由组成部分端的实例组合而成；泛化表达的是一种继承关系，子类型继承超类型的特性，并对超类型特性进行扩展或重定义，泛化是可传递的。依赖表述的是两个模块间一方依赖于另一方，当另一方改变时，则依赖房可能也需要改变。这也是模型间跟踪性的体现。

模块间四种关系的表示形式示例如图所示：

![SysML模块间关系](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E6%A8%A1%E5%9D%97%E9%97%B4%E5%85%B3%E7%B3%BB.png)

模块定义图描述了系统的结构化信息，包括系统的结构类型及关系、结构提供以及需要的服务、结构所遵循的约束、系统中的值类型。模块间的泛化关系提现了面向抽象设计的思想，方便系统的扩展。模块的结构特性“端口”体现了封装的思想，降低系统间的耦合。约束模块及约束属性描述了模块结构的约束关系，一般和参数图搭配使用，用于构建系统的数学模型。描述了结构及结构件的关系，但未给出结构间联系的内部结构，涉及了约束属性和约束模块，但精确的模型搭建还需要参数图的配合。

一个模块定义图的表示如下：

![BDD](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/BDD.png)



(2) 内部模块定义图(IBD)是系统的静态视图，是在UML的复合结构图的基础之上进行了约束和拓展得到的。内部模块定义图用属性和连接定义了一个模块的内部结构，描述了部件之间的交互。其用于显示类元的内部结构，包括它与系统其他部分的交互点，也显示各部分的配置与关系，这些部分一起执行类元的行为。表达了系统的组成部分必须如何组合才能构建有效的系统，还会显示系统如何与外部角色相连接。

IBD的元素类型包括外部角色、模块、端口和连接器，模块用来表达了系统及系统内部组成，外部实体表达与系统有交互关系的外部角色，端口是模块与模块之间、模块与系统之间交互的进出口，连接器用来连接端口。

类的内部模块定义可以由下图表示：

![SysML内部模块定义](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E5%86%85%E9%83%A8%E6%A8%A1%E5%9D%97%E5%AE%9A%E4%B9%89.png)

内部模块定义图包括部件、端口、接口、委托和协作：

部件是代表一组实例的元素，这组实例的拥有者是一类元实例；端口是类型化的元素，代表一个包含类元实例的外部可视的部分，定义了类元和它的环境之间的交互以及类元提供的服务；接口操作都是公共和抽象的，不提供任何默认的实现，所有的接口属性都必须是常量；委托用来定义组件外部端口和接口的内部工作方式，委托连接器连接组件的外部约定，表现为它的端口，到组件部件行为的内部实现；协作定义了一系列共同协作的角色，它们集体展示一个指定的设计功能。仅显示完成指定任务或功能的角色与属性。



(3) 包图描述了将模型元素组成组的机制，包图用于组织模型。

包图的元素包括包、类、接口、数据类型、可见性和关系等，包Package用一个Tab框表示，包含Package的名字以及框里可选填充的一些其它子元素，如类、子Package等；类Class, 图形表示为一个实心矩形或圆形(椭圆)[+一系列附加符号]；接口Interface, 图形表示为一个实心矩形+书名号包含的interface字样；数据类型DataType, 图形表示为一个实心矩形+书名号包含的datatype字样。

包图与其之间的关系表示如下：

![包图](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E5%8C%85%E5%9B%BE.png)

关系包括包与包之间关系和类与类之间的关系，包之间的关系有：

​	合并 merge，表示为一条虚线+单向空心箭头+书名号包含的merge字样, 箭头指向被合并的包；

​	导入import, 表示为一条虚线+单向空心箭头+书名号包含的import/access字样, 箭头指向被合并的包；

​	嵌套 nesting ，表示为一条实线+带十字线的实心圆, 圆远离被合并的包。

类之间的关系包括如下类型：

​	实现 realization, 表示为一条虚线+单向空心箭头, 箭头指向被实现的接口；

​	泛化 generalization, 表示为一条实线+单向空心箭头, 箭头指向被泛化的基(父)类 ；

​	依赖 dependency, 表示为一条虚线[+单向或双向开口箭头], 单向箭头表示单向依赖；

​	关联 association, 表示为一条实线[+单向或双向开口箭头], 单向箭头表示单向关联 ； 

​	聚合 aggregation , 表示为一条实线[+单向空心菱形], 空心菱形箭头指向目标类或父类 ；

​	组合 composition, 表示为一条实线[+单向实心菱形], 实心菱形箭头指向目标类或父类 。

包的可见性具有公有和私有两种类型 <<import>>表示public, <<access>>表示private ；

类的可见性具有公有、私有、保护和包四种类型，分别使用 +/-/#/~ 符号表示 。



##### 参数图：

参数图是一种新的、独特的SysML图形，定义了一组系统属性以及属性之间的参数关系，用于说明系统的参数约束。参数约束关系说明了一个属性值变化怎样影响其他的属性值，参数关系是没有方向的，其通过把约束模型ConstraintBlock中的每个变量与模型的某个值绑定，即可向模型使用数学表达式的约束。

参数模型是分析模型，把行为模型和结构模型与工程分析模型如性能模型和可靠性模型等结合在一起，能用来支持权衡分析，评价各种备选的方案。

参数约束是一个装配，用paramConstraint表示，通常和SysML装配图结合起来使用，paramConstraint声明一个装配用作参数约束，它的端口定义了参数约束的参数，其装配的唯一有效用法是用值绑定约束的绑定参数和装配中的其他属性。参数约束内部可以包含其他参数约束，但不能包含其他部件或属性。参数约束关系用来表示系统的结构模型中属性之间的依赖关系，可以使基本的数学操作符也可以是物理相关的数学表达式。



##### 需求图：

需求图是一种新的SysML图形，能够描述需求和需求之间以及需求与其他建模元素之间的关系。需求指系统必须满足的能力或条件，一个需求能够分解成多个子需求。需求图可以直观的显示需求以及需求与其他模型元素之间的关系，可以建立需求之间，需求与包、用例、模块、约束模块之间的关系。

需求也是一个类，具有text和id两个属性，前者是需求的文本描述，后者是需求的标识符，用户可以定义需求的子类，如操作需求、功能需求、接口需求、性能需求等等。在需求图中可以建立的需求关系包括：包含、跟踪、继承、改善、满足、验证。建模者可以使用六种关系来确定需求之间的可追踪性，以及从需求到系统模型中的结构和行为的可追踪性。

使用导出(继承)关系derive表示一个需求可以从另外一个需求产生；使用满足关系satisfy表示一个需求能被其他的模型元素实现；使用验证关系verify表示一个需求能被测试子验证；以上SysML四种关系都是继承UML的trace，SysML用rationale表示基本原理注释元素，能够附在任何模型元素上，用来说明建模决策如分析决策或设计决策的原理或原因。

通常可以通过创建用例来替代基于文字的功能性需求，创建约束表达式来替代基于文字的非功能性需求，但如果项目没有创建基于文字的需求，而需要显示需求及需求与其他模型元素之间关系的时候，可以创建需求图。

一个需求图的示例如下：

![SysML需求图](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E9%9C%80%E6%B1%82%E5%9B%BE.png)



##### 行为图：

(1) 用例图提供了一种系统之间以及系统内部之间较高层次的功能性描述，描述了外部参与者对系统的使用，这是通过系统向参与者提供一系列服务来实现的，SysML用例图重用了UML用例图。

用例图包括用例、参与者以及它们之间的通讯，参与者可能是用户、外部系统或其他环境实体，它们和系统直接或间接交互。用例图的内容区域四种模型元素分别是：系统边界框由矩形框表示，用于定义系统的范围；参与者由人形图标或带有<<actor>>关键字的矩形图标表示，参与者可能是用户，也可能是其他系统；用例是椭圆形图标，并带有用例名称；参与者与用例间的关系为无箭头的实线。

用例和用户之间的关系包括包含include、扩展extend和泛化generalization关系：包含（include）关系的标识法是带有箭头的虚线，并注有<<include>>关键字关系箭头由关系的父端，指向被包含的用例；扩展（extend）关系的标识法是带箭头的虚线，并注有<<extend>>关键字，扩展关系表述的是一种可选的公共行为；泛化关系表示一种继承，是从抽象到具体的一种演化，采用带空三角箭头的实线表示。子类型的用例继承父用例的内容，并在此基础上进行重新定义或添加新的父用例不具备的关系或行为。

用例间的泛化关系表示一种继承，是从抽象到具体的一种演化。子类型的用例继承父用例的内容，并在此基础上进行重新定义或添加新的父用例不具备的关系或行为。在SysML中，泛化关系采用带空三角箭头的实线表示。

用例图的表示形式如下，展示了一个客户退货的用例图：

![SysML用例图](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E7%94%A8%E4%BE%8B%E5%9B%BE.png)



(2) 活动图描述活动之间的数据流和控制流，强调活动的输入输出、顺序和条件。SysML活动图对UML活动图进行了扩展，包括把控制作为数据、表示连续的物质或能量流、引入概念等，控制既能使动作开始也能使正在执行的动作终止。活动图的主要元素有初始节点和活动终点，初始节点用一个实心圆表示，活动终点用一个圆圈内一个实心圆来表示。

活动图中交互的简单元素是活动和对象，控制流controlflow是对活动和对象之间的关系的描述，表示动作与其参与者和后继动作之间以及动作和其输入和输出对象之间的关系。对象流object flow是将对象流状态作为输入或输出的控制流，表示了动作使用对象以及动作对对象的影响。

一个活动图的表示如下：

![活动图](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E6%B4%BB%E5%8A%A8%E5%9B%BE.png)

活动图有动作状态、活动状态和组合活动等表示，为了对并发的控制流建模而引入了分叉和汇合的概念，
动作状态（action state）是原子性的动作或操作的执行状态，它不能被外部事件的转换中断。其使用平滑的圆角矩形表示，表示的动作写在矩形内部。活动状态是一个程序的执行过程的状态而不是一个普通对象的状态，活动状态是非原子性的，可以分解成其他子活动或动作状态，可以被使转换离开状态的事件从外部中断。

组合活动是一种内嵌活动图的状态。一个组合活动在表面上看是一个状态，但其本质却是一组子活动的概括。一个组合活动可以分解为多个活动或者动作的组合。每个组合活动都有自己的名字和相应的子活动图。一旦进入组合活动，嵌套在其中的子活动图就开始执行，直到到达子活动图的最后一个状态，组合活动结束。



(3) 顺序图描述了对象之间传递消息的时间顺序，它用来表示用例的行为顺序，SysML顺序图重用了UML顺序图。顺序图根据控制流制订了一连串的交互，控制流是通过对象生命线之间发送和接受消息来定义的。消息包含了控和数据流，它发起接受消息的对象的行为，并把输入传给行为，消息的时间顺序和它在顺序图上的垂直位置相关。

顺序图的五要素是：活动者、对象、生命线、控制焦点和消息，对象是类的实例，对象是通过类来创建的，其放置于顺序图中一个单独的列中；生命线lifeline表示对象的生存时间，生命线从对象创建开始到对象销毁时终止；对象之间的交互是通过相互发消息来实现的，消息从源对象指向目标对象。消息一旦发送便将控制从源对象转移到目标对象。

消息分为同步消息、异步消息、返回消息和自关联消息四种。同步消息：一个对象向另一个对象发出同步消息后，将处于阻塞状态，一直等到另一个对象的回应；异步消息：一个对象向另一个对象发出异步消息后，这个对象可以进行其他的操作，不需要等到另一个对象的响应；返回消息：同步消息的返回消息；自关联消息：用来描述对象内部函数的互相调用。

激活用一个细长的矩阵框在生命线上表示，当一条消息被传递给对象的时候，它会触发该对象的某个行为，这就是说该对象被激活了。复合片段为顺序图中对于流程控制的模块，有条件逻辑、可选、循环、同步等表示。

一个顺序图的示例表示如下：

![SysML顺序图](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E9%A1%BA%E5%BA%8F%E5%9B%BE.png)



(4) 状态机是一种逻辑上的流程机，用于描述一个对象在其生命周期中的动态行为，关注的是系统中的结构如何根据随时间发生的事件改变状态，表现的是对象响应事件所经历的状态序列以及伴随的动作。

状态机图通过状态以及状态之间的转移对离散行为建模，它把行为表示为对象的状态历史。在状态的转移、进入和退出过程中会调用活动，并指定相关的事件和守卫条件。一个组和条件有嵌套的状态，可以是顺序的也可以是并发的，SysML状态机图重用了UML状态机图。

通常状态机图由原状态、目标状态、触发事件、监护事件和动作五个部分构成。其中状态有初态、终态，中间状态、组合状态和历史状态等状态类型；事件的类型分为信号事件、调用事件、改变事件、时间事件和延迟事件等。

状态被表示为一个带有状态名的圆角矩形；初始状态表示为实心黑圆环，结束状态表示为中心带黑点圆环，可以标注名称；一个状态到下一个状态的转移表示为带箭头实线，转移可以有一个“Trigger”触发器、一个“Guard”监护条件和一个“effect”效果；历史状态用来当状态机中断时，恢复状态机之前状态。

一个状态机图表示如下：

![SysML状态机图](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/SysML%E7%8A%B6%E6%80%81%E6%9C%BA%E5%9B%BE.png)

状态机图中某些符号实际并不表示一种状态，其被称伪状态，是用于加强可视化表示而引入的一种图形符号。伪状态并不处理事件也不会让状态停留，初始、进入状态和退出状态都是伪状态的一种，此外还有选择、连接和终止伪状态。选择伪状态显示为菱形，有一个转移输入，两个或多个输出；连接伪状态用来将多个状态转移链接在一起，连接可以把一个输入转移分成多个输出转移来实现一个静态分支；终止伪状态指状态机生命线已经终止，表示为叉号。此外，最终状态并不是为状态的一种，其表示一个区域活动的完成。

几种伪状态的符号表示如下：

![状态机图伪状态](https://github.com/Liuhenglee/Java-Eclipse-Papyrus/blob/master/images/%E7%8A%B6%E6%80%81%E6%9C%BA%E5%9B%BE%E4%BC%AA%E7%8A%B6%E6%80%81.png)



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
2. OMG官方的SysML教程，参见[链接](http://www.omgsysml.org/INCOSE-OMGSysML-Tutorial-Final-090901.pdf)。
3. sysml-example，参考[举例](https://www.modeliosoft.com/en/resources/sysml-example.html) 。
4. SysML有一OMG官方链接[参见](http://www.omg.org/ocsmp/HSUV.pdf)。
5. ”系统工程实验室”以及"Snowyying"的博主关于SysML语义的文章，链接[1参见](http://my.csdn.net/SystemEngineeringLab)链接2[参见](http://www.cnblogs.com/snowyying/p/UML_Package.html)。
6. UML学习笔记，用于对比SysML进行参考，链接[参见](http://www.cnblogs.com/xueyuangudiao/archive/2011/09/21/2182736.html)。
7. Papyrus使用手册，参见[Papyrus_User_Guide](https://wiki.eclipse.org/Papyrus_User_Guide#Create_a_new_Model)。

