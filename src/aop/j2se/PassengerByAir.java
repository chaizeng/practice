package aop.j2se;

public class PassengerByAir extends BaseHappyPeople implements IHappyPeople{

	@Override
	public void travel() {
		System.out.println("By Air");
	}

	
}
