package harry.tan.future.data;

public class FutureData implements Data {

	private RealData realData = null;
	private boolean isReady = false;

	public synchronized void setRealData(RealData pRealData) {
		if (isReady) {
			return;
		}

		this.realData = pRealData;
		isReady = true;
		notifyAll();
	}

	@Override
	public synchronized String getResult() {
		while (!isReady) {
			try {
				this.wait();
			} catch (Exception e) {
			}
		}
		return this.realData.result;
	}
}
