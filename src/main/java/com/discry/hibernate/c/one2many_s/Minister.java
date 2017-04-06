package com.discry.hibernate.c.one2many_s;

/**
 * Created by Zhoujp1 on 2017-03-09.
 */
public class Minister {
    private Integer mid;
    private String mname;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Minister(String mname) {
        this.mname = mname;
    }

    public Minister() {
    }

    @Override
    public String toString() {
        return "Minister{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }
}
