package com.discry.hibernate.b;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-08.
 */
public class TestNamedQuery {
    @Test
    public void queryNamedQuery(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Course course = (Course)session.createNamedQuery("selectCourseById").setParameter("myid","XXX").uniqueResult();
        System.out.println(course);
        session.getTransaction().commit();
    }
}
