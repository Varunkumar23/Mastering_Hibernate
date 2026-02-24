package com.lpu;

import com.lpu.StudentManagement.entity.Student;
import com.lpu.StudentManagement.dao.StudentDao;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student1 = new Student("Varun Kumar", "sarabuvarunkumar@gmail.com");
        Student student2 = new Student("Hari Krishna", "harikrishna@gmail.com");
        Student student3 = new Student("Adithya", "adithya@gmail.com");

//        studentDao.createStudent(student1);
//        studentDao.createStudent(student2);
//        studentDao.createStudent(student3);

        studentDao.getStudentById(1);

        System.out.println(studentDao.getAllStudents());

        studentDao.updateStudentName(1, "Sarabu Varun Kumar");
        studentDao.getStudentById(1);

    }
}
