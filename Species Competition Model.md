## 种群增长和竞争数学模型及其SysML仿真模拟

刘恒利（成都电子科技大学），田超（傲势科技）

### 引言

Pyparus是一种工业级的开源基于模型的工程工具。在工业项目中，Pyparus已经被成功地使用，成为了几个工业建模工具的基础平台，并且Pyparus也已经成为学术界在教学和研究方面的自然选择。

为了支持基于模型的系统工程，Pyparus提供了对SysML的完全支持，还提供了SysML所需的特定表格和图形编辑器。此外，Papyrus的所有建模特性都是为了可定制和最大化重用而设计的，并且可以进行定制。因而其能够与多种建模语言结合，进行各类系统的综合分析测算，成为系统的一种有效研究方法和有力的研究工具。

得益于Moka，Pyparus可以使用丰富的、可扩展的动画和模拟框架来执行模型。Moka与Eclipse调试框架集成在一起，提供了控制、观察和动画设备的执行。Moka可以很容易地扩展，以支持可选的执行语义，因此可以适应多个使用场景和域。

本例将基于实际的数学问题通过SysML进行系统建模，通过Moka仿真为数学问题进行定量分析，提供解决方案支持。

### 

### 问题提出

对生物种群分布数量或密度的研究，在生态学和生物学的研究中有着重要的意义。然而由于生物种群之间受各种复杂的关系制约，要想获得种群在特定时刻的准确分布数量或密度值往往相当困难，甚至没有可能。因此，研究与其等效的稳定状态的数量或密度关系，就有着重要的理论与应用价值。

生存在同一地区的两个种群，由于生存环境相似、生存资源有限，必定会引起两个种群间的竞争，其往往会导致一个种群的数量下降，这可能会造成濒危物种的灭绝。为了保护稀有种群，维护的生态平衡稳定，本文通过对受有限资源限制产生生存竞争种群系统建立数学模型，研究种群间数量变化关系，探究维护种群数量稳定和种群数量恢复的有效方法。

参照文献2的秃杉保护问题的提出，本例具体内容如下：

秃杉属中国特有的世界珍稀植物，现为我国一级保护植物，天然分布于我国湖北省西南部、贵州省东南部及云南省西部等地，垂直分布海拔高度800~2000m。本研究引入Lotka-Volterra生态学数学竞争模型对秃杉林种群建模并进行Moka仿真分析，采用系统、科学、客观的分析方法，利用Eclipse平台对实地调查所得的原始数据进行因子指标分类，然后回归诊断分析得出秃杉与其竞争种群间在不同竞争平衡模式下的内在联系，为进一步确定合理的秃杉林经营密度，制定合理的经营管理措施，提高秃杉林经营管理水平提供科学的理论依据。



### 数学模型建立

20世纪40年代，Lotka和Volterra分别奠定了种间竞争关系的理论基础，他们提出的种间竞争方程对现代生态学理论的发展有着重大影响，该模型因此用两人的名字命名为Lotka-Volterra模型，该模型是对Logistic模型的延伸，是本例解决问题的主要手段。

#### LV种群竞争模型

针对某主要树种与其竞争树种种群进行数学建模，将主要树种、竞争树种设为x1(t)和x2(t)，在单一种群的情况下，主要树种服从Logistic方程：
$$
dx1/dt=r1x1(1-x1/N1)
$$
式中r1表示主要树种的固有增长率；N1表示主要树种的最大容量；1-x1/N1为主要树种的环境阻力，反映了对其增长的资源限制。

当主要树种与竞争木竞争同一环境资源时，主要树种的环境阻力则改变为1-(x1+αx2)/N1，这说明在考虑主要树种的环境阻力时，一个竞争木的存在相当于α个主要树种，则公式变更为：
$$
dx1/dt=r1x1(1-x1/N1-αx2/N1)
$$
同理，竞争木也做类似讨论，得出Lotka-Volterra种群竞争模型如下：
$$
dx1/dt=r1*x1(1-x1/N1-αx2/N1);
$$
$$
dx2/dt=r2*x2(1-x2/N2-βx1/N2);
$$

根据上式求出方程组平衡点极其稳定条件如表所示：

|               平衡点               |       稳定条件       |
| :-----------------------------: | :--------------: |
|            P1(N1,0)             | N2\<N1/α且N1>N2/β |
|            P2(0,N2)             | N2>N1/α且N1<N2/β  |
| P3([N1-αN2]/1-αβ,[N2-αN1]/1-αβ) | N2<N1/α且N1<N2/β  |
|              不稳定平衡              | N2>N1/α且N1>N2/β  |

经过以上分析，平衡点竞争模式有如下三种情况：

