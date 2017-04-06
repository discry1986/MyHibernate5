package com.discry.hibernate.d.many2many_s;

/**
 * Created by Zhoujp1 on 2017-03-22.
 */
public class Course {
    private Integer cid;
    private String cname;

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

    public Course() {
    }

    public Course(String cname) {
        this.cname = cname;
    }
}
