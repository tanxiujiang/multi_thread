package harry.tan.master_worker;

import java.util.Map;
import java.util.Set;

public class TestBymain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 固定5个worker
		Master m = new Master(new PlusWorker(), 5);

		// 提交100个子任务
		for (int i = 0; i < 5; i++) {
			m.submit(i);
		}

		// 开始 计算
		m.execute();

		int res = 0;
		Map<String, Object> resultMap = m.getResultMap();
		while (resultMap.size() > 0 || !m.isComplete()) {
			Set<String> keys = resultMap.keySet();
			String key = null;
			for (String k : keys) {
				key = k;
				break;
			}

			Integer i = null;
			if (key != null) {
				i = (Integer) resultMap.get(key);
			}

			if (i != null) {
				res += i;
			}
			
			if(key != null){
				resultMap.remove(key);
			}
		}
		
		System.out.println(res);
	}
}
