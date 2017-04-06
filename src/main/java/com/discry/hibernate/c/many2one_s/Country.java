package com.discry.hibernate.c.many2one_s;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhoujp1 on 2017-03-09.
 */
public class Country {
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

    public Country() {

    }

    public Country(String cname) {
        this();
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
