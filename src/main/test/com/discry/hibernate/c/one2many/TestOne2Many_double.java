package com.discry.hibernate.c.one2many;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.c.one2many_d.Country;
import com.discry.hibernate.c.one2many_d.Minister;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Set;

/**
 * Created by Zhoujp1 on 2017-03-10.
 */
public class TestOne2Many_double {
    @Test
    public void testOne2Many_double_country(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Country country = new Country("USA");
        Country country2 = new Country("China");
        Minister minister = new Minister("AAA");
        Minister minister1 = new Minister("BBB");
        //country维护关系
        country.getMinisters().add(minister);
        session.save(country);

        country2.getMinisters().add(minister1);
        session.save(country2);
        session.getTransaction().commit();
    }

    @Test
    public void testOne2Many_double_minister(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Country country = new Country("USA");
        Minister minister = new Minister("AAA");
        Minister minister1 = new Minister("BBB");
        //country维护关系
        minister.setCountry(country);
        minister1.setCountry(country);

        session.save(minister);
        session.save(minister1);
        session.getTransaction().commit();
    }

    @Test
    public void testCascade_Delete(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Country country = session.get(Country.class,1);
            session.delete(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCascade_Delete_orphan(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Country country = session.get(Country.class,1);
            Set<Minister> ministerSet = country.getMinisters();

            Minister minister = session.get(Minister.class,1);
            ministerSet.remove(minister);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
