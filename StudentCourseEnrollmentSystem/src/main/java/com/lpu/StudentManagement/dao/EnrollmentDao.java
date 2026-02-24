package com.lpu.StudentManagement.dao;


import com.lpu.StudentManagement.entity.*;
import com.lpu.StudentManagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EnrollmentDao {

    public void enrollStudent(Long studentId, Long courseId) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            Course course = session.get(Course.class, courseId);

            if (student == null || course == null) {
                System.out.println("Invalid student or course ID");
                return;
            }

            Enrollment enrollment = new Enrollment(student, course);

            session.persist(enrollment);

            tx.commit();
            System.out.println("Student enrolled successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    public Enrollment getEnrollmentById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Enrollment.class, id);
        }
    }

    public List<Enrollment> getAllEnrollments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Enrollment", Enrollment.class).list();
        }
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "select e.course from Enrollment e where e.student.id = :studentId",
                            Course.class
                    )
                    .setParameter("studentId", studentId)
                    .list();
        }
    }

    public List<Student> getStudentsByCourseId(Long courseId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                            "select e.student from Enrollment e where e.course.id = :courseId",
                            Student.class
                    )
                    .setParameter("courseId", courseId)
                    .list();
        }
    }

    public void updateEnrollmentCourse(Long enrollmentId, Long newCourseId) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Enrollment enrollment = session.get(Enrollment.class, enrollmentId);
            Course newCourse = session.get(Course.class, newCourseId);

            if (enrollment == null || newCourse == null) {
                System.out.println("Invalid enrollment or course ID");
                return;
            }

            enrollment.setCourse(newCourse);

            tx.commit();
            System.out.println("Enrollment updated successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    public void deleteEnrollment(Long enrollmentId) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Enrollment enrollment = session.get(Enrollment.class, enrollmentId);

            if (enrollment == null) {
                System.out.println("Enrollment not found");
                return;
            }

            session.remove(enrollment);

            tx.commit();
            System.out.println("Enrollment deleted successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println(e.getMessage());
        }
    }
}
