package com.lpu.org.hibernatePractice.entity;

import javax.persistence.*;


@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 50, name="Student_Name")
    private String name;
    @Column(nullable = false,name="Student_Fees")
    private double studentFees;

    public int getId() {
        return id;
    }
    public String toString(){
        return id+" "+name+" "+studentFees;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStudentFees() {
        return studentFees;
    }

    public void setStudentFees(double studentFees) {
        this.studentFees = studentFees;
    }
}