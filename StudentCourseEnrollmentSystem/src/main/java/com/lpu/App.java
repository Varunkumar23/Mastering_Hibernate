package com.lpu;

import com.lpu.StudentManagement.dao.CourseDao;
import com.lpu.StudentManagement.dao.EnrollmentDao;
import com.lpu.StudentManagement.entity.Course;
import com.lpu.StudentManagement.entity.Enrollment;
import com.lpu.StudentManagement.entity.Student;
import com.lpu.StudentManagement.dao.StudentDao;
import com.lpu.StudentManagement.util.HibernateUtil;
import org.hibernate.Session;

import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        CourseDao courseDao=new CourseDao();
        EnrollmentDao enrollmentDao=new EnrollmentDao();
        Student student1 = new Student("Varun Kumar", "sarabuvarunkumar@gmail.com");
        Student student2 = new Student("Hari Krishna", "harikrishna@gmail.com");
        Student student3 = new Student("Adithya", "adithya@gmail.com");

        studentDao.createStudent(student1);
        studentDao.createStudent(student2);
        studentDao.createStudent(student3);

        Course course1=new Course("Physics",4);
        Course course2=new Course("Maths",5);
        courseDao.createCourse(course1);
        courseDao.createCourse(course2);



        enrollmentDao.enrollStudent(student1.getId(),course1.getId());
        enrollmentDao.enrollStudent(student2.getId(),course1.getId());
        enrollmentDao.enrollStudent(student1.getId(),course2.getId());
        enrollmentDao.enrollStudent(student3.getId(),course1.getId());

        try (
                Session session = HibernateUtil.getSessionFactory().openSession()) {

            Student student = session.get(Student.class, 1L);

            System.out.println(student.getName());

            for (Enrollment e : student.getEnrollments()) {
                System.out.println(e.getCourse().getTitle());
            }

            Course course=session.get(Course.class,1);
            for(Enrollment e:course.getEnrollments()){
                System.out.println(e.getStudent().getName());
            }
        }





    }
}
