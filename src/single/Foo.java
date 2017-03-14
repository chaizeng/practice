package single;


public class Foo {
	//��volatile���Σ�������ֹJvm��������foo�������Ż�
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
