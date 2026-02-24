package com.lpu.StudentManagement.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private int duration;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments=new ArrayList<>();

    public Course() {
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
