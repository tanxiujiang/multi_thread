package harry.tan.reentrantLock;

public class BufferBySynchronized implements IBuffer {

    private Object lock;



    public BufferBySynchronized() {
        lock = this;
    }



    @Override
    public void write() {
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buff写入数据…");
            // 模拟要处理很长时间
            for (;;) {
                if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE)
                    break;
            }

            System.out.println("终于写完了");
        }
    }



    @Override
    public void read() throws InterruptedException {
        synchronized (lock) {
            System.out.println("从这个buff读数据");
        }
    }

}
