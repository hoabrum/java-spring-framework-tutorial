package com.jpademo.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "courses", schema = "dbo")
@Entity
public class Course {

    @Id
    @Column(name = "course_id")
    private Long id;
    @Column(name = "course_name")
    private String courseName;

    @ManyToMany
    @JoinTable(name = "courses_students",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
