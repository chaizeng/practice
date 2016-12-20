package dynamic;


public class Test {
	
 
    public Test() {
    	
	}
	class GrandFather{
		public GrandFather(){
			
		}
		void think(){
			System.out.println("grandfather");
		}
	}
	
	class Father extends GrandFather{
		public Father() {
			super();
		}
		void think(){
			System.out.println("father");
		}
	}
	
	class son extends Father{
		public son() {
			super();
		}
		void think(){
			System.out.println("son");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName("dynamic.Test");
		Test obj = (Test)cls.newInstance();
		(obj.new GrandFather()).think();
	}
}
