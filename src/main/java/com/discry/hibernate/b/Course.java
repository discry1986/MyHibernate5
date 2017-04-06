package com.discry.hibernate.b;

/**
 * Created by Zhoujp1 on 2017-02-27.
 */
public class Course {
    private String id;
    private String courseName;//课程名称
    private String courseCode;//课程代码
    private Boolean isMain;//是否主修
    private Double required;//需要支付费用

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Boolean getIsMain() {
        return isMain;
    }

    public void setIsMain(Boolean isMain) {
        this.isMain = isMain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getRequired() {
        return required;
    }

    public void setRequired(Double required) {
        this.required = required;
    }

    public Course() {
    }

    public Course(String courseName, Boolean isMain) {
        this.courseName = courseName;
        this.isMain = isMain;
    }

    public Course(String courseName, String courseCode, Boolean isMain, Double required) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.isMain = isMain;
        this.required = required;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", isMain=" + isMain +
                ", required=" + required +
                '}';
    }
}






