package com.discry.hibernate.d.many2many_s;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhoujp1 on 2017-03-22.
 */
public class Student {
    private Integer sid;
    private String sname;
    private Set<Course> courseSet = new HashSet<Course>();

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public Student() {
    }

    public Student(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", courseSet=" + courseSet +
                '}';
    }
}
