package com.discry.hibernate.b.sql;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.a.one.Student;
import com.discry.hibernate.b.Course;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import java.util.List;

/**
 * Created by Zhoujp1 on 2017-02-28.
 */
public class TestSQL {
    @Test
    public void testSQL1(){
        Session session = HibernateUtils.getSession();
        String sql = "select * from t_course";
        session.beginTransaction();
        List<Course> list = session.createSQLQuery(sql).addEntity(Course.class).list();
        for(Course c : list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL2(){
        Session session = HibernateUtils.getSession();
        String sql = "select * from t_course order by t_isMain desc";
        session.beginTransaction();
        List<Course> list = session.createSQLQuery(sql).addEntity(Course.class).list();
        for(Course c : list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL3(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select * from t_course where t_isMain = ? order by t_courseName desc";
        List<Course> list = session.createSQLQuery(sql).addEntity(Course.class).setInteger(0,1).list();
        for(Course c : list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL4(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select * from t_course where t_isMain = ? order by t_courseName desc";
        List<Course> list = session.createSQLQuery(sql).addEntity(Course.class).setParameter(0,1).list();
        for(Course c : list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL5(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select * from t_course where t_isMain = :isMain order by t_courseName desc";
        List<Course> list = session.createSQLQuery(sql).addEntity(Course.class).setParameter("isMain",1).list();
        for(Course c : list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL6(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select * from t_course limit :startIndex,:pageSize";
        List<Course> list = session.createSQLQuery(sql).addEntity(Course.class)
                                    .setParameter("startIndex",4)
                                    .setParameter("pageSize",2)
                                    .list();
        for(Course c : list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL7(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select * from t_course where t_courseName like :cName";
        List<Course> list = session.createSQLQuery(sql).addEntity(Course.class)
                                                        .setParameter("cName","%name_1%")
                                                        .list();
        for(Course c : list){
            System.out.println(c.toString());
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL8(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select * from t_course where t_courseName = :cName";
        Course course = (Course)session.createSQLQuery(sql).addEntity(Course.class)
                .setParameter("cName","name_5")
                .uniqueResult();
            System.out.println(course.toString());
        session.getTransaction().commit();
    }

    @Test
    public void testSQL9(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select count(*) from t_course";
        Object total = session.createSQLQuery(sql).uniqueResult();
        System.out.printf(total.toString());
        session.getTransaction().commit();
    }

    @Test
    public void testSQL10(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "select t_courseName courseName,t_isMain isMain from t_course";
        List<Course> courses = session.createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(Course.class)).list();
        for(Course course :courses){
            System.out.println(course);
        }
        session.getTransaction().commit();
    }

    @Test
    public void testSQL11(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        String sql = "SELECT t_required FROM hibernate5.t_course group by t_required having count(t_isMain) > 2";
        List<Object> fee = session.createSQLQuery(sql).list();
        for(Object Object :fee){
            System.out.println(Object);
        }
        session.getTransaction().commit();
    }
}
