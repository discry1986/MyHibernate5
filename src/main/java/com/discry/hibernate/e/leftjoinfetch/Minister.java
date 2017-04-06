package com.discry.hibernate.e.leftjoinfetch;

/**
 * Created by Zhoujp1 on 2017-03-09.
 */
public class Minister {
    private Integer mid;
    private String mname;
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Minister() {

    }

    public Minister(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "Minister{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }
}
