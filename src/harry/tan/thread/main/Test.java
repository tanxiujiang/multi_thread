package harry.tan.thread.main;

import harry.tan.thread.entity.Student;
import harry.tan.thread.thread.StudentThread;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        List<Student> students = test.getAllStudents();
        int j = 1;
        for (int i = 0; i < students.size(); i += 25000) {
            List<Student> sus = students.subList(i, i + 25000);
            Thread thead = new Thread(new StudentThread(sus));
            thead.setName("线程" + j);
            j++;
            thead.start();
        }
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
