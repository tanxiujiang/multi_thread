package harry.tan.mutex;

public class ThreadExclusiveTest {

    /**
     * <method description>
     * 
     * @param args
     */

    public static void main(String[] args) {

        final ThreadTask tt = new ThreadTask();
        new Thread(new Runnable() {

            @Override
            public void run() {

                int i = 0;
                while (i < 50) {

                    tt.firstTask(100, 0, i + 1);
                    i++;
                }
            }

        }, "B线程").start();

        new Thread(new Runnable() {

            @Override
            public void run() {

                int i = 0;
                while (i < 50) {

                    tt.firstTask(10, 1, i + 1);
                    i++;
                }
            }

        }, "A线程").start();
    }

}
