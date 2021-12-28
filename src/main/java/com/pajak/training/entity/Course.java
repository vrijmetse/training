package com.pajak.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "course_name")
    private String courseName;

    @Column(nullable = false, name = "course_description")
    private String courseDescription;

    @ManyToOne
    @JsonIgnoreProperties(value = {"addressList"})
    private User user;


    public Course() {

    }

    public Course(String courseName, String courseDescription, User user) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.user = user;
    }

    public Course(Long id, String courseName, String courseDescription, User user) {
        this.id = id;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.user = user;
    }

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

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
