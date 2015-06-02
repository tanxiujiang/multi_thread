package harry.tan.printlog.main;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PrintLog {
	public static void main(String[] args) {

		final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while(true){
						try {
						    
							String log = queue.take();
							System.out.println(Thread.currentThread().getName()+"取出数据，打印日志");
							parseLog(log);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}	
				}
			}).start();
		}

		for (int i = 0; i < 16; i++) {
			final String log = ""+(i+1);
			{
				try {
				    System.out.println("阻塞队列中准备放入数据");
					queue.put(log);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void parseLog(String log){
		System.out.println(log+"当前时间："+System.currentTimeMillis()/1000);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
