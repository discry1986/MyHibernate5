package com.discry.hibernate.b;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Zhoujp1 on 2017-03-01.
 */
public class TestList_Iterator {
    @Test
    public void testList(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course";
        //第一次查询
        List<Course> list = session.createQuery(hql).list();
        for(Course course :list){
            System.out.println(course);
        }
        //第二次查询
        List<Course> list2 = session.createQuery(hql).list();
        for(Course course :list2){
            System.out.println(course);
        }
        session.getTransaction().commit();
    }

    @Test
    public void testIterator(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course";
        //第一次查询
        Iterator iterate = session.createQuery(hql).iterate();
        while (iterate.hasNext()){
            Course course = (Course) iterate.next();
            System.out.println(course);
        }
        //第二次查询
        Iterator iterate2 = session.createQuery(hql).iterate();
        while (iterate2.hasNext()){
            System.out.println(iterate2.next());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testListIterator(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String hql = "from Course";
        //第一次查询
        List<Course> courses = session.createQuery(hql).list();
        for (Course course : courses){
            System.out.println(course);
        }
        //第二次查询
        Iterator iterate2 = session.createQuery(hql).iterate();
        while (iterate2.hasNext()){
            System.out.println(iterate2.next());
        }
        session.getTransaction().commit();
    }
}
