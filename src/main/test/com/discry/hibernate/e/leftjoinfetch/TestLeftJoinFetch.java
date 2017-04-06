package com.discry.hibernate.e.leftjoinfetch;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * Created by zhoujp1 on 2017-03-24.
 */
public class TestLeftJoinFetch {
    @Test
    //准备数据
    public void testLeftJoinFetch00(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Country country = new Country("美国");
            Country country1 = new Country("中国");
            Minister minister1 = new Minister("Richard");
            Minister minister2 = new Minister("Andy");
            Minister minister3 = new Minister("Jay");
            country.getMinisters().add(minister1);
            country.getMinisters().add(minister2);
            country.getMinisters().add(minister3);

            session.save(country);
            session.save(country1);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Test
    //
    public void testLeftJoinFetch001(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            String hql = "from Country c left join c.ministers";
            Query query = session.createQuery(hql);
            List<Object[]> countryList = query.list();
            for (Object[] obj : countryList) {
                System.out.println(obj[0]+" "+obj[1]);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


    @Test
    //迫切左外链接一方
    public void testLeftJoinFetch01(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            String hql = "select distinct c from Country c left join fetch c.ministers";
            Query query = session.createQuery(hql);
            List<Country> countryList = query.list();
            for (Country c : countryList) {
                System.out.println(c.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    //迫切左外链接多方
    public void testLeftJoinFetch02(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            String hql = "from Minister m left join fetch m.country";
            Query query = session.createQuery(hql);
            List<Minister> ministers = query.list();
            for (Minister minister : ministers) {
                System.out.println(minister.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
