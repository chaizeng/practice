package aop.cglib;

import aop.j2se.IHappyPeople;
import aop.j2se.PassengerByAir;

public class TestClient {
	public static void main(String[] args) {
		HappyPeopleIntercepter intercepter = new HappyPeopleIntercepter();
		IHappyPeople people = intercepter.getProxy(new PassengerByAir());
		people.celebrate();
	}

}
