package com.discry.hibernate.a.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Zhoujp1 on 2017-02-18.
 */
public class HibernateUtils {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory(){
        if(sessionFactory == null || sessionFactory.isClosed()){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession(){
        return getSessionFactory().getCurrentSession();
    }
}
