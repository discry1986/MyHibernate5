package com.discry.hibernate.f.level2cache;

import com.discry.hibernate.a.one.HibernateUtils;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-04-23.
 */
public class TestLevel2Cache {
    @Test
    public void testData(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        try {
            Country country = new Country("USA");
            Minister minister1 = new Minister("张三");
            Minister minister2 = new Minister("李四");
            country.getMinisters().add(minister1);
            country.getMinisters().add(minister2);
            session.save(country);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    //测试二级缓存的存在
    public void testSecondCache(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        try {
            Country country = session.get(Country.class,1);
            System.out.println("第一次查询："+country.getCname());

            Country country2 = session.get(Country.class,1);
            System.out.println("第二次查询："+country2.getCname());

            session.clear();
            System.out.println("清空session一级缓存");

            Country country3 = session.get(Country.class,1);
            System.out.println("第三次查询："+country3.getCname());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
