package aop.j2se;

public abstract class BaseHappyPeople implements IHappyPeople{

	@Override
	public void celebrateSpringFestival() {
		subscribeTicket();
		travle();
		celebrate();
	}

	@Override
	public void subscribeTicket() {
		System.out.println("¶©Æ±");
	}


	@Override
	public void celebrate() {
		System.out.println("Çì×£");
	}

}
