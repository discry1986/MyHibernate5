package com.discry.hibernate.a.two;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.a.one.Student;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-02-18.
 */
public class TestA2 {
    @Test
    public void testHibernateUtils(){
        /**1、生成 session*/
        Session session = HibernateUtils.getSession();
        try {
            /**2、开启事务*/
            session.beginTransaction();
            /**3、业务操作*/
            Student student = new Student("B001","小土豆",100.00);
            session.save(student);
            /**4、提交事务*/
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            /**5、回滚事务 */
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testPersist(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = new Student("C001","豆苗",100.00);
            //student.setSid(1);
            session.persist(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @Test
    public void testDelete(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = new Student();
            student.setSid(1);
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testUpdate(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = new Student();
            student.setSid(2);
            student.setScore(95.00);
            session.update(student);
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
            if(student != null)
                System.out.printf(student.toString());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student = session.get(Student.class,1);
            if(student != null)
                System.out.printf(student.toString());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExecuteOrder(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            //更新
            Student student1 = new Student();
            student1.setSid(2);
            student1.setScore(98.00);
            student1.setName("大番薯");
            student1.setStuNo("A001");
            session.update(student1);
            //删除
            Student student2 = new Student();
            student2.setSid(6);
            session.delete(student2);
            session.flush();
            //保存
            Student student3 = new Student("D002","周老师",100.00);
            session.save(student3);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
