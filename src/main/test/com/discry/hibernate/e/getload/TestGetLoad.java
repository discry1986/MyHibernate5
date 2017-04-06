package com.discry.hibernate.e.getload;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-26.
 */
public class TestGetLoad {
    @Test
    public void testGetLoad00(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();

            Student student = new Student("001","郁景忻",100.00);
            Student student2 = new Student("002","周景言",100.00);

            session.save(student);
            session.save(student2);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testGet(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class,1);
            System.out.println(student.getSid());
            System.out.println(student.getName());

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testLoad(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = session.load(Student.class,1);
            System.out.println(student.getSid());
            System.out.println(student.getName());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
