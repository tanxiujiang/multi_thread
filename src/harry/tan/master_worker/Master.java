package harry.tan.master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {

	// 任务队列
	protected Queue<Object> workQueue = new ConcurrentLinkedQueue<Object>();

	// worker进程队列
	protected Map<String, Thread> threadMap = new HashMap<String, Thread>();

	// 子任务处理结果集
	protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();

	/**
	 * @function 判断是否所有的子任务都结束了
	 * @return
	 */
	public boolean isComplete() {
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			if (entry.getValue().getState() != Thread.State.TERMINATED) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @funtion Master的构造，需要一个Worker进程逻辑，和需要的Worker的进程数量
	 * @param worker
	 * @param countWorker
	 */
	public Master(Worker worker, int countWorker) {
		worker.setWorkQueue(workQueue);
		worker.setResutMap(resultMap);

		for (int i = 0; i < countWorker; i++) {
			threadMap.put(Integer.toString(i),
					new Thread(worker, Integer.toString(i)));
		}
	}

	/**
	 * 提交一个任务
	 * 
	 * @param pJob
	 */
	public void submit(Object pJob) {
		workQueue.add(pJob);
	}

	// 返回任务结果集
	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	// 开始运行所有的work进程，进程处理
	public void execute() {
		for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
			entry.getValue().start();
		}
	}
}
