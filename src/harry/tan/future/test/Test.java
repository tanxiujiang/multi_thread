package harry.tan.future.test;

import harry.tan.future.client.Client;
import harry.tan.future.data.Data;

public class Test {
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕");

		try {

			Thread.sleep(2000);
		} catch (Exception e) {

		}

		System.out.println("数据：" + data.getResult());
	}
}
