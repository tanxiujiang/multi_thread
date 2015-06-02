package harry.tan.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class BufferByReentrantLock implements IBuffer {
    private ReentrantLock lock = new ReentrantLock();



    @Override
    public void write() {
        lock.lock();
        try {
            long startTime = System.currentTimeMillis();
            System.out.println("开始往这个buff写入数据…");

            // 模拟要处理很长时间
            for (;;) {
                if (System.currentTimeMillis() - startTime > 4000)
                    break;
            }
            System.out.println("终于写完了");
        } finally {
            lock.unlock();
        }

    }



    @Override
    public void read() throws InterruptedException {

        // 如果当前线程未被中断，则获取锁
        lock.lockInterruptibly();
        try {
            System.out.println("从这个buff读数据");
        } finally {

            // 试图释放此锁
            lock.unlock();
        }
    }
}
