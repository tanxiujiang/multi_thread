package harry.tan.list;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestList {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final A a = new A();
		
		for (int i = 0; i < 100; i++) {
			 new Thread(new Runnable(){
				 final AA aa = new AA(a);
				@Override
				public void run() {
					aa.add();
					System.out.println("result:" + A.count);
				}
				
			}).start();
		}
		
		
	}
	
}

class A {
	public static int count=0;
}

class AA {
	
	A a;
	
	public AA(A a){
		this.a = a;
	}
	
	public void add(){
		synchronized (a) {
			a.count++;
		}
	}
	
}

