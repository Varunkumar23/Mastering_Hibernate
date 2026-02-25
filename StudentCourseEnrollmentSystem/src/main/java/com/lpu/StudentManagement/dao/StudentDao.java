package com.lpu.StudentManagement.dao;

import com.lpu.StudentManagement.entity.Student;
import com.lpu.StudentManagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDao {
    public void createStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
            System.out.println("Student creates successfully!");
        }
    }

    public Student getStudentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                return student;
            } else {
                System.out.println("Student not found");
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }

    public void updateStudentName(int id, String newName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, id);

            if (student != null) {
                student.setName(newName);
                tx.commit();
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found");
            }
        }
    }

    public void deleteStudent(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
                tx.commit();
                System.out.println("Student is deleted successfully!");
            } else {
                System.out.println("Student not found");
            }
        }
    }
}
