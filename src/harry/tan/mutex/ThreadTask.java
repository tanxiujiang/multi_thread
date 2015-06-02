package harry.tan.mutex;

public class ThreadTask {
    private int controller = 0;



    public synchronized void firstTask(int executeTimes, int ctrlWaitValue, int loopTime) {
        while (controller % 2 == ctrlWaitValue) {

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < executeTimes; i++) {

            System.out.println(Thread.currentThread().getName() + " 开始第 " + i + " 次执行！第  " + loopTime + " 主循环！");
        }
        controller++;
        notifyAll();
    }
}
