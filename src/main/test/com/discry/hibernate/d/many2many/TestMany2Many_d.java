package com.discry.hibernate.d.many2many;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.d.many2many_d.Course;
import com.discry.hibernate.d.many2many_d.Student;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-23.
 */
public class TestMany2Many_d {
    @Test
    public  void testMany2Many00(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();

            Student student1 = new Student("周佳平");
            Student student2 = new Student("任贤齐");
            Student student3 = new Student("张柏芝");

            Course course1 = new Course("英语");
            Course course2 = new Course("化学");

            course1.getStudentSet().add(student1);
            course1.getStudentSet().add(student2);
            course2.getStudentSet().add(student3);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
