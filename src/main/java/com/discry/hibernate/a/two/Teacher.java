package com.discry.hibernate.a.two;

/**
 * Created by Zhoujp1 on 2017-02-24.
 */
public class Teacher {
    private Integer id;
    private String course;
    private Boolean female;
    private String name;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Boolean getFemale() {
        return female;
    }

    public void setFemale(Boolean female) {
        this.female = female;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(){

    }

    public Teacher(String course, Boolean female, String name, int age) {
        this.course = course;
        this.female = female;
        this.name = name;
        this.age = age;
    }
}
