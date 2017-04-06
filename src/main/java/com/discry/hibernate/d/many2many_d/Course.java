package com.discry.hibernate.d.many2many_d;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhoujp1 on 2017-03-22.
 */
public class Course {
    private Integer cid;
    private String cname;
    private Set<Student> studentSet = new HashSet<Student>();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Course() {
    }

    public Course(String cname) {
        this.cname = cname;
    }
}
