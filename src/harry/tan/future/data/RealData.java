package harry.tan.future.data;

public class RealData implements Data {

	protected String result = "";
	private final int count = 10;

	@Override
	public String getResult() {
		return this.result.toString();
	}

	public RealData(String para) {
		StringBuilder sb = new StringBuilder();
		sb.append(para);
		for (int i = 0; i < count; i++) {
			sb.append(i);
			sb.append(" ");
			try {
				System.out.println("数据构造中..............");
				// 休眠,模拟一个处理比较漫长的操作
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}

		this.result = sb.toString();
	}
}