在P1竞争模式下，当N1>N2/β且N2<N1/α时，P1点稳定，即当t→∞时，[x1(t),x2(t)]→(N1,0)，它表示在种群竞争过程中，秃杉种群强于其他竞争种群，导致其他竞争种群数量x2(t)→0，在此模式下秃杉获得了绝大部分环境资源而其他竞争种群处于劣势地位；

在P2竞争模式下，当N2>N1/α且N1<N2/β时，P2点稳定，即当t→∞时，[x1(t),x2(t)]→(0,N2)，与最理想竞争模式相反，它表示在种群竞争过程中，其他竞争种群竞争力强于秃杉种群，导致秃杉种群数量x1(t)→0，在此模式下其他树种获得了绝大部分环境资源而秃杉种群处于劣势地位；

在P3 竞争模式下，当N2<N1/α且N1<N2/β时，P3点稳定，即当t →∞时，[x1(t),x2(t)]→([N1-αN2]/1-αβ,[N2-αN1]/1-αβ)，它表示在种群竞争过程中，秃杉种群最终稳定在[N1-αN2]/1-αβ，其他竞争种群最终稳定在N2-αN1]/1-αβ。双方竞争系数持平，会在以后一段时间保持共存共生模式。

在不稳定平衡竞争模式下，相互竞争的物种都能对对方造成抑制作用，其结果是产生暂时的共存共生情况，但由于其不稳定特性，任何可能的改变会造成失衡而转变为P1或者P2竞争模式，由共存共生模式走向其中一方对另外一方优势灭绝的过渡。



#### 微分方程求解

前一小节提出了LV种群竞争模型的非线性常微分方程，在给定x1(0),x2(0)初始种群数量、N1,N2物种环境容纳量、r1,r2物种种群增长率和α,β影响强度的条件下求解某一时刻各种群数量的预测值。本例解决的问题为常微分方程定解问题中的初值问题，求解的数值方法主要有单步法和多步法，单步法分为Euler方法、Taylor方法和Runge-Kutta方法，多步法分为Adams方法和线性多步法。

此处采用显式欧拉方法(折线法)，其算法简单且具有一定的稳定性，避免建模所需元素的复杂性，方便分析和绘图。设置时间步长为1，由给定的LV模型方程有以下递推关系：
$$
x1(t+1)=(1+r1)x1(t)-r1/N1*x1(t)*x1(t)-(r1*α/N1)*x1(t)*x2(t)
$$

$$
x2(t+1)=(1+r2)x2(t)-r2/N2*x2(t)*x2(t)-(r2*β/N2)*x1(t)*x2(t)
$$



#### LV种群捕食模型

假设在某一封闭的生态环境内(自治系统)，捕食者x1以猎物x2为食物，而猎物x1则以此系统近乎无穷无尽的某种生物为食物(例如狼吃野兔，野兔吃草)。令x1(t)为物种x1在時間t时的數量，x2(t) 为x2在此时的数量，则Lotka-Volterra 模型转化为以下形式:
$$
dx1/dt=r1*x1(1-x1/N1+αx2/N1);
$$

$$
dx2/dt=r2*x2(1-x2/N2-βx1/N2);
$$

猎物的种群数量对捕食者增长起到了促进的作用，捕食者数量则增加会导致猎物的数量减少。

采用显式欧拉方法求解微分方程得出递推公式：
$$
x1(t+1)=(1+r1)x1(t)-r1/N1*x1(t)*x1(t)+(r1*α/N1)*x1(t)*x2(t)
$$

$$
x2(t+1)=(1+r2)x2(t)-r2/N2*x2(t)*x2(t)-(r2*β/N2)*x1(t)*x2(t)
$$



### 仿真模型建立：

此处LV种群模型分别提出一个示例问题：

在云南省腾冲县秃杉人工林中，充分考虑不同龄级、不同立地条件，选取秃杉林典型地段设置标准地。标准地为矩形，面积为600(30m*20m)，对标准地内胸径≥3.0cm的所有乔木树种进行每木检尺。记录树种名，测量其胸径、树高、枝下高、冠幅。

现人工林中有秃杉和华山松两个树种，已知一标准地块能够容纳90棵秃杉或60棵华山松，自然条件下秃杉的种群增长率为0.6、华山松的自然增长率为0.8，秃杉对华山松的抑制因素为0.8、华山松对秃杉的抑制因素为1.2。第一年在一地块中种植5棵秃杉树苗4棵华山松树苗，请记录两种种群的数量，预计在第五年时对人工林进行干预以保证秃杉树苗能够在第15年占比达到60%，请问第五年需要采取的措施是什么。

通过建立的微分方程数学模型，定义物种相关关系SpeciesCompete类，其对其中一个物种A的主要参数有当前物种数量iniAnum、 最大容纳量maxAnum 自然增长率AgrowthRate和竞争抑制因素AeffectRate，另一物种以B代替；类方法主要有ValueGive赋值操作、物种数量计算NextAnum和NextBnum操作。

