package com.discry.hibernate.a.two;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.a.two.Teacher;
import com.discry.hibernate.a.two.Teacher2;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-02-24.
 */
public class TestA3 {
    @Test
    public void testIdGenerate(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Teacher teacher = new Teacher("语文",true,"大番薯",30);
            session.save(teacher);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testIdGenerate2(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Teacher2 teacher = new Teacher2("语文",true,"大番薯",30);
            session.save(teacher);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
