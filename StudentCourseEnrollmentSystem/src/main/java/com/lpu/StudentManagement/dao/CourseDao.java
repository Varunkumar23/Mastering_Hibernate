package com.lpu.StudentManagement.dao;

import com.lpu.StudentManagement.entity.Course;
import com.lpu.StudentManagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDao {

    public void createCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(course);
            tx.commit();
            System.out.println("Course added successfully!");
        }
    }

    public void getCourseById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Course course = session.get(Course.class, id);
            if (course != null) {
                System.out.println(course);

            } else {
                System.out.println("Course not found!");
            }
        }
    }

    public List<Course> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Course", Course.class).list();
        }
    }

    public void updateCourse(int id, int newDuration) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Course course = session.get(Course.class, id);
            if (course != null) {
                course.setDuration(newDuration);
                tx.commit();
                System.out.println("Course updated successfully");
            } else {
                System.out.println("Course not found");
            }
        }
    }

    public void deleteCourse(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Course course = session.get(Course.class, id);
            if (course != null) {
                session.remove(course);
                tx.commit();
                System.out.println("Course deleted successfully!");


            }else{
                System.out.println("Course not found!");
            }
        }
    }
}
