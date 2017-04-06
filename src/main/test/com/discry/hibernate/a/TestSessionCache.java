package com.discry.hibernate.a;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.a.one.Student;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-08.
 */
public class TestSessionCache {
    @Test
    public void testSessionCache(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        //第一次加载，从数据库加载，并将副本存放于Session
        Student student = session.get(Student.class,1);
        System.out.println(student);
        //第二次加载，直接从Session加载
        Student student2 = session.get(Student.class,1);
        System.out.println(student2);
        //将student2从session中删除
        session.evict(student2);
        //第二次加载，Session中副本已被删除，所以从数据库加载，并将副本存放于Session
        Student student3 = session.get(Student.class,1);
        System.out.println(student3);
        session.getTransaction().commit();
    }
}
