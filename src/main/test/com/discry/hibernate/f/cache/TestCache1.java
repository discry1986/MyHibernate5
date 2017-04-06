package com.discry.hibernate.f.cache;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-04-05.
 */
public class TestCache1 {

    @Test
    public void testCache00(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student1= new Student("001","dfs",99.00);
            Student student2 = new Student("002","dd",100.00);
            session.save(student1);
            session.save(student2);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testCache01(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();

            Student student1 = session.load(Student.class,1);
            System.out.println("第一次查询："+student1);
            //session.evict(student1);
            boolean flag1 = session.contains(student1);
            System.out.println("id 为 1的Student是否存在？"+flag1);

            Student student2 = session.load(Student.class,1);
            System.out.println("第二次查询："+student2);

            session.evict(student1);
            boolean flag2 = session.contains(student1);
            System.out.println("id 为 1的Student是否存在？"+flag2);

            Student student3 = session.load(Student.class,1);
            System.out.println("第三次查询："+student3);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
