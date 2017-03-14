package test;

public class Test {
	
	public static void main(String[] args) {
		Base base = new Base();
		base.print();
		Sub sub = new Sub();
		sub.print();
		
		base = sub;
		base.print();
		
		sub = (Sub)base;
		sub.print();
		
	}

}
