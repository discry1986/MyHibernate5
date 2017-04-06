package com.discry.hibernate.c.one2many;

import com.discry.hibernate.a.one.HibernateUtils;
import com.discry.hibernate.c.one2many_d_oneself.NewsLabel;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by Zhoujp1 on 2017-03-10.
 */
public class TestOne2Many_double_oneself {
    //自关联一方维护关系
    @Test
    public void testOne2Many_double_oneself(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        NewsLabel sportLabel = new NewsLabel("体育栏目","体育频道");

        NewsLabel footballLabel = new NewsLabel("足球栏目","足球频道");
        NewsLabel basketballLabel = new NewsLabel("篮球栏目","篮球频道");

        sportLabel.getChildNewLabels().add(footballLabel);
        sportLabel.getChildNewLabels().add(basketballLabel);

        session.save(sportLabel);

        session.getTransaction().commit();
    }

    //自关联多方维护关系
    @Test
    public void testOne2Many_double_oneself2(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        NewsLabel footballLabel = new NewsLabel("足球栏目","足球频道");
        NewsLabel sportLabel = new NewsLabel("体育栏目","体育频道");

        footballLabel.setParentNewLabel(sportLabel);

        session.save(footballLabel);

        session.getTransaction().commit();
    }
}
