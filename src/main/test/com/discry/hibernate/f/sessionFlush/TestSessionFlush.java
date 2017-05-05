package com.discry.hibernate.f.sessionFlush;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-04-23.
 */
public class TestSessionFlush {
    @Test
    public void testSessionFlush00(){
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
    public void testSessionFlush_delete(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class,1);
            session.delete(student);
            //delete 当刷新时间点到来时是否马上进行缓存更新
            session.createQuery("from Student s").list();
            //session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testSessionFlush_update(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class,1);
            student.setName("dfs");
            //修改后的数据是否与快照中的数据一致。若一致，即数据实际未被修改，则不执行update语句。否则，当达到刷新时间点时，会执行update语句。
            session.createQuery("from Student s").list();
            //session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }


    @Test
    public void testSessionFlush_insert(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = new Student("001","大番薯",100.00);
            session.save(student);
            //由于不是修改Session中现有数据，所以与刷新时间点没关系。在执行完save()方法后，会马上执行insert语句，更新Session缓存中的数据。
            session.createQuery("from Student s").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
