package j2se;

public class TestClient {

	public static void main(String[] args) {
		IHappyPeople people = new PassengerByAir();
		people.celebrateSpringFestival();

		people = new PassengerByCoach();
		people.celebrateSpringFestival();
	}
}
