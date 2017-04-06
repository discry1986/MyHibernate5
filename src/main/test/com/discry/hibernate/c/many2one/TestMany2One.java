package com.discry.hibernate.c.many2one;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.c.many2one_s.Country;
import com.discry.hibernate.c.many2one_s.Minister;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-22.
 */
public class TestMany2One {
    @Test
    public void testMany2One(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        Country country = new Country("USA");
        Minister minister = new Minister("大番薯");
        minister.setCountry(country);

        session.save(minister);
        session.getTransaction().commit();
    }
}
