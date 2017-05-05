package com.discry.hibernate.f.level2cache;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zhoujp1 on 2017-03-09.
 */
public class Country  implements Serializable {
    private Integer cid;
    private String cname;
    private Set<Minister> ministers;

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

    public Set<Minister> getMinisters() {
        return ministers;
    }

    public void setMinisters(Set<Minister> ministers) {
        this.ministers = ministers;
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
                ", ministers=" + ministers +
                '}';
    }
}
