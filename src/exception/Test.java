package exception;

public class Test {
	
	public int get() {
		int x =0;
		try {
			x =1;
			System.out.println("try");
			return x;
		} catch (Exception e) {
			x =2;
			System.out.println("catch");
			return x;
		}finally {
			x= 3;
			System.out.println("finally");
		}
	}
	
	public static void main(String[] args) {
		 System.out.println(new Test().get());
	}

}
