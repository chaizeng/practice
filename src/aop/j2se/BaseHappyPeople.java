package aop.j2se;

public abstract class BaseHappyPeople implements IHappyPeople{

	@Override
	public void celebrateSpringFestival() {
		subscribeTicket();
		travel();
		celebrate();
	}

	@Override
	public void subscribeTicket() {
		System.out.println("��Ʊ");
	}


	@Override
	public void celebrate() {
		System.out.println("��ף");
	}

}
