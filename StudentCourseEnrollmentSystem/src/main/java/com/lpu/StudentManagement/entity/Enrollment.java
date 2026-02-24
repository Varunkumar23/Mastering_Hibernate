package com.lpu.StudentManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Enrollment() {
    }

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Enrollment{id=" + id +
                ", student=" + student.getName() +
                ", course=" + course.getTitle() +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}