package harry.tan.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Test1 {

	@Test
	public void isConnection(){
		Jedis jdeis = new Jedis("192.168.157.128",6379);
		System.out.println(jdeis.ping());
//		System.out.println(jdeis.get("name"));
	}
	
}
