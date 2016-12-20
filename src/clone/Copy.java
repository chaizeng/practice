package clone;



public class Copy {

   public static void main(String[] args){
        People g = new People("张三");  // 定义监护人
        People p1 = new People("儿子1", g);
        People p2 = p1.clone();  // 儿子2的信息通过拷贝儿子1来的
        p2.setName("儿子2");

        p1.getGuarder().setName("李四");  // 将儿子1的监护人改为李四

        System.out.println(p1.getName()+"的监控人是："+p1.getGuarder().getName());
        System.out.println(p2.getName()+"的监控人是："+p2.getGuarder().getName());
    }
}

class People implements Cloneable{
    private String name;
    private People guarder;  // 监护人

    public People(String name) {
        this.name = name;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public People getGuarder() {
		return guarder;
	}

	public void setGuarder(People guarder) {
		this.guarder = guarder;
	}

	public People(String name, People guarder) {
        this.name = name;
        this.guarder = guarder;
    }

    // 拷贝实现
    @Override
    public People clone(){
        People p = null;        try {
            p = (People) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }        return p;
    }
}
