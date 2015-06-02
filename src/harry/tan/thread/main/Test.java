package harry.tan.thread.main;

import harry.tan.thread.entity.Student;
import harry.tan.thread.thread.StudentThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/**
 * http://greemranqq.iteye.com/blog/1969273
 * @author Administrator
 *
 */
public class Test {
    
    private static CountDownLatch countdownLatch = null;
    private final static int threadNumbers = 10000;
    
    public static void main(String[] args) {
        
        // 
        countdownLatch = new CountDownLatch(threadNumbers);
        
        Test test = new Test();
        List<Student> students = test.getAllStudents();
        int j = 1;
        
        // 记录开始时间
        long start = System.currentTimeMillis();
        
        final  int skip = students.size()/threadNumbers;
        
        for (int i = 0; i < students.size(); i += skip) {
            List<Student> sus = students.subList(i, i + skip);
            Thread thead = new Thread(new StudentThread(sus,countdownLatch));
            thead.setName("线程" + j);
            j++;
            thead.start();
        }
        
        
        try {
            countdownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(threadNumbers+"线程执行时间统计："+(System.currentTimeMillis()-start));
    }



    /**
     * 
     * <method description> 构造10w数据分4个线程并行插入
     * 
     * @return
     */
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<Student>();
        String sex = "男";
        for (int i = 1; i <= 100000; i++) {
            Student student = new Student();

            student.setName("harry");
            student.setAge(i);
            sex = i % 2 == 0 ? "女" : "男";
            student.setSex(sex);
            students.add(student);
        }

        return students;
    }
}
