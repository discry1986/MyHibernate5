package com.discry.hibernate.e.single;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-30.
 */
public class TestSingle {
    @Test
    public void testSingle00(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Country country = new Country("EU");
            Minister minister1 = new Minister("Lee");
            Minister minister2 = new Minister("Jessica");
            country.getMinisters().add(minister1);
            country.getMinisters().add(minister2);
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testSingle(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Minister minister = session.get(Minister.class,1);
            System.out.println(minister.getCountry().getCid());
            System.out.println(minister.getCountry().getCname());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
