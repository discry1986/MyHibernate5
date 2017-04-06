package com.discry.hibernate.f.cache;

/**
 * Created by Zhoujp1 on 2017-02-17.
 */
public class Student {
    private Integer sid;
    private String stuNo;
    private String name;
    private Double score;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Student() {
    }

    public Student(String stuNo, String name, Double score) {
        this.stuNo = stuNo;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", stuNo='" + stuNo + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
