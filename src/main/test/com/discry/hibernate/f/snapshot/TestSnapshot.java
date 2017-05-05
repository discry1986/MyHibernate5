package com.discry.hibernate.f.snapshot;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-04-06.
 */
public class TestSnapshot {
    @Test
    public void testSnapshot(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Student student = new Student("001","大番薯",99.00);
        session.save(student);
        session.getTransaction().commit();
    }

    @Test
    public void testSnapshot01(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Student student = session.get(Student.class,1);
        student.setName("张三");
        session.getTransaction().commit();
    }
}
