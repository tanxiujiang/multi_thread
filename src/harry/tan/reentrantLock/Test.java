package harry.tan.reentrantLock;

public class Test {
    public static boolean useSynchronized = false;



    public static void main(String[] args) {
        IBuffer buff = null;
        if (useSynchronized) {
            buff = new BufferBySynchronized();
        } else {
            buff = new BufferByReentrantLock();
        }

        final Writer writer = new Writer(buff);
        final Reader reader = new Reader(buff);

        // 启动线程
        writer.start();
        reader.start();

        // 启动另外的线程
        new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (;;) {

                    // 等5秒钟去中断读

                    if (System.currentTimeMillis() - start > 5000) {
                        System.out.println("不等了，尝试中断");

                        // 中断线程 如果当前线程没有中断它自己（这在任何情况下都是允许的） 则该线程的 checkAccess
                        // 方法就会被调用
                        reader.interrupt();
                        break;
                    }

                }

            }
        }).start();

    }
}

class Writer extends Thread {
    private IBuffer buff;



    public Writer(IBuffer buff) {
        this.buff = buff;
    }



    @Override
    public void run() {
        buff.write();
    }
}

class Reader extends Thread {
    private IBuffer buff;



    public Reader(IBuffer buff) {
        this.buff = buff;
    }



    @Override
    public void run() {
        try {
            buff.read();
        } catch (InterruptedException e) {
            System.out.println("我不读了");
        }
        System.out.println("读结束");
    }
}