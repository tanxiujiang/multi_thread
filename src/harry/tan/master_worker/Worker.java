package harry.tan.master_worker;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable {

	// 任务队列，用于获取子任务
	protected Queue<Object> workQueue;

	// 子任务处理结果集
	protected Map<String, Object> resultMap;

	public void setWorkQueue(Queue<Object> pWorkQueue) {
		this.workQueue = pWorkQueue;
	}

	public void setResutMap(Map<String, Object> pResultMap) {
		this.resultMap = pResultMap;
	}

	public Object handle(Object input) {
		return input;
	}

	@Override
	public void run() {
		while (true) {
			// 获取子任务
			Object input = workQueue.poll();
			if (input == null) {
				break;
			}

			Object re = handle(input);
			resultMap.put(Integer.toString(input.hashCode()), re);
			System.out.println(Thread.currentThread().getName() + ":" + re);
		}
	}
}
