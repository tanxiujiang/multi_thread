package harry.tan.future.client;

import harry.tan.future.data.Data;
import harry.tan.future.data.FutureData;
import harry.tan.future.data.RealData;

public class Client {
	public FutureData future = new FutureData();

	public Data request(final String queryStr) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("开始构造数据...........");
				RealData realData = new RealData(queryStr);
				System.out.println("数据构造完毕............");
				future.setRealData(realData);
			}
		}).start();

		return future;
	}
}
