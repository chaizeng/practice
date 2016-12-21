package aop.j2se;

public class TestClient {

	public static void main(String[] args) {
		HappyPeopleHandler handler = new HappyPeopleHandler();
		IHappyPeople people = handler.getProxy(new PassengerByAir());
		people.celebrateSpringFestival();
		people.travel();
		
		IHappyPeople pp = handler.getProxy(new PassengerByCoach());
		pp.travel();
	}
}
