package com.discry.hibernate.b;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Zhoujp1 on 2017-02-28.
 */
public class TestData {
    @Test
    public void testData(){
        Session session = HibernateUtils.getSession();
        try {
            session.beginTransaction();
            for(int i = 1 ; i<= 10 ; i++){
                Course course = new Course("name_"+i,"code_"+i,i%2==0?true:false,(new Double(new Random().nextInt(5) + 1)*1000));
                session.save(course);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void  testRandom(){
        for(int i=0;i<100;i++)
        System.out.println( new Random().nextInt(5) + 1);
    }
}
