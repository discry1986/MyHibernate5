package com.discry.hibernate.a.one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-02-17.
 */

public class TestA {
    @Test
    public void testSave(){
        /**1、加载配置文件hibernate.cfg.xml*/
        Configuration cfg = new Configuration().configure("xxx.cfg.xml");
        /**2、生成 sessionFactory*/
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        /**3、生成 session*/
        Session session = sessionFactory.getCurrentSession();
        try {
            /**4、开启事务*/
            session.beginTransaction();
            Student student =  new Student("A001","大番薯",99.00);
            student.setSid(7);
            /**5、业务操作*/
            session.save(student);
            /**6、提交事务*/
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            /**7、回滚事务 */
            session.getTransaction().rollback();
        }
    }
}
