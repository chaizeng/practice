package redis;


import redis.clients.jedis.Jedis;
import tool.Tool;

public class Test {
	
	private Jedis redis;
	
	
	public void setUp(){
		redis = new Jedis("192.168.1.101",6379);
		//redis.auth("admin");
	}
	
	/**
	 * ×Ö·û´®²âÊÔ
	 */
	public void testString(){
		redis.set("name", "kevin");
		System.out.println(redis.get("name"));
	}
	
	/**
	 * ¶ÔÏó²âÊÔ
	 */
	public void testObject(){
		User user = new User();
		user.setName("jack");
		user.setAddress("58994949");
		user.setAge(30);
		user.setSex("ÄĞ");
		String key = "jack";
		redis.set(key.getBytes(), Tool.serialize(user));
		
		byte[] bytes = redis.get(key.getBytes());
		Object obj = Tool.deserialize(bytes);
		if (obj != null){
			User newuser = (User) obj;
			System.out.println(newuser);
		}
	}
	public static void main(String[] args) {
		Test test = new Test();
		test.setUp();
		test.testString();
		test.testObject();
		
		
	}

}
