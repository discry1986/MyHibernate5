package com.discry.hibernate.e.multi;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Zhoujp1 on 2017-03-27.
 */
public class TestMulti {
    @Test
    public void testMulti00(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Country country = new Country("EU");
            Minister minister1 = new Minister("Lee");
            Minister minister2 = new Minister("Jessica");
            Minister minister3 = new Minister("Mils");
            country.getMinisters().add(minister1);
            country.getMinisters().add(minister2);
            country.getMinisters().add(minister3);
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testFetchJoin(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Country country = session.get(Country.class,1);
            Set<Minister> ministers = country.getMinisters();
//            Iterator<Minister> it = ministers.iterator();
//            while (it.hasNext()){
//                Minister minister =(Minister)it.next();
//                System.out.println(minister.getMid());
//                System.out.println(minister.getMname());
//            }
            System.out.println(ministers.size());
            System.out.println(ministers);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
