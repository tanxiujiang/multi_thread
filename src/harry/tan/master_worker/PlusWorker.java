package harry.tan.master_worker;

public class PlusWorker extends Worker {
	public Object handle(Object input) {
		Integer i = (Integer) input;
		return i * i * i;
	}
}
