package com.discry.hibernate.b.criteria;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.b.Course;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import java.util.List;

/**
 * Created by Zhoujp1 on 2017-02-28.
 */
public class TestQBC {
    @Test
    public void testQBC1(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Course> list = session.createCriteria(Course.class).list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testQBC2(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Course> list = session.createCriteria(Course.class).addOrder(Order.desc("isMain")).list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testQBC3(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Course> list = session.createCriteria(Course.class)
                .add(Restrictions.eq("isMain",false))
                .list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testQBC4(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Course> list = session.createCriteria(Course.class)
                                    .setFirstResult(4)
                                    .setMaxResults(2)
                                    .list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testQBC5(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Course> list = session.createCriteria(Course.class)
                                    .add(Restrictions.like("courseName","%name_3%"))
                                    .list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testQBC6(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Course course = (Course)session.createCriteria(Course.class)
                .add(Restrictions.eq("courseName","name_3"))
                .uniqueResult();
            System.out.println(course.toString());
        session.getTransaction().commit();
    }

    @Test
    public void testQBC7(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Object object = session.createCriteria(Course.class).setProjection(Projections.count("id")).uniqueResult();
        System.out.println(object.toString());
        session.getTransaction().commit();
    }

    @Test
    public void testQBC8(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        ProjectionList projections = Projections.projectionList()
                                            .add(Projections.alias(Projections.property("courseName"),"courseName"))
                                            .add(Projections.alias(Projections.property("isMain"),"isMain"));
        List<Course> list = session.createCriteria(Course.class)
                                .setProjection(projections)
                                .setResultTransformer(Transformers.aliasToBean(Course.class))
                                .list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testQBC9(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        List<Object> objects = session.createCriteria(Course.class)
                                .setProjection(Projections.groupProperty("required"))
                                .list();
        for(Object object:objects){
            System.out.println(object.toString());
        }
        session.getTransaction().commit();
    }
}
