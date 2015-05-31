package harry.tan.thread.thread;

import harry.tan.thread.db.DBManager;
import harry.tan.thread.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentThread implements Runnable {
    private List<Student> students = new ArrayList<Student>();
    private final String  sql      = "INSERT INTO student(name,sex,age) VALUES(?,?,?)";
    private DBManager     db       = new DBManager();



    public StudentThread(List<Student> students) {
        this.students = students;

    }



    @Override
    public void run() {
        
        System.out.println(Thread.currentThread().getName()+"运行");
        for (Student student : students) {
            db.executeUpdate(sql, student.getName(),student.getSex(),student.getAge());
        }
    }
}
