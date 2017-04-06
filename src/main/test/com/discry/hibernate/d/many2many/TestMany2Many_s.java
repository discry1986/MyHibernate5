package com.discry.hibernate.d.many2many;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.d.many2many_s.Course;
import com.discry.hibernate.d.many2many_s.Student;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-23.
 */
public class TestMany2Many_s {
    @Test
    public  void testMany2Many00(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            Student student1 = new Student("张三");
            Student student2 = new Student("李四");

            Course course1 = new Course("Struts2");
            Course course2 = new Course("Spring4");
            Course course3 = new Course("Hibernate5");

            student1.getCourseSet().add(course1);
            student1.getCourseSet().add(course3);

            student2.getCourseSet().add(course2);
            student2.getCourseSet().add(course3);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    @Test
    public  void testMany2Many01(){

    }
}
