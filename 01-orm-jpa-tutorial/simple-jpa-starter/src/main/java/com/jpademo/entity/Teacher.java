package com.jpademo.entity;

import jakarta.persistence.*;

@Table(name = "teachers", schema = "dbo")
@Entity
public class Teacher {

    @Id
    @Column(name = "teacher_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", unique = true)
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
