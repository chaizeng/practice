package aop.j2se;

public class PassengerByCoach extends BaseHappyPeople implements IHappyPeople{

	@Override
	public void travel() {
		System.out.println("By Coach");
	}

	
}
