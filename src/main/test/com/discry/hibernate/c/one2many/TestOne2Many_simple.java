package com.discry.hibernate.c.one2many;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.c.one2many_s.Country;
import com.discry.hibernate.c.one2many_s.Minister;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-10.
 */
public class TestOne2Many_simple {
    //单向一对多，一方维护关联关系。
    @Test
    public void testOne2Many_simple(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        Country country = new Country("China");

        Minister minister = new Minister("大番薯");
        //Minister minister1 =  new Minister("小番茄");
        //Country维护关联关系
        country.getMinisters().add(minister);
        session.save(country);

        session.getTransaction().commit();
    }


}
