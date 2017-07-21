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
