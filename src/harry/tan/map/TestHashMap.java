package harry.tan.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestHashMap {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		final Map<String,String> map = new HashMap<String,String>();
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10000;i++){
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					},"ftf"+i).start();
				}
			}
		},"ftf");
		
		t.start();
		t.join();
	}

}
