package harry.tan.thread.thread;

import harry.tan.thread.db.DBManager;
import harry.tan.thread.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class StudentThread implements Runnable {
    private List<Student>  students       = new ArrayList<Student>();
    private final String   sql            = "INSERT INTO t2(name,sex,age) VALUES(?,?,?)";
    private DBManager      db             = new DBManager();
    private long           start          = 0;
    private CountDownLatch countDownLatch = null;



    public StudentThread(List<Student> students, CountDownLatch pCountDownLatch) {
        this.students = students;
        this.countDownLatch = pCountDownLatch;
    }



    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "开始干活！");
        start = System.currentTimeMillis();
        for (Student student : students) {
             db.executeUpdate(sql,
             student.getName(),student.getSex(),student.getAge());
            try {

                // 模拟处理存储时间
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "干活结束！时间花费：" + (System.currentTimeMillis() - start));
        countDownLatch.countDown();
    }
}
