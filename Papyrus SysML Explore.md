## Eclipse/Java/Papyrus插件使用与SysML预先研究

刘恒利（成都电子科技大学），田超（傲势科技）

### 引言

Eclipse是一个孵化IDE（集成开发环境）的插件平台系统，可以在Eclipse平台基础上通过扩展开发插件的方式形成用户定制的IDE。在Java诞生之初，Eclipse曾在相当长的一段时间，作为Java的主要开发平台。但Eclipse不仅仅是只用于Java的开发，在其之上开发的Python IDE（PyDev）还有C/C++ IDE（CDT）都是很不错的IDE。

SysML（系统建模语言）是UML（统一建模语言）的超集合，都是用来辅助现实世界抽象化的框图类标记工具。如果说UML是软件开发IT相关人员的“共同语言”，用于纯软件系统的设计与开发，那么SysML应该算是系统工程师的“共同语言”，用于生产制造环境中工业产品的需求、功能、逻辑、设计等环节。此类共同语言的存在，可以协调面向领域特定的开发人员，可以通过图表的方式，快速获得各方的设计理念，也极其方便了技术分工与协作。

SysML与UML有很多的相通之处，但也有其本身的特点。SysML中的图要素分为结构图、行为图、需求图三大类；而结构、行为、需求、参数是SysML的四大支柱。这四个支柱保证了SysML在描述工业产品时的完备性。详细可参考此[链接](http://www.omgsysml.org/what-is-sysml.htm)。

Papyrus就是Eclipse这一IDE孵化器孵化出来的专门用于SysML建模的专用工具，当然Papyrus可以但不限于用于SysML建模，也可以用于UML的建模，但仅仅完成SysML的建模只是这一工具的一方面的功能，最为重要的功能是其中的模型执行器（Model Enabler）。

AOSSCI公司发起的Java-Eclipse-Papyrus项目，旨在完成SysML在Papyrus的完整应用流程，包括SysML各类图的建立与关联，行为图的有效化与模型的执行运行，定制的模型行为如何嵌入Papyrus环境等。



### SysML图

第一章节主要介绍SysML中九种图建立的目的，以及其各自提供的重要背景信息；了解如何通过建立的SysML模型获取工程的主要信息。

#### Ⅰ 概述各类类图

##### 模型与图形：

SysML消除了不同模型语言在表达法及术语上的不同，规范了符号和语义。从不同的描述角度区分定义了四种模型表示：结构模型强调系统的层次以及对象之间的相互连接关系，包括类和装配；行为模型强调系统中对象的行为，包括它们的活动、交互和状态历史；需求模型强调需求之间的追溯关系以及设计对需求的满足关系；参数模型强调系统或部件的属性之间的约束关系。

四种基本模型分别对应产生结构图(Structure Diagram)、参数图(Parametric Diagram)、需求图(Requirement Diagram)和行为图(Behavior Diagram) 。

SysML 的图形表示是SysML 的可视化表示，定义了九种基本图形来表示模型的各个方面：结构图用于显示系统中类或者部件的静态模型或者其之间的联系，包括模块定义图(Block definition diagram) 、内部模块定义图(Internal block definition diagram)和包图(Package diagram)；参数图用于描述系统属性与属性之间的关系；需求图用于描述需求之间以及需求与其他建模元素的联系；行为图用于描述系统的动态模型和组成对象间的交互关系，包括活动图(Activity Diagram)、顺序图(Sequence Diagram)、时间图(Timing Diagram)、状态机图(State Machine Diagram)和用例图(Use Case Diagram)。

图1.1.1图形分类表示如下：

![SysML图结构](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20figure%20structure.png)



##### 结构图：

结构图包括模块定义图和内部模块定义图以及包图，模块是SysML的基本结构单元，用来描述硬件、软件、设备人员以及其他系统元素。

(1) 模块定义图(BDD)定义了模块的属性以及模块之间的相互关系，这类关系包括关联、泛化和依赖。模块定义图是基于UML类和复合结构拓展而来的，可以描述系统的结构特征。模块定义图有唯一的名字，封装了若干属性和操作，操作的每个参数都有名称和类型。

模块定义图中可以包含包、模型、模型库、视图、模块和约束模块。其中最为重要和常见的是模块和约束模块。模块其对应于系统中的任意实体，通过带有<\<block>>标识的矩形框表示，其后带有模块的名称，模块的其他组成的标识包含值属性和操作属性等。

如图1.1.2所示，表示一个模块的各组成部分：

![模块表示](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20model%20represents.png)

属性包含行为属性和结构属性。结构属性表达了实体的结构组成该部分，而行为属性则表达了实体所具有的行为特征。结构特性包含值属性、组成属性、引用属性、约束属性、端口共 5 种类型，端口类型具有标准端口(提供接口+请求接口)和流端口(非原子流端口、原子流端口)；行为属性是对系统或结构的行为的表达，包括 操作和接收，操作表示一种调用时执行的行为，也就说操作是基于调用事件触发的，接收是在模块被信号触发后需要执行的行为，是由信号事件触发的。

模块的属性结构如图1.1.3所示：

![SysML模块定义图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20model%20represents.png)

SysML模块间存在关联、泛化和依赖关系。关联是对元素的定义，其可以分为引用关联和组合关联，引用关联表示双方存在一种连接，双方可以相互访问；组合关联表达的是一种构成关系，组合段的模块实例由组成部分端的实例组合而成。泛化表达的是一种继承关系，子类型继承超类型的特性，并对超类型特性进行扩展或重定义，泛化是可传递的。依赖表述的是两个模块间一方依赖于另一方，当另一方改变时，则依赖方可能也需要改变。这也是模型间跟踪性的体现。

模块间四种关系的表示形式示例如图1.1.4所示：

![SysML模块间关系](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20module%20relationships.png)

模块定义图描述了系统的结构化信息，包括系统的结构类型及关系、结构提供以及需要的服务、结构所遵循的约束、系统中的值类型。模块间的泛化关系提现了面向抽象设计的思想，方便系统的扩展；模块的结构特性“端口”体现了封装的思想，降低系统间的耦合；约束模块及约束属性描述了模块结构的约束关系，一般和参数图搭配使用，用于构建系统的数学模型。

模块定义图描述了结构及结构件的关系，但未给出结构间联系的内部结构，涉及了约束属性和约束模块，但精确的模型搭建还需要参数图的配合。

图1.1.5一个模块定义图的表示如下：

![SysML BDD](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20module%20definition%20diagram2.png)



(2) 内部模块定义图(IBD)是系统的静态视图，是在UML的复合结构图的基础之上进行了约束和拓展得到的。IBD和BDD关系密切，可对BDD中表达的内容作出补充。IBD是为了指定单个模块的内部结构，而不会显示模块，它会显示对模块的使用，即模块的组成部分属性和引用属性。

内部模块定义图用属性和连接定义了一个模块的内部结构，描述了部件之间的交互。其用于显示类元的内部结构，包括它与系统其他部分的交互点，也显示各部分的配置与关系，这些部分一起执行类元的行为。表达了系统的组成部分必须如何组合才能构建有效的系统，还会显示系统如何与外部角色相连接。

IBD的元素类型包括外部角色、模块、端口和连接器：外部实体表达与系统有交互关系的外部角色；模块用来表达了系统及系统内部组成；端口是模块与模块之间、模块与系统之间交互的进出口；连接器用来连接端口，如果通过流端口进行连接则表示属性之间流动的时间、能量或者数据类型，如果通过标准端口连接则表示服务的提供。

类的内部模块定义可以由图1.1.6表示：

![SysML内部模块定义](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20internal%20module%20definition.png)

内部模块定义图还能够显示内嵌于属性中的其他属性，可以在此一视图之中展示系统层级的多个层级。当需要为内嵌属性添加连接器时，可以选择跨越封装内嵌属性的边界绘制连接器，也可在内嵌属性边界的端口处绘制连接器。SysML没有限制在图中对内嵌属性的层数，但属性中的内嵌属性会占据很大的空间，这可能会降低图的可读性。



(3) 包图(PKG)描述了将模型元素组成组的机制，是显示系统模型的组织方式时所创建的图，系统模型的组织方式由包的层级关系决定。

包图的元素包括包、类、接口、数据类型、可见性和关系等，包Package用一个Tab框表示，包含Package的名字以及框里可选填充的一些其它子元素，如类、子Package等；类Class, 图形表示为一个实心矩形或圆形(椭圆)[+一系列附加符号]；接口Interface, 图形表示为一个实心矩形+书名号包含的interface字样；数据类型DataType, 图形表示为一个实心矩形+书名号包含的datatype字样。

包图用于说明系统模型结构，SysML定义了四种类型的包：模型、模型库、特征和视图。包的可见性具有公有和私有两种类型 <\<import>>表示public, <\<access>>表示private ；类的可见性具有公有、私有、保护和包四种类型，分别使用 +/-/#/~ 符号表示 。

图1.1.7包图与其之间的关系表示如下：

![包图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20package%20diagram.png)

关系包括包与包之间关系和类与类之间的关系，包之间的常用关系有：合并 merge，表示为一条虚线+单向空心箭头+书名号包含的merge字样, 箭头指向被合并的包；导入import, 表示为一条虚线+单向空心箭头+书名号包含的import/access字样, 箭头指向被合并的包；嵌套 nesting ，表示为一条实线+带十字线的实心圆, 圆远离被合并的包。

类之间的关系包括如下常用的类型：实现 realization, 表示为一条虚线+单向空心箭头, 箭头指向被实现的接口；泛化 generalization, 表示为一条实线+单向空心箭头, 箭头指向被泛化的基(父)类 ；依赖 dependency, 表示为一条虚线[+单向或双向开口箭头], 单向箭头表示单向依赖；关联 association, 表示为一条实线[+单向或双向开口箭头], 单向箭头表示单向关联 ； 聚合 aggregation , 表示为一条实线[+单向空心菱形], 空心菱形箭头指向目标类或父类 ；组合 composition, 表示为一条实线[+单向实心菱形], 实心菱形箭头指向目标类或父类 。



##### 参数图：

参数图(PAR)是一种新的、独特的SysML图形，定义了一组系统属性以及属性之间的参数关系，用于说明系统的参数约束。参数图是一种特定的内部模块图，会显示模块的内部结构，其与IBD提供模块的相补视图。

参数模型是分析模型，把行为模型和结构模型与工程分析模型如性能模型和可靠性模型等结合在一起，能用来支持权衡分析，评价各种备选的方案。

参数约束关系说明了一个属性值变化怎样影响其他的属性值，参数关系是没有方向的，其通过把约束模型ConstraintBlock中的每个变量与模型的某个值绑定，即可向模型使用数学表达式的约束。

参数约束是一个装配，用paramConstraint表示，通常和SysML装配图结合起来使用，paramConstraint声明一个装配用作参数约束，它的端口定义了参数约束的参数，其装配的唯一有效用法是用值绑定约束的绑定参数和装配中的其他属性。参数约束内部可以包含其他参数约束，但不能包含其他部件或属性。参数约束关系用来表示系统的结构模型中属性之间的依赖关系，可以使基本的数学操作符也可以是物理相关的数学表达式。

图1.1.8展示了一个大炮开火范围的参数图：

![SysML参数图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20parametric%20graph.png)

参数图主要用于：显示不同约束表达式中约束参数之间的绑定关系，以创建等式或不等式的复合系统；显示约束参数和值属性之间的绑定关系，以向模块应用约束表达式。但并非所有的模型都需要建立参数模型，它需要系统模型高度精确，这会增加成本。



##### 需求图：

需求图(REQ)是一种新的SysML图形，能够描述需求和需求之间以及需求与其他建模元素之间的关系。需求指系统必须满足的能力或条件，一个需求能够分解成多个子需求。需求图可以直观的显示需求以及需求与其他模型元素之间的关系，可以建立需求之间，需求与包、用例、模块、约束模块之间的关系。

需求也是一个类，具有text和id两个属性，前者是需求的文本描述，后者是需求的标识符，用户可以定义需求的子类，如操作需求、功能需求、接口需求、性能需求等等。在需求图中可以建立的需求关系包括：包含、跟踪、继承、改善、满足、验证。建模者可以使用六种关系来确定需求之间的可追踪性，以及从需求到系统模型中的结构和行为的可追踪性。

使用导出(继承)关系derive表示一个需求可以从另外一个需求产生；使用满足关系satisfy表示一个需求能被其他的模型元素实现；使用验证关系verify表示一个需求能被测试子验证；以上SysML四种关系都是继承UML的trace，SysML用rationale表示基本原理注释元素，能够附在任何模型元素上，用来说明建模决策如分析决策或设计决策的原理或原因。

通常可以通过创建用例来替代基于文字的功能性需求，创建约束表达式来替代基于文字的非功能性需求，但如果项目没有创建基于文字的需求，而需要显示需求及需求与其他模型元素之间关系的时候，可以创建需求图。

图1.1.9一个需求图的示例如下：

![SysML需求图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20demand%20figure.png)



##### 行为图：

(1) 用例图(UC)提供了一种系统之间以及系统内部之间较高层次的功能性描述，描述了外部参与者对系统的使用，这是通过系统向参与者提供一系列服务来实现的，SysML用例图重用了UML用例图。

用例图包括用例、参与者以及它们之间的通讯，参与者可能是用户、外部系统或其他环境实体，它们和系统直接或间接交互。用例图的内容区域四种模型元素分别是：系统边界框由矩形框表示，用于定义系统的范围；参与者由人形图标或带有<\<actor>>关键字的矩形图标表示，参与者可能是用户，也可能是其他系统；用例是椭圆形图标，并带有用例名称；参与者与用例间的关系为无箭头的实线。

用例和用户之间的关系包括包含include、扩展extend和泛化generalization关系：包含include关系的标识法是带有箭头的虚线，并注有<\<include>>关键字关系箭头由关系的父端，指向被包含的用例，当源端的用例被触发时目标端的用例就会被执行；扩展extend关系的标识法是带箭头的虚线，并注有<\<extend>>关键字，扩展关系表述的是一种可选的公共行为而并不表示一种依赖，当目标端的用例被触发时源端的用例可被选择性执行；泛化关系表示一种继承，是从抽象到具体的一种演化，采用带空三角箭头的实线表示，子类型的用例继承父用例的内容，并在此基础上进行重新定义或添加新的父用例不具备的关系或行为。

用例间的泛化关系表示一种继承，是从抽象到具体的一种演化。子类型的用例继承父用例的内容，并在此基础上进行重新定义或添加新的父用例不具备的关系或行为。在SysML中，泛化关系采用带空三角箭头的实线表示。

图1.1.10用例图的表示形式如下，展示了一个客户退货的用例图：

![SysML用例图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20use%20case%20diagram.png)

用例图是一种黑盒视图，它代表的是系统服务的提供，以及需要那些服务并在触发之后参与到执行过程中的执行者。注意用例图中避免出现以下的的非法事物：执行者与用例之间复合关联；执行者之间任何类型的关联；两个用例之间的关联。



(2) 活动图(ACT)是一种行为图，用于描述活动之间的数据流和控制流，强调活动的输入输出、顺序和条件。

SysML活动图对UML活动图进行了扩展，包括把控制作为数据、表示连续的物质或能量流、引入概念等，控制既能使动作开始也能使正在执行的动作终止。活动图中主要包括节点、边和活动分区三种元素：

动作、对象节点和控制节点都是节点的一种类型，一个动作代表数据的处理或者转换；对象节点可对对象令牌通过活动的流进行建模，即创建一个类的实例，栓pin是一种特殊类型的对象节点，其附加在动作上用于表示动作的输入与输出；控制节点具有七种类型，分别为初始节点、活动最终节点、流最终节点、决定节点、合并节点、分支节点和集合节点，其用于指引活动沿着路径执行，不是简单的序列活动。

需要注意的是，一个动作的启动需要满足如下三个条件：拥有动作的活动正在执行；所有输入控制流上的控制令牌到达；满足输入栓的最低多重性。

边可分为对象流object flow和控制流controlflow两种：对象流是将对象流状态作为输入或输出的控制流，表示事件、能量或者数据实例通过活动进行传递，控制流是对活动和对象之间的关系的描述，表示动作与其参与者和后继动作之间、动作和其输入和输出对象之间的关系。

图1.1.11一个活动图的表示如下：

![活动图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20activity%20diagram.png)

活动图也可分为动作状态、活动状态和组合活动等表示：
动作状态action state是原子性的动作或操作的执行状态，它不能被外部事件的转换中断。其使用平滑的圆角矩形表示，表示的动作写在矩形内部。活动状态是一个程序的执行过程的状态而不是一个普通对象的状态，活动状态是非原子性的，可以分解成其他子活动或动作状态，可以被使转换离开状态的事件从外部中断。

组合活动是一种内嵌活动图的状态。一个组合活动在表面上看是一个状态，但其本质却是一组子活动的概括。一个组合活动可以分解为多个活动或者动作的组合。每个组合活动都有自己的名字和相应的子活动图。一旦进入组合活动，嵌套在其中的子活动图就开始执行，直到到达子活动图的最后一个状态，组合活动结束。

活动图可以表达复杂的控制逻辑，且是唯一能够说明连续系统行为的图，所以活动图适合作为分析工具。但它略显模糊，没有提供任何机制来说明哪个结构触发哪个动作，没有明确的行为说明。



(3) 顺序图(SD)描述了对象之间传递消息的时间顺序，它用来表示用例的行为顺序，SysML顺序图重用了UML顺序图。顺序图根据控制流制订了一连串的交互，控制流是通过对象生命线之间发送和接受消息来定义的。消息包含了控和数据流，它发起接受消息的对象的行为，并把输入传给行为，消息的时间顺序和它在顺序图上的垂直位置相关。

顺序图的五要素是：活动者、对象、生命线、控制焦点和消息，对象是类的实例，对象是通过类来创建的，其放置于顺序图中一个单独的列中；生命线lifeline表示对象的生存时间，生命线从对象创建开始到对象销毁时终止；对象之间的交互是通过相互发消息来实现的，消息从源对象指向目标对象。消息一旦发送便将控制从源对象转移到目标对象。

消息分为同步消息、异步消息、返回消息和创建消息四种。同步消息：一个对象向另一个对象发出同步消息后，将处于阻塞状态，一直等到另一个对象的回应；异步消息：一个对象向另一个对象发出异步消息后，这个对象可以进行其他的操作，不需要等到另一个对象的响应；返回消息：同步消息的返回消息，从执行行为的生命线发送到触发行为的生命线；创建消息：用来在系统中创建新实例，消息的箭头和被创建的生命线头部相接。

激活用一个细长的矩阵框在生命线上表示，当一条消息被传递给对象的时候，它会触发该对象的某个行为，这就是说该对象被激活了。复合片段为顺序图中对于流程控制的模块，有条件逻辑、可选、循环、同步等表示。

图1.1.12一个顺序图的示例表示如下：

![SysML顺序图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20sequence%20diagram.png)

组合片段是一种机制，用于向交互添加控制逻辑，由一个放在一个或多个生命线之上的矩形标示，并对其中的消息进行封装。控制逻辑类型由交互操作符来指定，SysML定义了是一种交互操作符，常用类型为opt,alt,loop和par：opt表示一系列可选的事件，守卫guard布尔表达式放置于组合片段的顶部第一个事件发生的生命线上，如果条件为真则组合片段在执行过程中发生；alt表示两个或多个可替换的系列事件，其有多个操作区域，每个操作区域都有自己的守卫，同一时间只有一个守卫为真；loop表示一次执行可发生多次的交互，交互操作符中还需指定迭代次数的范围；par表示两个或者多个可并行执行的事件。

顺序图是对行为的精确说明，适合于用在详细设计方面，其可以用来说明系统层级中的任意级别的行为。但随着行为控制逻辑复杂度的增加，顺序图可能会变得不可读，甚至难以绘制。序列图的优势在于清楚传达以下三种重要信息：行为发生的顺序、哪个结构执行哪个行为、哪个结构触发哪个行为。



(4) 状态机图(STM)是一种逻辑上的流程机，用于描述一个对象在其生命周期中的动态行为，关注的是系统中的结构如何根据随时间发生的事件改变状态，表现的是对象响应事件所经历的状态序列以及伴随的动作。

状态机图通过状态以及状态之间的转移对离散行为建模，它把行为表示为对象的状态历史。在状态的转移、进入和退出过程中会调用活动，并指定相关的事件和守卫条件。一个组和条件有嵌套的状态，可以是顺序的也可以是并发的，SysML状态机图重用了UML状态机图。

通常状态机图由原状态、目标状态、触发事件、监护事件和转换动作五个部分构成。其中状态有初态、终态，中间状态、组合状态和历史状态等状态类型；事件的类型分为信号事件、调用事件、改变事件、时间事件和延迟事件等；转换动作分为外部转换和内部转换两种。

状态被表示为一个带有状态名的圆角矩形；初始状态表示为实心黑圆环，结束状态表示为中心带黑点圆环，可以标注名称；一个状态到下一个状态的转移表示为带箭头实线，转移可以有一个“Trigger”触发器、一个“Guard”监护条件和一个“effect”效果；历史状态用来当状态机中断时，恢复状态机之前状态。

图1.1.13一个状态机图表示如下：

![SysML状态机图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20state%20machine%20diagram.png)

状态机图中某些符号实际并不表示一种状态，其被称伪状态，是用于加强可视化表示而引入的一种图形符号。伪状态并不处理事件也不会让状态停留，初始、进入状态和退出状态都是伪状态的一种，此外还有选择、连接和终止伪状态。选择伪状态显示为菱形，有一个转移输入，两个或多个输出；连接伪状态用来将多个状态转移链接在一起，连接可以把一个输入转移分成多个输出转移来实现一个静态分支；终止伪状态指状态机生命线已经终止，表示为叉号。此外，最终状态并不是为状态的一种，其表示一个区域活动的完成。

图1.1.14几种伪状态的符号表示如下：

![状态机图伪状态](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/SysML%20pseudo%20state.png)

状态机也可以表示并发行为，通过向状态机添加多个区域实现，系统操作的任意时刻每个区域都必须有一个活动状态。



##### 总结

SysML 是UML 在系统工程应用领域的延续和扩展，和其他系统工程建模语言相比，SysML 是一种通用的功能
强大的标准建模语言。它消除了不同方法在表达法和术语上的差异，避免了符号表示和理解上不必要的混乱。

SysML 能对系统工程的各种问题进行建模，适用于系统工程的不同阶段，特别是在系统工程的详细说明阶段和设计阶段，使用SysML 来说明需求系统结构功能行为和分配非常有效。SysML 的应用必然与过程相关，不同的系统工程应用领域要求不同的过程，SysML 的开发者提出的开发过程是模型驱动以体系结构为中心迭代递增的过程。

第一小节只是围绕着结构、行为、需求和参数四要素简单对SysML中使用的各个类型的图进行了初步的分析和解释，至于建图的方法和步骤需要再在接下来的章节进行解释。模型的图并不是模型本身，其只是模型的一个视图，每一种图都有其具体的使用目的，建立哪一种图和如何建立需要建模人员本身对系统模型有一个全面的理解。

表格1.1此处我们对上文每种图可表示的元素模型建立了如下模型图表格：

![模型图总结](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/Summary%20of%20model%20drawing.png)



#### Ⅱ 举例一个完整例子串联各种类图

第二小节参考OMG官方介绍文档2，以混合动力SUV为例进行解释，描述SysML的使用，主要展示运用SysML构思建立的一个问题的各类图。对于SysML如何支持使用系统的规范、分析和设计，本例展示了语言的一些基本特征，并为每个SysML图类型提供至少一个图表。

本例选择简化问题的片断来说明如何应用图表，并展示了一些可能的相互关系，所以此小节的结构是在如何在这个示例问题上使用它的上下文中显示每个图。具体问题内容如下：

电动运动型多用途车SUV有内在冲突的需求，即对燃油效率的渴望，同时也期望大型货物承载能力和越野能力。我们把这些需求划分为操作需求、性能需求、质量需求和容量需求以建立约束关系，同时需要考虑SUV与驾乘人员以及维护人员等主要参与者之间的关系。本例具体关注于设计决策围绕混合动力SUV的动力子系统、需求、性能分析、结构和行为，而技术的准确性和实际解决方案的可行性并不是优先考虑的问题，具体模型图的建立和解释如下。

##### (1) 建立系统上下文

第一部分显示的SysML图可能用于建立系统边界以及顶层用例、描述系统上下文等，此步骤主要需要建立包图、内部框图和用例图。

1. 包图的简要和具体的各层绘制

示例图1.2.1简单对包进行了划分：

![HSUV包图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20package%20diagram.png)

解释：HSUVModel是一个代表用户模型的包，SysML概要文件必须应用到这个包中，以便包含来自概要文件的构造型。HSUVModel可能还需要模型库，比如SI单元类型模型，模型库必须按照指定的方式导入到用户模型中。由此建立的SysML包与其他包的关系为严格的应用关系，HSUVModel用户模型与SI单元模型库的关系为导入关系。

示例图1.2.2详细说明了这个示例问题中使用的HSUVModel用户模型包的单元结构：

![HSUV包图2](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20package%20diagram2.png)

在用户模型包中包含各个模型元素，图中显示了包或模型元素之间的关系，显示用于评估样例问题的模型的结构。视图模型View不包含自己的模型元素，并且对其他包中的模型的更改会在操作和性能视图中自动更新。

用户模型包中包括HSUVUseCases用例包、HSUVBehavior行为包、HSUVStructure结构包、HSUVRequirement需求包、HSUVAnalysis分析包和HSUVViews视图包，视图包中具体分为操作视图operational view和性能视图performance view，以及各自定义其一致视图点viewpoint，由conform遵循关系进行约束；视图和用户模型的其余部分之间的关系使用导入关系显式地表示。其中行为、结构和需求拥有其嵌套结构与性能视图和操作视图建立导入关系，以遵循相应的性能和操作需求。



2. 内部模块定义图用于设置上下文

“上下文关系图”指的是用户定义的内部模块图，它描述了整个企业中的一些顶级实体及其关系。其所描述的每个模型元素可能包括一个图形图标，图中实体的空间关系有时也表达了理解，尽管这并不是在语义中被捕获的，还可以包括地图等背景以提供附加的上下文。

示例图1.2.3使用用户定义的上下文图建立混合SUV系统的上下文：

![HSUV内部框图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20internal%20block%20diagram.png)

此处内部模块定义图以HyperSUV为中心，定义了与驾驶人员、维护人员以及乘客之间的关系，同时定义了外部Baggage行李和Environment驾驶环境的附加上下文，驾驶环境中提出了Weather天气、Road道路以及ExternalObject外部对象等关键元素。

类之间的关联可能表示实体之间的抽象概念关系，这些关系将在后续的关系图中得到细化。



3. 用例图为混合动力SUV用例图建立顶级用例

示例图1.2.4描述了SUV和主要参与者之间建立的用例场景：

![HSUV用例图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20use%20case%20diagram.png)

用例图“HyperSUV”描述了驱动车辆使用的车辆系统。主体混合动力SUV和参与者(驾驶员、注册所有者、维护人员、保险公司、DMV)相互作用以实现用例。用例主体中包含Operate操作用例、Insure保险用例、Register注册用例和Maintain维护用例，驾驶人员仅与操作用例进行交互，维护人员只需考虑对车辆的维护，注册所有者则需要对车辆进行注册与投保。

示例图1.2.5主要描述驱动程序建立的SUV用例：

![HSUV用例图2](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20use%20case%20diagram2.png)

驱动人员面对的用例场景主要有驾驶和驻车两种状态的用例，然后对两种用例进行扩充新增车辆启动、加速、控制引导和刹车用例等车辆主要操作，车辆启动是驾驶的扩展用例，加速、控制引导和刹车是驾驶和停车的包含用例。此用例图详细描述了车辆驱动人员的具体负责事项。



##### (2) 系统行为分析

使用SysML图来分析系统的行为特征，需要使用序列图和状态机图等。

1. 驱动黑盒序列图

示例图1.2.6显示了驱动车辆用例所必需的驱动程序和车辆之间的交互：

![HSUV序列图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20sequence%20diagram.png)

这张图代表了DriveBlackBox驱动黑盒的交互，它是由汽车领域的块所拥有的。黑盒用于本例的目的，是指主题系统HSUV块与外部元素交互的方式，而不显示任何内部细节。在高控速alt controlSpeed部分中，每个选项的条件都用操作控制语言OCL表示，并与HSUV块的状态相关。

此序列图与普通方式绘制的序列图有所不同，在生命线上直接建立各元素部分，用于显示驾驶员与HSUV所能建立的所有黑盒交互关系，包括车辆启动、驻车以及高控速部分(闲置、巡航、加速、刹车、驾驶)交互事件，每一个交互事件下都包含一个可再细分的顺序图。



2. HSUV操作状态机图

示例图1.2.7通过一个名为“HSUVoperationalstate”作业状态的状态机描述了HSUV块的操作状态：

![HSUV状态图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20state%20diagram.png)

图中将作业状态划分为Oprate操作状态和Off关停状态，关停状态的车辆经过Start启动事件触发进入操作状态，操作状态车辆经过Shutoff熄火重新回到关停状态；操作状态中首先进入的是Idel闲置状态，闲置状态经加速事件触法进入巡航状态，巡航状态经制动后转为刹车状态，刹车状态经过停车触发转换为闲置状态。

状态机图是与驱动黑盒blackbox交互一起开发的，这个状态机改进了“powersourcemment”的需求，这将在这个示例问题的需求部分中进行详细阐述。这个图只表示了名义状态。像“加速失败”这样的异常状态在这张图中没有表示出来。



3. 车辆启动黑盒与白盒序列图

示例图1.2.8显示了一个黑盒交互，作为示例图1.2.6车辆启动的部分详细划分：

![HSUV序列图2](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20sequence%20diagram2.png)

车辆启动由驾驶员发出Turn ignition点火消息对车辆启动白盒进行激活。启动载体的黑盒交互，引用了车辆启动白盒交互序列图1.2.9，它将分解HSUV块上下文中的生命线。

图1.2.9中的生命线需要来自Power系统分解,启动载体的白盒交互序列图。现在开始考虑在混合动力suv中包含的部件:

![HSUV序列图3](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20sequence%20diagram3.png)

车辆启动白盒划分为PowerControl动力控制单元和Electrical电动控制单元，点火消息传递给白盒后，首先激活动力控制单元，然后再发送使能信号激活电动控制单元，电动控制单元准备完成后返回就绪消息。



##### (3) 系统结构描述

第三部分重点讨论SysML图的使用使用图表和表格来获取和派生需求，提供了一个部分来说明SysML是如何被使用的描述系统结构，包括块层次结构和部分关系各种系统参数的关系；

1. HSUV需求层次结构的建立

示例图1.2.9将需求层次划分为了三层：

![HSUV需求图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20demand%20figure.png)

最顶层为车辆系统规范，其中包含许多基于文本的需求。图中突出了一些需求，包括车辆通过排放标准的要求，为了便于说明，该标准被扩展了。

第二层为Eco-friendliness经济友好规范、Performance性能要求、Ergonomic人体工程学需求、Qualification质量要求和Capacity容量需求。其中性能需求又约定了刹车、油耗、加速和越野能力，质量需求主要为安全性能，而容量又由载货量、乘客数和油箱容量构成。

出于本例的目的，容器的交叉关系指的是将复杂的需求分解为更简单的单一需求的实践。



示例图1.2.10派生需求图,显示了一组需求是从最低层HSUV规范中的要求：

![HSUV需求图2](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20demand%20figure2.png)

从最低层次的需求层次结构中建立派生需求和基本原理，派生的需求在HSUV规约中表达了需求的概念，并将它们与HSUV系统联系起来。Power能源要求与越野、加速和载货需求建立请求关系，其他的还有二次制动和续航里程需求。

PSM电源管理需求直接与油耗与动力要求建立请求关系，为了帮助开发派生的需求，电源管理可能需要各种其他的模型元素，并且这些模型元素可能是通过Refinedby精炼关系来关联的。



2. 汽车领域模块定义图的定义

示例图1.2.11汽车领域模块定义图提供了先前在环境图中所示的概念的定义：

![HSUV模块定义图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20module%20definition%20diagram.png)

AutomotiveDoamin汽车动力领域所拥有的交互驱动黑盒与驱车黑盒在第二部分中描述了详细说明行为(序列和状态机图)。此处再次对之前的IBD做了BDD解释，将汽车领域向下划分为HSUV系统、外部行李、外部环境元素，环境元素中依旧包括天气、外部对象和道路等元素。



示例图1.2.12定义了混合动力suv块的组件：

![HSUV模块定义图3](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20internal%20block%20diagram3.png)

如图所示，HSUV块中包含动力、制动、形体、内部、照明和底盘子系统块，刹车踏板和轮毂集成被定义使用，并包含在动力子系统块中。



3. 混合动力SUV内部模块定义图

示例图1.2.13定义了混合动力SUV的内部结构，显示了顶级模型元素是如何在HSUV块中连接在一起的：

![HSUV内部模块定义图2](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20internal%20block%20diagram2.png)

HSUV块中主要包含图1.2.12中定义的子系统，此图中再定义了各子系统之间的关系。



示例图1.2.14定义了电力子系统的内部结构，显示了动力子系统块的各个部分是如何被使用的：

![HSUV内部模块定义图3](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20internal%20block%20diagram3.png)

它显示了在各个部分之间建立的连接，包括客户端服务器端口、流端口、原子流端口和项目流等。前轮和刹车踏板与其他元素之间建立了共享聚合关系，边界虚线表示燃料的存储，它可以跟踪燃料的消耗量和存储量。



##### (4) 模型约束定义

第四部分演示性能约束、分析和时序图，然后将一个部分用于在结构上下文中说明了接口和流的定义和描述。

1. 燃料流量参数图

示例图1.2.15定义了燃料流约束的参数图，显示了燃料的流量与燃料需求和燃料压力值的关系：

![HSUV参数图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20parameters%20figure.png)

参数图显示了燃料流量、燃料需求和燃料压力值之间的关系，即燃料的流量与燃料的需求、压力和流率的参数约束与燃料流量有着实值属性的绑定。



示例图1.2.16定义了有效性和关键关系的度量的参数关系图：

![HSUV参数图2](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap1/HSUV%20parameters%20figure.png)

最大加速度分析与通过指定路程的计时有着值的关联，经济油耗量、载货量和单位成本有着各自的值约束关系用于建立方程计算，这些所有计算关系的目标函数总合即是HSUV的成本效率的计算式。

衡量有效性的标准是用户定义的原型，图中显示了HSUV的整体成本效益如何评估，展示了针对HSUV设计的一种特定替代方案的有效性的具体措施，并可被重用来评估其他替代方案。

至此，HSUV混合动力汽车系统的所有类型图都已由举例建立完毕，由于HSUV系统设计子系统复杂且用例多，本例只截取了其中的一部分进行解释，其余的部分可参考HSUV文档。一个项目的SysML具体完整的建模过程将在2.2节中进行分析解释。



### 模型有效化与执行

SysML是一种图形化的建模语言，OMG组织发布了针对SysML的建模语言描述规范，其详细定义的SysML的语义。建模工具是一类特殊的工具，设计和实现它们是为了遵守一种或多种建模语言的规则，以使用语言创建形式良好的模型。

Papyrus是基于Eclipse公共许可提供的免费建模工具，可以对 C++、IDL和Java编写的代码进行反向工程。第二章节的开发在Eclipse开发环境下实现，需要使用到的插件有Papyrus Modoller 和 Java reverse engineering，安装时需要选择相对应的的开发语言。通过安装对应的插件，Papyrus将支持SysML模型搭建、SysML模型执行、Java代码生成和Java逆向工程四种功能，本文将在第二章依次分别介绍。

#### Ⅰ 建模基本原则

##### (1) 模型建立步骤

1. 建模：

   创建项目：从项目资源管理器中，右键单击，然后新建Pyparus项目；从向导中选择 SysML 作为建模语言；从接下来的向导中，命名该项目和模型和名字模型的根元素等。

   应用 FMI 2.0 配置文件：在模型资源管理器中，选择创建的模型；选择选项卡“配置文件”，点击按钮 “应用注册配置文件”，选择“FMI 2.0 配置”，然后在向导中检查 FMIProfile。

   导入模型库：右键单击模型从型号资源管理器，然后导入注册包；在向导中选择基础模型库FoundationalModelLibrary。这个库被定义为 OMG 标准 fUML 的一部分。它提供了基本功能(算术和逻辑等)有用来描述模型行为；重复该操作导入基本类型库SysMLPrimitiveTypes，定义SysML的基本类型 (整数,实数,布尔值和字符串)，用来定义输入和输出及其内部变量。

   创建模型：在类关系图中，创建一个新的类，其最后将导出模型的元素；此类应为活动的(在fUML中，实例化的活动意味着一个模型行为开始的地方)，属性“is active”是与类关联的属性视图中可用，必须将它设置为 true；应用协同仿真模型模版CS_FMU，以确定此类实际上表示一个仿真模型。

   定义输入和输出：为表示模型的类创建一个新的端口；键入的端口号为以下SysML元类型之一： 整数，真实，字符串和布尔。选择的端口，选择模版选项卡，添加并应用端口Port ，然后为其指定为输入或者输出方向，并设置一个整数参考值字段。

2. 调试：

   切换到Moka Debug 透视图。

   定义一个新的Moka启动配置：在“UML模型”字段中，选择包含仿真模型要执行的.uml 文件；在“执行元素”字段中，选择您想要调试的模型中生成的Factory；在“执行引擎”字段中，选择org.eclipse.papyrus.moka.composites单击应用，然后调试启动执行。

   控制的模型的执行：一旦启动配置后，如果有输入输出参数，一个对话框将出现，此对话框提供了一个简单的执行控制界面。




##### (2) 基本节点设计

1. 时间节点设置：

   绝对日期响应：创建时间事件TimeEvent，从模型资源管理器中，右键选择 New Child TimeEvent，然后切换到 UML 属性视图选项卡，在When选项中的Expr字段设置一个LiteralReal值，定义为具体的时间；

   相对日期响应：在创建的时间事件中，设置Is relative相对字段为true，时间则为相对时间；

   触发器：在活动图中创建接收时间活动AcceptEventAction，在触发器Trigger字段中选择已创建的时间事件。

   一个简单的时间节点设置如下：

   ![时间事件节点](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/Images-Chap2/Time%20event%20node.png)

   ​

2. 循环分支节点：

   建立决策节点DecisionNode，需要进行判断的值作为对象流ObjectFlow输入；然后在决策节点上添加传出的边，这些边中的一个应以直接或间接的方式与一个合并节点MergeNode构成一个循环。

   每个传出的边缘都需要定义一名守卫Guard，在执行时决策节点的输入的值与传出边缘上的守卫值进行比较。当输入的值等于一个守卫时，执行引擎将选择相应的边缘。

   如果可以选择多个传出边缘，选择具有不确定性，可能会有多个符合的情况。在Moka进行调试的过程中，第一个匹配边缘将被执行，匹配顺序取决于边缘模型创建的顺序。

   下面的示意图展示了一个do while语句的活动图：

   ![循环分支节点](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/Images-Chap2/Loop%20branch%20node.png)

   ​

3. 条件分支语句：

   对于一个决策节点DecisionNode，其对语句没有直接进行判断的能力，需要通过对控制流的守卫进行匹配来完成。因而对条件分支语句有两种设计方法，对应if else和switch两种语句。

   对于if else语句，需要把if()的判断语句前置，在决策节点之前通过调用基础模型库中的逻辑运算符进行判断，将判断结果交由对象流传递即可。需要注意的是基础模型库中并没有判等或者不等的操作，可以将其转换为switch形式。switch形式则可以直接将判断值交给决策节点进行一一匹配。

   一个简单的if else语句如下图所示：

   ![if判断语句](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/Images-Chap2/Judge%20statement%20drawing.png)


使用决策节点和触发器能够实现更多复杂的操作，根据以上两种情况的介绍，包括循环、选择、转移和中断等基本操作都已可以实现。对于一个可执行活动图的更多绘制细节将在接下来的几个小节进行介绍。在项目中存放有一示例活动图Caculator test，其可用于决策节点的测试。



4. 输入输出端口：

   输入输出端口在启动调试后，会弹出对话框用于输入参数的设定和输出显示，其配置方法如下：

   在模块定义视图当中通过调色板选取Port端口元素时不能将其添加至类块属性attribute中。正确的方法是右键点击模型浏览器Model Explorer窗口中需要添加端口的类，选择"New Child->port"添加一个端口，设置其属性，然后再将其拖放至类块属性attribute中。在项目根元素中导入FMI和SysML配置文件的情况下，可在端口的模版stereotype中，添加端口Port模版，即可定义其输入输出的方向。

   ​

5. 输入输出参数：

   在定义类方法时需要配置输入或输出参数并绘制其对应的活动图，一个操作operate的格式如下：

   ```
   + operate(in Input:Integer, out Output, inout Th:Boolean):Real
   ```


   其中包括四种参数类型，从左至右为输入in、输出out、输入并输出inout和返回return，其中返回类型不显示参数名。创建好类方法之后在模型浏览器Model Explorer窗口右键点击方法，选择"Moka->Modeling Utils->Generate Method"创建其对应的活动，创建的活动会出现在类块的目录中，然后右键点击"New Diagram->Activity Diagram"创建活动图，将活动目录中的参数拖动至活动图中活动图元素的边界处即可。




##### (3) 常见错误分析

1. ```
   Execution stopped: unexpected exception
   index=0, size=0
   ```

   此种情况在调试开始前报错，错误处理：

   首先检查调试配置，是否选择了错误的执行元素或者执行引擎。执行元素需要选中[Activity] xxxx_Factory目录，执行引擎建议使用org.eclipse.papyrus.moka.composites或者org.eclipse.papyrus.moka.timedfuml。

   ​

2. ```
   Execution stopped: unexpected exception
   java.lang.NullPointerException
   ```

   此种情况在调试运行开始前报错，或者在活动节点处报错。错误处理：

   如在运行开始前报错，可能是执行程序未能找到执行的入口，或者没有建立起一条有效的执行路径，请检查各个活动图之间是否连接正常，一条边的指向不明确会导致空指针；检查完毕后点击类块查看其属性，在UML菜单下会增加一个与类同名的构造函数，点击编辑按钮，在Method方法项中添加仿真程序执行入口所在的活动图，然后保存。

   如果在执行过程中报错，则产生错误的节点可能配置异常，有如下几种情况：

   如果在结构特征活动节点处中断报错，需要检查调试配置查看是否选择了错误的执行元素，如果调试配置正确，需检查结构特征节点，是否配置了结构特征变量，空的结构特征变量会导致空指针；

   如在行为调用活动节点或者操作调用活动节点处报错，请检查是否配置了需要调用的活动或者操作；

   如果以上检查均未发现异常，请检查活动的基本路径，当路径产生死锁或者路径中断时，也会导致空指针错误。

   ​

3. 需要注意的是，papyrus只是简单地遵循SysML标准，对SysML模型之间的关系以及行为模型的研究不够深入，在使用工具进行SysML建模时无法对模型的正确性进行验证，缺乏对模型的检测机制。例如边的配置、对象数据类型和最大绑定数量的错误或者配置缺失都不会被监测到，执行时也不会有任何提示，但是可能导致模型模拟的结果完全错误，建议在每个元素被创建时就确定好其属性。

   ​

#### Ⅱ SysML建模流程(车辆智能巡航系统CarStatistics)

本小节引用参考文献9，旨在尽可能多地使用Papyrus插件中的各种SysML图形构造出一个较完整的系统模型，将已经构思好的系统模型通过SysML在插件中展现出来。模型建立内容如下：

针对车辆信息系统设计中缺乏规范合理的设计方法的现状，结合新时期车辆信息系统发展的趋势和特点提出了一种基于SysML的车辆信息系统设计方法。该方法在流程上不仅是一个自顶向下、逐步求精的迭代增量式设计过程，为系统搭建可执行的系统模型，对系统的功能、物理结构、信息流和接口进行了全面一致的设计。

车辆智能巡航系统依托于整车信息架构，由信息采集、信息传输、信息处理、决策、显示与控制等功能组成，是一个相对独立的信息系统。该系统通过实时采集距离、障碍物等信号，获得车辆行驶环境信息，并结合车辆当前状态进行信息处理与决策，从而控制车辆的速度等；在遇到紧急情况时，能够通过报警的形式对驾驶员进行提示，以实现车辆的智能巡航控制。

此流程分为四个阶段：需求分析阶段、乘员操作程序(COP)设计阶段、顶层(TLD)设计阶段和数据接口控制文件(ICD)设计阶段。

##### (1) 需求分析

需求分析主要是在对使用方需求进行充分解析的基础上，划定系统的功能范围和边界。设计系统用例为巡航，两个子用例包括定速巡航和防撞预警，使用对象包括驾驶员、发动机电控系统、制动系统和前方车辆。使用对象与系统用例之间发生的交互已建立好关联关系，子用例建立包含主系统的关系。

建立用例图CruiseSystemCase，绘制以下关系：

![Cruise用例图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Cruise%20use%20case%20diagram.png)

在ICCS巡航场景主题下，自动巡航系统是直接和参与者交互的系统，其需要定速巡航和防撞预警子系统协同工作来完成，防撞预警系统具有传感器和碰撞预警两个组件，碰撞预警仅当有碰撞可能时才触发，基础巡航系统具有传感器、巡航控制和驾驶操纵三个组件，三个组件需要彼此配合完成工作。

依照自动巡航系统的速度要求和传感器可靠性要求绘制的需求图RequirementDiagram如下：

![Cruise需求图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Cruise%20demand%20figure.png)

对自动巡航系统包的需求可具体分解为对巡航速度、安全距离、响应时间和风险控制的需求。巡航速度又可分解为巡航速度范围的需求和错误速度纠正的需求；响应时间对巡航速度响应时间、碰撞警告时间事件和车距测量时间等提出了需求；误差控制主要体现在速度测量误差和距离测量误差两方面。在第三层的需求中，合理速度范围设定、传感器灵敏度、传感器可靠性、碰撞处理时间和风险评估速度作为工程中需要满足的需求继承了以上两层需求的主要考量。



##### (2) 乘员操作程序

COP设计阶段主要分析车辆信息系统的基本功能和工作模式，提出乘员的操纵和显示要求，规划各个工作模式下乘员完成任务的方式与能力。

智能巡航系统的工作流程如下：由驾驶员启动车辆的巡航功能，并设置巡航车速。系统向发动机电控系统实时接受车速信号，测量前后车距，计算当前车速下的预计碰撞时间，判断是否进入定速巡航的模式。若进入定速巡航模式，则通过控制发动机转速，将车速自动保持在一设定的范围内。同时在巡航状态下，检测驾驶员操作行为，如果驾驶员踏下制动踏板、加减油门或操纵巡航取消开关，则可自动解除智能巡航功能；若进入到防撞预警模式，则系统根据传感器探测与纵向车辆的相对距离、速度和加速度进行综合分析和风险评估，若处于危险的状态下，则进行危险提示，提醒驾驶员进行人工干预，保证驾驶安全。

建立活动图CruiseBlackBoxView，描述的活动如下：

![Cruise状态图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Cruise%20state%20diagram.png)

驾驶员在驾驶期间启动智能巡航并且输入巡航速度即可触发系统工作，系统实时测量车速和前车车距，计算出与前车碰撞的预计时间，如果时间小于10秒就触发风险计算，如果有碰撞危险就发出警告并降低车速；如果碰撞时间超过十秒系统就保持匀速行驶。匀速巡航时如果驾驶员按下巡航按钮、踩下油门或者刹车可终止智能巡航。



##### (3) 顶层设计

COP设计阶段完成后，TLD设计阶段主要分析明确信息系统的架构和功能部件，对智能巡航系统的内部结构进行设计，并运用活动图和时序图设计系统部件的功能分配以及系统信息流。如图所示，智能巡航系统由传感器、巡航系统控制器模块、操纵模块和预警模块4个部件组成，系统与功能部件之间有明确的从属关系。

建立模块定义图CruiseSystemBDD如下：

![Cruise模块定义图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Cruise%20module%20definition%20diagram.png)

模块定义图主要体现了智能巡航系统的主要结构特征，主要划分为操纵模块、控制模块、传感器和预警模块。操纵模块主要用于侦听用户的巡航请求，然后向控制模块进行传达，主要功能有启动巡航、终止巡航和设定巡航速度；控制模块是系统的核心，处理巡航请求、速度设定与控制、碰撞时间的计算和碰撞风险的评估等主要功能；传感器主要测量与前车的距离、实时车速和踏板状态等数据；预警模块会在巡航模式启动和关闭时给出提示，在具有碰撞风险时给出警示。

根据模块的定义，在时序图中为智能巡航系统的功能部件建立4条泳道，将功能分配到各功能部件的泳道中。在描述系统工作流的同时，明确功能模块的责任对象。运用时序图设计智能巡航系统的信息流。如图所示，首先驾驶员通过操纵模块启动车辆智能巡航的功能键，然后操纵模块将信号发送给控制器模块请求处理，控制器模块再向其他的功能部件发送操纵指令。信息流在系统内的不同功能部件之间以及驾驶员等外部使用对象之间进行传递。除了在时间轴上的顺序表达以外，在不同的标定区域内，还对信息流的逻辑进行了控制。

绘制的时序图CruiseSystemSequenceD如下：

![Cruise顺序图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Cruise%20sequence%20diagram.png)

由于papyrus的顺序图绘制开发不完善，绘制过程中多次错误导致试图混乱和失去响应，本项目中并未能绘制出时序图所有的元素，具体可参照文档12。

依照时序图以及模块定义图中定义的各模块间请求调用和提示信息等数据交互，建立参数图，对巡航请求、速度设定、车速车距测量和防撞预警信号等信号间关系进行约束。

绘制的参数图ParametricDiagram如下：

![Cruise参数图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Cruise%20parameters%20figure.png)

参数图中主要表达如下信息：传感器获取的车速信号与车距信号被碰撞时间计算程序所调用，生成碰撞预测时间，碰撞预测时间与前车的相关数据经过风险测算程序可计算出碰撞风险，并且生成警示请求，碰撞风险和碰撞预测时间决定了巡航模式的切换。



##### (4) 数据接口控制

ICD设计阶段主要是在确定系统功能和架构的基础上明确各部件的功能接口和信息接口。最后一步以TLD阶段设计的信息流为依据，采用装配图设计智能巡航系统的4个功能部件和驾驶员等外部使用对象的端口，并将它们连接起来。同时4个功能部件中封装有隶属于该部件的接口、功能和操作，最终得到系统部件的功能架构包，为下一阶段功能部件的设计提供一个清晰明确且在系统层面得到仿真验证的正确输入。



#### Ⅲ SysML的仿真执行流程(IncrementalComp)

本小节引用参考Papyrus/ModelExecution指导，旨在使用Papyrus插件基于SysML的图搭建系统模型，然后进行仿真执行的过程，并不要求使用所有的SysML的图。通过仿真过程中提供的关于这一系统的定量分析结果，作为决策的理论依据。

在SysML仿真的过程中需要使用到Moka，Moka是Papyrus中一个用于执行UML模型的模块，它本身包含了一个符合OMG标准的基础UML和组合结构的精确语义的执行引擎。其与Eclipse调试框架集成在一起，提供了控制、观察和动画设备的执行。Moka可以很容易地扩展，以支持可选的执行语义，因此可以适应多个使用场景和域，其关键特性是:基于标准、交互式执行、可扩展框架。SysML是在UML2.0 的子集进行重用和扩展的基础上提出的，因而也能实现仿真。

本过程基于一个简单的可执行模型“自增计数器”。它包含在一个活动类中，带有一个分类器的行为，它可以无限地增加计数器。相应的Papyrus模型可在代码仓库中找到，拥有SysML和UML两个版本用于对比参考。

##### (1) 模块定义图绘制

绘制模块定义图Increment class diagram：实现自增操作只需在类中定义一个整形计数参数和一个用于实现自增的方法。创建公有Increment块，属性勾选active；添加内容counter，数据类型为Integer整形，属性勾选unique多重性为1；添加公有操作increment，关联其方法为IncrementMethod，没有参数Owned prameter。

建立的模块定义图如下：

![Increment模块定义图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Increment%20module%20defines%20the%20diagram.png)



##### (2) 活动图绘制

活动图用于描述类中increment自增方法，此工程中拆分为IncrementClassifierBehavior自增行为和IncrementMethod自增方法两部分进行绘制。

自增活动图主要描述仿真的整体过程，在自增活动图中，位于左侧的This自读取活动与位于上方的0值说明活动通过Set counter“结构特征值添加活动”时实现将0值置入到This.counter中，然后经初始化的计数值进入到右下方的循环中，此循环的主要功能为自读取后的计数器对象循环进入到右方的increment操作调用活动来实现自增。

自增行为活动图IncrementClassifierBehavior如下：

![Increment自增行为状态图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Increment%20state%20diagram%20of%20behavior.png)

随后计数器对象进入到IncrementMethod自增方法中进行每一次赋值的操作，自增方法图主要描述incremen方法每一次执行的过程，首先由This自读取活动读取出此次调用对象，通过分支节点分为对象和计数值两路。通过上方对象流到达SetCounter的对象则等待下一次的赋值；通过下方对象流到达readcounter"结构特征读取活动"读取出result即为当前的counter计数值，其与1值说明活动通过add行为调用活动实现了counter++的操作，操作后的result进入SetCounter活动赋给计数值对象后即完成了一次方法的调用。

自增方法活动图IncrementMethod如下：

![Increment自增方法状态图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Increment%20state%20diagram%20of%20the%20method.png)



##### (3) 启动Moka执行

在定义完成的活动块Increment上选中Moka生成Factory要素，块中将生成新的<<Create>>increment方法和Increment_Factory行为图用于执行仿真实验。此时需要保存模型，新生成工厂活动将在下一个步骤中使用，以实际启动该模型的执行。

![Moka启动](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Moka%20start.png)

生成工厂活动后的块由以下文件组成，如有文件缺少仿真将无法执行，需要重新检查模型建立过程中的错误。

![Increment可执行块结构](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Increment%20executable%20block%20structure.png)

Moka与Eclipse调试框架集成在一起。这意味着，为了启动一个执行，必须定义启动配置。可以通过单击Eclipse工具栏上的“Debug”工具来创建启动配置，然后按下调试配置。在Moka加载配置中新建一项，Model选中模型文件夹下的.uml文件，可执行元素选择生成的Factory工厂活动，执行引擎根据需要进行调整，可选择org.eclipse.papyrus.moka.composites，然后应用点击调试即可。

![Moka调试配置](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Moka%20debug%20configuration.png)

执行后的自增计数器中的counter计数值可在Debug变量窗口中进行观察。Moka在调试过程中会以动态流的形式在各个图中流动，其代表正在经过的元素，方便调试时的观察，在右下角Animate中可以调整一次动画的延迟时间，改变运行的速率。

Moka中调试Increment结果验证过程如下：

![Increment result validation](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Increment%20result%20validation.png)

在read counter出设置一个断点，第一次读取时counter为初始值0，继续运行至第二次到达断点，此时counter的值更改为1。以此类推，counter在每次执行过程中均执行了自增操作，模型建立正确达到预期要求。



##### (4) 总结

建立模型的仿真实验执行需要依靠于详细的模块定义图和活动图绘制，还可建立参数图作为模型的辅助描述。向仿真执行引擎完整的描述模型的结构和行为要素用于执行，参数要素用于产生定量分析结果验证既定的需求要素，从而完成对模型的验证。

1. 活动图绘制

Papyrus插件在调色板工具中提供了大量的原件用于模型定制，下文简单介绍活动图中常用的的各原件的作用和使用。

活动图的调色板主要分为节点与边两类，边中有控制流、对象流、关联和异常处理四种边元素，其中控制流和对象流较为常用。结点主要分为发送及呼叫节点、对象操作节点、特征结构节点和变量节点等几类节点。

对象流Object Flow表示一个事件、能量或者数据的实例通过活动，因此必须确保对象流两端的对象节点拥有兼容的类型。一个对象流具有可见性Visibility、负载Weight和转换监视Guards属性设置，负载指同一时间可通过对象流的对象，转换监视用于判断边界两端是否可转换。

控制流Control Flow表示一种传递控制令牌的边，当活动中对象流无法传达活动节点时，可以使用控制流来启动一系列动作。控制流同样拥有可见性Visibility、负载Weight和转换监视Guards属性设置，但负载通常设置为0。

边元素在调色板中表示如下：

![Palette边元素](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Palette%20edge%20element.png)

呼叫节点具有行为呼叫节点Call Behavior和操作呼叫节点Call Operation Action两种可供选择。行为呼叫节点具有端口On Port、操作Operation和目标Target的属性，目标为对象流对象输入，操作为输入对象需要执行的类方法，如类方法与另一活动图关联则切换为另一图执行；操作呼叫结点具有行为Behavior、端口On Port和参数内容Argument的属性，行为可配置为类方法，也可调用工厂模型的库方法，参数内容指行为执行需要的几个输入参数。

发送节点具有发送对象节点Send Object Action和发送信号节点Send Signal Action两类。发送对象节点具有端口On Port、要求Request和目标Target等属性，要求参数作为触发对象发送的条件，目标参数为输入栓获取的对象流对象；发送信号节点需要配置端口On Port、信号Signal、参数内容Argument和目标Target等属性。

类对象相关节点包括创建对象节点Create Object、销毁对象节点Destroy Object Action、对象自读取活动节点ReadSelfAction、转换类Reclassify和判断类Read Is Classified结点。对象自读取节点不需要输入，其附加栓pin上的对象流输出即为当前活动图中的类对象；创建对象节点具有实例Classifier和结果Result两种属性，对象流输出为未初始化的类对象；销毁对象节点仅有一个输入栓，对应属性为目标Target；转换类用于实现两种类之间的转化，可选择辅以前置和后置条件完成。

特征结构相关有三种节点，分为特征结构读取节点Read Structual Feature、特征结构添加结点Add Structual Feature和特征结构清除节点Clear Structual Feature。特征结构添加节点具有对象Object、取值Value、结果Result和特征结构Structual Feature四种属性，输入栓从两路对象流中分别读取对象和值，然后将值赋予对象配置的特征结构参数中生成结果，再由输出结点置入到对象流中；特征结构读取节点不含有取值属性，其结果为对象配置的特征结构参数取值；特征结构清除节点其结果为特征结构未初始化的对象。

变量相关有两种节点，即变量添加节点Add Variable Value Action、变量读取节点Read Variable Action和值说明节点Value Specification Action等。值说明节点具有结果和值两个属性，其附加栓直接将结果及其取值置入对象流；变量添加节点具有插值对象Insert at、变量Variable和取值Value等属性，插值对象由输入栓从对象流中获取，然后可将变量和取值赋予对象；变量读取节点具有结果Result和变量Variable等属性，结果即为变量的取值。

常用活动节点有结构活动节点Structured Activity和不透明活动节点Oopaque Action。结构活动节点仅表示一个具有可见性配置的结构；不透明活动节点可设置编程语言Language属性。

此外还有链接活动Link Action和扩大Expansion Node两类节点。

节点元素在调色板中表示如下：

![Palette节点元素](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Palette%20node%20element.png)



2. 模型库文件

在模型浏览器Model Explorer视图中一般可以看见E包模型库<\<EPackage,ModelLibrary>>和基础模型库FoundationalModelLibrary两个库文件夹，E包模型库是基本类型库SysMLPrimitiveTypes中的一部分，用于定义参数的数据类型，基础模型库则是定义了活动图中可能会用到的一些基本操作。以下介绍基础模型库中各个行为Behavior。

基础模型库FoundationalModelLibrary的基本结构如下：

```java
FoundationalModelLibrary/
├── PrimitiveBehaviors/
│   ├── PrimitiveTypes/
│   │   ├── <<EDataType>> Boolean
│   │   ├── <<EDataType>> Integer
│   │   ├── <<EDataType>> Real
│   │   ├── <<EDataType>> String
│   │   └── <<EDataType>> Unlimited Natual
│   ├── IntegerFunctions/
│   │   ├── ToInteger ToString ToUnlimitedNatual
│   │   ├── + - * /
│   │   ├── < > <= >=
│   │   ├── Div Neg Mod
│   │   └── Max Min Abs
│   ├── RealFunctions/
│   │   ├── ToInteger ToString ToReal
│   │   ├── + - * /
│   │   ├── < > <= >=
│   │   ├── Neg Floor Round Inv
│   │   └── Max Min Abs
│   ├── UnlimitedNatualFunctions/
│   │   ├── ToInteger ToString ToUnlimitedNatual
│   │   ├── < > <= >=
│   │   └── Max Min
│   ├── BooleanFunctions/
│   │   ├── ToBoolean ToString
│   │   └── Or Xor And Not Implies
│   ├── StringFunctions/
│   │   └── Size Concat Substring
│   └── ListFunctions/  
│       └── ListSize ListGet ListConcat
├── BasicInputOutput/
│   ├── Common/
│   │   └── Notification Listener Status
│   ├── Channel/
│   │   ├── open close
│   │   └── isOpen getStatus gatName
│   ├── InputChannel/
│   │   ├── Generalization Channel
│   │   └── hasMore read peek
│   ├── OutputChannel/
│   │   ├── Generalization Channel
│   │   └── write isFull
│   ├── TextInputChannel/
│   │   ├── Generalization InputChannel
│   │   ├── readCharacter peekCharacter
│   │   └── readLine readInteger readBoolean readUnlimitedNatual
│   ├── TextOutputChannel/
│   │   ├── Generalization OutputChannel
│   │   ├── wrierString writeNewLine writeLine
│   │   └── writeInteger writeBoolean writeUnlimitedNatual
│   ├── StandardInputChannel/
│   │   └── Generalization TextIutputChannel
│   ├── StandardOutputChannel/
│   │   └── Generalization TextOutputChannel
│   ├── ActiveChannel/
│   │   ├── register unregister
│   │   └── Generalization Channel
│   ├── WriteLine
│   └── ReadLine
└── Common/
    └── Notification Listener Status
```

模型库主要分为原始动作PrimitiveBehaviors和基本输入输出BasicInputOutput两部分，公共包Common属于基本输入输出中的一部分。原始动作部分的函数在活动图中通过Call Behavior Action节点实现调用，基本输入输出函数则需要调用Call Operation Action节点，其位于Broadcast Signal Action一组中。

原始动作主要包括原始数据类型定义PrimitiveTypes以及各数据类型函数TypeFunctions两部分，原始数据类型与基本类型库中的定义完全一致，有布尔Boolean,整形Integer,实数Real,字符串String和无限制自然数Unlimited Natual共五种类型；在每种数据类型各自自定义了类型转换函数、二元算术函数、关系运算函数和逻辑运算函数等少量可用函数；在布尔类型下提供了位运算函数，字符串和列表类型下提供了合并、切割、获取等操作。

基本输入输出中定义了通知、侦听器、状态三种公共类型，通道Channel划分为输入Input和输出Output两种，并向下衍生出文本输入输出通道Text和标准输入输出通道Standard，补充了以行写入WriteLine和行读取ReadLine为基础的多种操作。



#### Ⅳ SysML建模后的Java代码生成

Java 代码生成插件主要由以下三部分组成：包含转换规则的org.eclipse.papyrus.designer.languages.java.codegen；从 UI 调用时的转换起始点 ：org.eclipse.papyrus.designer.languages.java.codegen.ui；用来支持 JDT 项目创建的微小插件：org.eclipse.papyrus.designer.languages.java.jdt.project。

Papyrus支持为建立好的SysML模型中的指定类或者包生成代码，如图所示，代码的生成需要以下操作：在一个图表或者模型资源管理器中右键点击一个类或者包，选择Designer > Generate Java code，接下来会弹出一个新建JDT 项目的对话框，确认信息后一个新的java项目会被生成。

![java代码生成](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/java%20code%20generation.png)

当使一个类生成的代码时，与其具有相关关系的类也会被生成。这些关系包括依赖关系、 继承关系和泛化关系等。所生成代码的包，其中的所有类和与它们关联的类都将会生成。例如IncrementalComp项目中由Increment块生成的java代码如下：

```java
// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Incremental.IncrementalCompute;

/************************************************************/

public class Increment {
	private int counter;
	public void increment() {
	}
	/**
	 * 
	 * @return 
	 */
	public Increment() {
	}
};
```

由于绘制的SysML模块定义图中，Increment块只给出了一个整形计数参数和一个用于实现自增的方法，因此在java代码中只存在counter，increment()和构造函数三部分，而函数体的具体内容需要后续补充。

而对于CarStatistics项目中具有组合关联的CruisingSystem类，其生成的类声明如下：

```java
// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package CarStatistics;

/************************************************************/

public class CruisingSystem {
  
	public class OperateModule {
		public int CruisingRequest;
		public int SpeedSet;
		public int GiveSpeedSet;
      
		public void EnableCru() {
		}
		public void DisableCru() {
		}
		public void SpeedPress() {
		}
		public void SpeedSetGet() {
		}

		public OperateModule() {
		}
	};

	public class ControlModule {
		public int SpeedValue;
		public float CollisionTime;
		public float RiskValue;
		public int CollisionState;

		public void StartCru() {
		}
		public void StopCru() {
		}
		public void CruSpeedDeal() {
		}
		public void CollisionTime() {
		}
		public void CollisionRisk() {
		}
	};

	public class WarningModule {
		public int WarningState;
		public boolean RedLight;
		public int CollisionState;
      
		public void StartCruPrompt() {
		}
		public void StopCruPrompt() {
		}
		public void AlertState() {
		}
		public void LightState() {
		}
	};

	public class Sensors {
		public void GetPreDist() {
		}
		public void GetCarSpeed() {
		}
		public void GetThrottleSignal() {
		}
		public void GetPedalSignal() {
		}
		public void GetButtonSignal() {
		}
	};

  	public Sensors sensors_1;
	public WarningModule warningmodule_1;
	public ControlModule controlmodule_1;
	public OperateModule operatemodule_1;
	/**
	 * 
	 * @return 
	 */
	public CruisingSystem() {
	}
};
```

可见，由Papyrus生成的java代码只是简单地根据模块定义图中类的结构特性而生成的类的框架，代码的生成主要是参考结构图中类的静态视图来构建的，其并没有参考行为图中类的动态特征，因而也没有给出函数体。其主要参照的模块定义图属性如下：块的可见性Visibility、抽象特性abstract、拥有属性Owned attribute、操作Owned operation和关联关系Association；属性的派生特性derived、静态特性static、可见性Visibility、数据类型Type和多重性Mutiplicity等；操作的静态特性static、抽象特性abstract、可见性Visibility和参数Owned parameter等。类中这些属性决定了其所生成的java代码框架。因此，由SysMLBDD图到类的java代码框架转换，使其适合于建立具有复杂关系的工程模块，模块内部属性以及模块间关系的准确表达有助于java代码的正确生成，因而减少工作量。



#### Ⅴ SysML建模的Java逆向工程

IncrementalComp项目中用于实现Increment块对应功能的java代码如下：

```java
package Incremental.test;

class Increment {
	private int counter;
	public void increment() {
		this.counter=this.counter+1;
	}

	public Increment() {
		this.counter=0;
	}
};

public class IncreTest{
	public static void main(String args[]) {
		Increment ins=new Increment();
	    for(int i=0;i<100;i++) ins.increment();
	}
}
```

避免无限循环，此处循环次数设定为100。

实现Java文件或包逆向生成Papyrus模块定义图，有如下两种方式：

1. 命令行方法

创建一个Papyrus项目，创建并打开一个Papyrus class diagram；选中一个Java类或包；单击Papyrus class diagram右上角的Reverse按钮；此时，在左侧的Model Explorer中将出现被选中的Java类或包的SysML classes；将Model Explorer中的SysML classes加入到Block Difinition diagram即可。

2. Java类或包拖入

创建一个Papyrus项目，创建并打开一个SysML Block Difinition diagram文件；在左侧的Pacakge Explorer中，直接将一个Java类或包拖入Block Difinition diagram文件中并释放，此时将弹出设置对话框；设置对话框中的各项参数，即可生成对应的类图；为了避免每次在弹出的对话框中做大量设置，可以在Eclipse->Preferences->Papyrus->Java Code Reverse设置默认参数。

一个java类及其所有关联的类都会被逆向生成添加到模型，默认情况下进行反向工程会创建名为"generated"包，也可以选择在选项菜单上的另一个包名称。

Increment类的java代码经逆向生成后的模块定义图如下：

![逆向工程生成](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap2/Reverse%20engineering%20generated.png)

生成的类块并没有引入参数和方法，需要手动拖拽置入；对于具有较复杂关联关系的类，Papyrus也只是将各类及其属性放入到Model Explorer，类之间的关系也需要单独建立。



### SysML模型在Papyrus中的执行机理

#### Ⅰ  模型驱动架构理论

##### (1) 元模型体系结构

SysML为系统的结构模型、行为模型和需求模型定义了语义。SysML语义是对现实世界进行抽象和描述的符号系统，这些符号为开发者进行系统建模提供了标准。SysML语义基于SysML元模型，通过元模型可以说明SysML建模概念的语义。元模型由描述模型、构建模型并为模型的实例化和自定义机制提供必要支持的元信息组成，它属于定义模型的模型。

OMG指定的SysML模型包括四层元模型结构：元-元模型、元模型、模型和用户对象。在MOF(Meta Object Facility)规范中，元元模型位于M3层，元模型位于M2层，模型位于M1层，用户对象(实例)位于M0层。

M3层具有最高抽象层，为定义M2层元素和各种机制提供最基本的概念，它通过元素(Element)进行自描述，元素是SysML最底层的模型元素。M3层包括元类、元操作、值规范等。

M2层是元元模型的实例，它提供了表达系统的各种包、模型元素的定义类型、标记值和约束等。M2层包括状态state、块结构block、泛化和关联关系等。

M1层的每个概念都是M2层概念的实例，这一层用来定义特定领域描述语言的模型，例如定义一个列车运行系统块结构图中的train block，它根据给定个体来表达M0层的沟通语言。

M0层是M1层的实例，任何复杂系统在用户看来都是相互通信的具体对象，其用来实现复杂系统的功能和性能，例如一个列车运行系统的块结构图。

MDA原模型结构如图3.1.所示：
![四层元模型](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap3/mda%20world.jpg)



##### (2) 模型驱动架构开发

模型驱动架构Model Driven Architecture是OMG组织在其提出统一建模语言后又力推的一种新的软件开发框架，是在建模语言的基础上构建的一个更高抽象层次的开发架构。MDA的提出，使得模型执行逐渐趋于可行。

MDA开发方法的核心是模型、元模型和转换规则的概念。元模型通过定义抽象语言来获取模型；转换规则表达了从一个或多个模型中产生一个或多个其它模型的规则。

MDA将抽象层次提升到模型的高度，其理想情况是：开发人员只需要考虑和业务逻辑相关的模型设计，从模型到应用的实现，是和业务无关的、可重复的、低层次的工作，这些工作理应交由机器来实现。

在MDA方法中严格区分了四类模型：计算无关模型(computation Independent Model，cIM)、平台无关模型(Platfor Independent Model，PIM)、平台特定模型(Platform specific Model，PsM)、实现相关模型(Implementation specific Model，IsM)，它们之间是抽象与求精的关系。其中软件系统的模型包括平台无关模型PIM和平台相关模型PsM。PIM是对系统高层次的抽象，其中不包括任何与实现技术相关的信息；PsM是跟特定平台相关的模型。

MDA做的是将业务逻辑从不同的中间件平台中剥离出来，开发人员只需要考虑业务逻辑的建模，得到的是和具体中间件技术细节无关的PIM，在MDA提供的支持下，根据特定平台和实现语言的映射规则，将得到的PIM转换得到对应的加入了技术细节的不同平台上的PsM。即MDA系统将系统模型翻译到一个可执行的应用上，最终生成应用程序代码和测试框架。通过 PIM 和 PSM ， MDA 的目的是分离业务建模与底层平台技术，以保护建模的成果不受技术变迁的影响。



图3.1.1为 MDA 的结构示意图：

![MDA结构视图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap3/mda%20diagram.png)

如图所示，最内环是 MDA 的核心技术： MOF(Meta Object Facility, 元对象设施) 、 CWM (Common Warehouse Metamodel, 公共数据仓库元模型)和 UML 。 MDA 的主要工作就是要把基于这些技术建立的 PIM 转换到不同的中间件平台上，得到对应的 PSM 。中间环上给出的是目前主要针对的实现平台：CORBA, XML, Java, Web Services 和 .NET等。



##### (3) 平台无关模型

模型驱动开发MDD是一种基于模型转换的开发方法，整个系统起源于模型。在系统工程领域的MDD中，开发者在一个基于SysML的抽象层上生成适当的开发工件，这些工件以SysML模型的形式存在。建模人员构建的是平台无关模型，PIM获取和表达目标系统的所有业务需求，是系统功能、行为和结构的形式化表示。

系统的每个主题事务都由一个PIM来表示。根据信息、行为和操作的分层规则，平台无关模型由三个层次构成：第一层是基于信息的静态结构层，它是PIM的基石，描述了系统内各个功能模块以及相互之间的关联关系。第二层是基于行为的动态行为层，它描述了静态结构层对象对于异步信号激励和同步调用的行为特征。第三层是基于操作的动作规约层，动态行为层中对象的行为特征在这里被详细定义。

“形式化”要求构建模型的建模语言具有良定义的语法语义，目前用于构建PIM的建模语言主要是UML和SysML。由于PIM的目标是抽象出系统的业务逻辑，所以在使用UML和SysML对系统进行面向对象分析时，描述模型的静态结构和动态行为等建模工作都必须严格限制在业务逻辑的范畴之内。

合理的平台无关模型可以组织成大规模的高内聚低耦合的可复用组件，减少测试目标系统的时间和开销，保障了系统的质量和安全性。



#### Ⅱ 可执行SysML原理

##### (1) 可执行SysML

SysML作为面向对象的标准符号系统并不足以建立精确的平台无关模型。SysML为了保持描述的清晰易懂，在给出自身语义说明以及描述PIM时都采用半形式化方法，该方法降低了平台无关模型的精确性，不利于PIM的自动分析和验证。其原因如下：

1. SysML表示法没有统一上下文环境。SysML跟UML一样规定了一个图形语言，使得系统可以通过一组不同类型的图式系统化地定义。但SysML在这些图形的使用方法上并不正规，如状态模型用来表示用例、子系统以及对象。这就要求用户必须首先确定所读图形的上下文才能理解它；
2. SysML包含许多语义较弱的元素，不足以进行精确建模。简单使用所有SysML的表示法很容易产生出令人难以理解的模型，这样不利于处理问题的复杂性。并且SysML本身没有提供一个对SysML模型进行推理的合理机制。

在系统工程领域，由于SysML本身的不精确性，使用原生SysML建立PIM不能满足验证PIM的需求。利用SysML的子集和动作规约语言定义具有精确语义的xSysML(eXecutable SysML)，使工具在xSysML基础上建立具备特定模型结构的可执行PIM，则能够满足针对平台无关模型进行验证的需求。



SysML的完备子集解决了SysML模型缺乏统一上下文环境的问题，规范了SysML视图的使用方法。SysML子集中符号的选择是基于现实世界中的结构，而不是基于在某个软件系统的构造中用到的个别结构。这些符号本身是简单的，而且组织和集成它们的方式也必须遵循严格的规则，这才能够保持整个系统规约的清晰性。

然而该完备子集中的语义不足以在平台无关的层面上实现可执行的目的，它还需要精确语义的平台无关动作规约语言的支撑，其遵从OMG的动作语义，并且与SysML元素兼容。核心SysML加上动作语义就成为可执行SysML，其用动作规约语言对SysML进行扩充，使得模型可以被更精确地描述，得到可执行的平台无关模型PIM，同时可执行SysML去掉了庞大体系中语义较弱的部分，解决了SysML歧义问题，使得建模过程更加简洁明了。

可执行SysML就是SysML的一个可执行版本，它还包括了：一个被清洗定义的简单模型结构；精确的动作语义；一个适应性很强的动作规约语言；一个配套的关键过程MDA。



##### (2) 平台无关动作规约语言

可执行SysML中关键的一环就是动作语言，动作语言能够精确描述对象行为，能够使建立的模型是可执行，动作语言是抽象的、独立于各种程序编程语言。几种运用比较广泛的动作语言如下：

1. SMALL：SMALL 是Shlaer-Mellor Action Language的缩写，最后一个L是没有意义的，这个语言是由Stephen J.Mellor 创造的。GregoryRochford和Cortland D.Starrett建立了一个解析器来验证SMALL语法。

2. TALL：TALL 是That Action Language的缩写，最后一个L没有意义。这个语言是由Marc J.Balcer, Conrad Bock 和Dirk Epperson共同创造的。

3. Object Action Language：动作对象语言由Project Technology, Inc.公司发布，OAL被用于定义模型中过程的语义。在由Project Technology, Inc. 公司发布的BridgePoint CASE 中，OAL可被用于以下几个模型元素中：对象状态、定义两个域模块之间的桥程序、对象的函数、基于类和对象的操作和基于对象属性的操作。基于OAL建立的模型有以下特点：建立的模型可以自动转换到目标系统；动作语义能够被开发人员和阅读人员理解；面向对象模型能够被模拟执行；能够推到生成时间和访问数据信息。

4. Action Specification Language：动作规约语言ASL是一个与实现语言无关的动作语言，通过它可以使模型成为可执行和可验证。这个语言由Kennedy Carter公司发布。ASL 是满足"Precise Action Semantics"的，它是UML 标准的一个扩展。当ASL 被执行时，模型变得更加容易理解。

   动作规约语言ASL是可以被用来描述操作和动作的一种合适的具有良定义语法的描述形式。它有一个附加的好处就是它可以使模型可执行。ASL提供了操纵模型元素的能力，该语言具有抽象特性，又具有无歧义的被完全详述的语义。

   这种方法建立的模型有发下特征：是被完全规范的、客观的完成标准，模型要么能够正确工作，要么不能；可以自由地选择实现方式，但是不可能改变系统行为；当被执行的时候，模型变得更加容易理解，因为可以从实例中被观察；使用了一个语义精确的子集，因此消除了对模型的歧义解释；允许对量化模型进行早期的精化，并提高了对模型的信心，且能够被定性评估。

   ​



#### Ⅲ Moka工具执行机理

Moka是一种用于执行UML模型的Pyparus模块，它本身包括了一个符合OMG标准的基础UML(fUML)和UML组合结构精确语义(PSCS)的执行引擎,这些标准处理UML的执行语义。Moka与Eclipse调试框架集成在一起，提供了控制、观察和动画设备的执行。Moka可以很容易地扩展，以支持可选的执行语义，因此可以适应多个使用场景和域。在Papyrus中SysML模块定义图是在UML类图的基础之上添加和删减部分模型元素扩展形成的，SysML活动图直接复用了UML的活动图，Moka能够实现对SysML语义的理解，因而同样能够进行仿真。

##### (1) J2EE对UML的扩充

PIM和PSM都是用UML语言描述的，但UML并没有针对某个特定的平台，所以在进行基于J2EE平台的开发时，必须对UML进行扩充。这些扩充的内容通常称为UML扩展机制(UML Profile)，UML Profile是UML的标准扩展方法，使用Stereotype(构造型)、TaggedValue(标记值)和Constraint(约束)三种扩展机制。

UML Profile配置文件也用MOF元对象机制来描述，一个UML Stereotype构造型是MOF中一个metaclass元类的子类，它把元类metaclass的实例进行了分类，扩充出了新的UML TaggedValue标记值和UML Constraint约束。

UML 支持大量的构造型 ，它们是对UML模型元素进行逻辑上的扩展或改变意义和显示方式，或者修改特征和语法。不同的模型元素具有与它们关联的不同标准构造型。UML标记值是元类的一个属性，用于描述元类的某些信息，一个UML构造型通常有一组UML标记值。UML约束是OCL描述的语义信息，它可以用在所有的模型元素上。

构造型是一种优秀的扩展机制，它把UML中已经定义元素的语义专有化。并且能够有效地防止UML变得过于复杂。构造型扩展机制不是给模型元素增加新的属性或约束，而是在原有模型元素的基础上增加新的语义或限制。构造型在原来模型元素的基础上添加了新的内容，但并没有更改模型元素的结构。



##### (2) 可执行UML

一个可执行的UML模型是一个具有足够详细的行为规范的模型，它可以有效地作为一个程序运行，用于测试和验证模型，并且独立于将要部署的系统的一个或多个实现平台。或者在某些情况下，模型本身在给定一个适当的执行环境时实际上也可以作为生产实现运行。

xUML作为UML的一个配置文件引入，它是UML的扩展，可在更高的抽象层上描述系统的框架和内容。xUML目前已经发展了多个版本，就整体而言，一般都是以UML为基础进行裁减，去除语义较弱的元素，并加入精确动作语义相容的动作语言Action language。

xUML建模要素主要有包图、用例图、类图、协作图、状态图和动作规约语言，其中最重要是类图、状态图和动作语言。xUML主要有以下特点：

不支持实现特定结构，比如聚合和组合；泛化总是被表示为完整的、不相交的；类之间的关联总是被命名的，在两端都有指定角色的动词短语，并且在两端都指定了多重性；关联两端的多重性都仅限于0..1[0对1]、0..\*[0对多]、1[1对1]、1..*[一对多]；数据类型被限制为核心数据类型：布尔、字符串、整数、实数、日期、时间戳和任意ID类型，或下列特定领域的数据类型：数、字符串、枚举和组合；特定于域的数字和字符串数据类型可以表示核心数据类型的子集，特定于域的复合数据类型始终被视为域内的单个单元；对可执行 UML 模型的约束也可以表示为对象约束语言(OCL) 或动作语言。



##### (3) fUML和Alf

foundational UML意为基本UML，受到了可执行UML的影响，它于2011年发布，为包含大多数面向对象和活动建模的UML子集提供了第一个精确的操作和基本语义。Action Language For Foundational UML意为基础UML动作语言，是对象管理组织提出的一种新的标准动作语言，是fUML的表面文本符号。

Alf基本上是一种UML行为的文本符号，它可以被附加到UML模型的任何地方，或者任何一个UML行为都可以。例如，Alf的文本可以直接用于指定状态机上的状态的行为、操作的方法或活动类的分类器行为。此外，“扩展”Alf的符号实际上包含了一些基本的结构建模构造，所以也可以在Alf的整个模型中完成整个模型的基本结构。

fUML的作为基础语言提供了与更大的图形UML模型无缝的语义集成，而Alf的文本可能被嵌入其中。例如，可以使用带有精确fUML执行语义的图形活动图有效地指定中等粒度的流程，然后在基于相同的底层fUML语义的情况下，可以使用Alf在这些过程中指定特定的较细粒度的行为。如果需要使用像Java或C++这样的编程语言作为一个完整的UML模型的上下文环境中的详细的动作语言的话，这样做就避免了语义上的不一致和非标准的规定。



在fUML模型的上下文中，这种表示法使用户更容易地指定行为和活动的规范。实际上，与其用动作节点图形来定义后者，还不如用以下代码段来表示行为：

```Alf
namespace Basic::Maths;
activity multiply(in x:Integer;in y:Integer):Integer{
  return x*y
}
```

为了在Alf的可执行文件中编写一种行为，它需要被转换成纯粹的fUML(即一组动作节点)。Alf的符号和fUML语法子集之间的映射在Alf规范中很明确。图3.1.2展示了Alf与fUML的常见映射关系，函数的参数被映射到活动参数节点，而包含在返回语句中的主体被映射为将x和y作为参数的行为的调用，这个调用行为的返回输出栓节点与返回活动参数节点用一个对象流进行连接。

![Alf映射关系](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Papyrus%20SysML%20Explore/images_chap3/File%20Alf%20Mapping.png)

PSCS复合结构精确语义与可执行UML的相关理论参照Tutorial文件中的参考文献。



##### (4) Moka工作流程





### 参考

1. OMG官方的SysML教程，参见[链接](http://www.omgsysml.org/INCOSE-OMGSysML-Tutorial-Final-090901.pdf)。
2. SysML有一OMG官方链接参见[HSUV](http://www.omg.org/ocsmp/HSUV.pdf)。
3. Papyrus使用手册，参见[Papyrus_User_Guide](https://wiki.eclipse.org/Papyrus_User_Guide#Create_a_new_Model)。
4. Moka模块使用手册，参见[UserGuide/ModelExecution](https://wiki.eclipse.org/Papyrus/UserGuide/ModelExecution)。
5. Papyrus的举例参见[链接](https://github.com/webgme/sysml/tree/master/examples/Papyrus)。这之中的链接应该非常直观，对研究Papyrus很有帮助。
6. UML学习笔记，用于对比SysML进行参考学习，链接[参见](http://www.cnblogs.com/xueyuangudiao/archive/2011/07/17/2109011.html)。
7. ”系统工程实验室”以及"Snowyying"的博主关于SysML语义的文章，链接1[参见](http://my.csdn.net/SystemEngineeringLab)/链接2[参见](http://www.cnblogs.com/snowyying/p/UML_Package.html)。
8. 蒋彩云, 王维平, 李群. SysML:一种新的系统建模语言[J]. 系统仿真学报, 2006, 18(6):1483-1487.
9. 苏瑾, 李春明, 胡建军,等. 基于SysML的车辆信息系统设计[J]. 指挥控制与仿真, 2013, 35(5):78-83.
10. 黄毅杰. 可执行UML建模技术研究[J]. 中国新技术新产品, 2011(8):28-28.
11. 付佩, 谷青范. 基于UML的可执行模型实现机制研究[J]. 航空电子技术, 2013(1):10-14.
12. 刘玉生, 袁文强, 樊红日,等. 基于SysML的模型驱动复杂产品设计的信息集成框架研究[J]. 中国机械工程, 2012, 23(12):1438-1445.

