package com.discry.hibernate.b.hql;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.b.Course;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * Created by Zhoujp1 on 2017-02-28.
 */
public class TestHQL {
    @Test
    public void testHQL1(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course";
        List<Course> list = session.createQuery(hql).list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testHQL2(){
        Session session = HibernateUtils.getSession();
        String hql = "from Course order by isMain";
        session.beginTransaction();
        List<Course> list = session.createQuery(hql).list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testHQL3(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course where isMain = :isMain";
        List<Course> list = session.createQuery(hql).setParameter("isMain",true).list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testHQL4(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course";
        List<Course> list = session.createQuery(hql)
                                    .setFirstResult(4)
                                    .setMaxResults(2)
                                    .list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testHQL5(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course where courseName like :cName";
        List<Course> list = session.createQuery(hql)
                                    .setParameter("cName","%name_2%")
                                    .list();
        for(Course c:list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testHQL6(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course where courseName = :cName";
        Course course = (Course)session.createQuery(hql).setParameter("cName","name_2").uniqueResult();
        System.out.println(course.toString());
        session.getTransaction().commit();
    }

    @Test
    public void testHQL7(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "select count(*) from Course";
        Object total = session.createQuery(hql).uniqueResult();
        System.out.println(total.toString());
        session.getTransaction().commit();
    }

    @Test
    public void testHQL8(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "select new Course(courseName,isMain) from Course";
        List<Course> courses = session.createQuery(hql).list();
        for(Course course:courses){
            System.out.println(course);
        }
        session.getTransaction().commit();
    }

    @Test
    public void testHQL9(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "select required from Course group by required having count(isMain) > 2";
        List<Object> Objects = session.createQuery(hql).list();
        for(Object o:Objects){
            System.out.println(o);
        }
        session.getTransaction().commit();
    }

}
