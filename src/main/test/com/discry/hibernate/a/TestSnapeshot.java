package com.discry.hibernate.a;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.a.one.Student;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-08.
 */
public class TestSnapeshot {
    @Test
    public void  testSnapeShot(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        //执行查询，会将结果保存于session缓存，并在快照中保存一个副本
        Student student = session.get(Student.class,1);
        System.out.println(student);
        //修改数据
        student.setName("周佳");
        //提交时会与快照中的数据进行对比，数据不同，执行update，同时，也会在快照中保存一份副本
        session.getTransaction().commit();
    }
}
