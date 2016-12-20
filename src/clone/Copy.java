package clone;



public class Copy {

   public static void main(String[] args){
        People g = new People("����");  // ����໤��
        People p1 = new People("����1", g);
        People p2 = p1.clone();  // ����2����Ϣͨ����������1����
        p2.setName("����2");

        p1.getGuarder().setName("����");  // ������1�ļ໤�˸�Ϊ����

        System.out.println(p1.getName()+"�ļ�����ǣ�"+p1.getGuarder().getName());
        System.out.println(p2.getName()+"�ļ�����ǣ�"+p2.getGuarder().getName());
    }
}

class People implements Cloneable{
    private String name;
    private People guarder;  // �໤��

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

    // ����ʵ��
    @Override
    public People clone(){
        People p = null;        try {
            p = (People) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }        return p;
    }
}
