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
		input.close();
		
		double a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;
		System.out.print("Input the initialization parameters:");
		Scanner parasin=new Scanner(System.in);
		parasin.useDelimiter(",");
		a=parasin.nextDouble();
		b=parasin.nextDouble();
		c=parasin.nextDouble();
		d=parasin.nextDouble();
		e=parasin.nextDouble();
		f=parasin.nextDouble();
		g=parasin.nextDouble();
		h=parasin.nextDouble();
		parasin.close();
		
		Correlation Caculate=new Correlation(a,b,c,d,e,f,g,h);
		for(int i=0;i<maxCirculation;i++){
			Caculate.NextAnum();
			Caculate.NextBnum();
			System.out.print("A:B is "+Caculate.iniAnum+"         :        "+Caculate.iniBnum);
		}
	}
}
