package single;


public class Foo {
	//用volatile修饰，可以阻止Jvm编译器对foo变量的优化
	private static volatile Foo foo;
	
	private Foo() {
		
	}
	
	public static Foo getInstance(){
		if (foo == null) {
			synchronized (Foo.class) {
				if (foo == null) {
					return new Foo();
				}
			}
		}
		
		return foo;
	}
	

}