在包中建立SpeciesCompete类，添加记年单位ThisYear，其初值默认为0，其模块定义图如下：

![SpeciesCompete类](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Species%20Competition%20Model/Images-Model/SpeciesCompete%20Module%20definition.png)

其中NextA()和NextB*()用于计算下一年的iniA和iniB数值，GetValue()用于给类赋初值。

如图2，类的主活动图MainActivity如下，首先给类赋初值，左侧的八个变量可自定义数值，中间的MaxYear为需要执行的最大次数即目标年份，在决策节点到合并节点之间的右侧和下侧部分为循环体，右侧按顺序计算每年的种群数量，下册用于更新记年然后判断是否达到目标点。

![MainActivity活动图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Species%20Competition%20Model/Images-Model/Main%20activity%20diagram.png)

如图3，GetValue方法在读取类实体和类参数值之后，依次将参数值赋给实体，ThisYear的默认值为0可在此处修改。

![GetValue活动图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Species%20Competition%20Model/Images-Model/GetValue%20activity%20diagram.png)



如图4，NextA()的主要工作为计算出下一年的iniAnum数值，左侧读取类实体之后获取需要使用到的参数，中间经过一系列计算之后得出结果，最后将结果重新返还到类实体中，同理NextB()的工作也是在同样的结构下完成。

![NextA活动图](http://phabricator.mbsecloud.com/source/JavaPapyrus/browse/master/Species%20Competition%20Model/Images-Model/NextA%20activity%20diagram.png)



### 模型Java代码：

建立Correlation物种关系类，类中的参数取消了year记年，改为在主函数中记录：

```java
package population.compete.calculate;
import java.util.*;

class Correlation{
	public double iniAnum;
	public double maxAnum;
	public double AgrowthRate;
	public double AeffectRate;
	public double iniBnum;
	public double maxBnum;
	public double BgrowthRate;
	public double BeffectRate;
	
	public void NextAnum(){
		this.iniAnum=(1+this.AgrowthRate)*this.iniAnum-this.AgrowthRate*this.BeffectRate/
				this.maxAnum*this.iniAnum*this.iniBnum-this.AgrowthRate/this.maxAnum*this.iniAnum*this.iniAnum;
	}
	
	public void NextBnum(){
		this.iniBnum=(1+this.BgrowthRate)*this.iniBnum-this.BgrowthRate*this.AeffectRate/
				this.maxBnum*this.iniBnum*this.iniAnum-this.BgrowthRate/this.maxBnum*this.iniBnum*this.iniBnum;
	}
	
	public Correlation(double a,double b,double c,double d,double e,double f,double g,double h){
		this.iniAnum=a;
		this.iniBnum=b;
		this.maxAnum=c;
		this.maxBnum=d;
		this.AgrowthRate=e;
		this.BgrowthRate=f;
		this.AeffectRate=g;
		this.BeffectRate=h;
	}
}

public class SpeciesNum {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.print("Input the target year:");
		Scanner input=new Scanner(System.in);
		int maxCirculation=input.nextInt();
		input.nextLine();
		
		double a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;
		System.out.println("Input the initialization parameters:");
		System.out.print("[ iniAnum=\t");a=input.nextDouble();
		System.out.print("  iniBnum=\t");b=input.nextDouble();
		System.out.print("  maxAnum=\t");c=input.nextDouble();
		System.out.print("  maxBnum=\t");d=input.nextDouble();
		System.out.print("  AgrowthRate=\t");e=input.nextDouble();
		System.out.print("  BgrowthRate=\t");f=input.nextDouble();
		System.out.print("  AeffectRate=\t");g=input.nextDouble();
		System.out.print("  BeffectRate=\t");h=input.nextDouble();
		System.out.println("]");input.close();
		
		Correlation Caculate=new Correlation(a,b,c,d,e,f,g,h);
		for(int i=0;i<maxCirculation;i++){
			Caculate.NextAnum();
			Caculate.NextBnum();
		}
		System.out.print("A:B is "+Caculate.iniAnum+" : "+Caculate.iniBnum);
	}
}


```



### 参考文献

1. 毛凯, 李日华. 种群竞争模型的稳定性分析[J]. 生物数学学报, 1999(3):288-292.
2. 李骄, 许彦红, 吉灵波. 基于Matlab的秃杉种群竞争数学模型仿真分析[J]. 江苏农业科学, 2014, 42(7):175-178.
3. 姜玉秋, 华极鑫, 韩璐. 棕榈树和桉树竞争系统的稳定性分析[J]. 吉林师范大学学报(自然科学版), 2013, 34(4):44-46.