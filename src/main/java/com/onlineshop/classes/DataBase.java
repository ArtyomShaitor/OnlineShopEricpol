package com.onlineshop.classes;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 * Created by HOME on 25.11.2014.
 */
public class DataBase {

    public void addType(String title){

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Type type = new Type();
        type.setTitle(title);
        session.save(type);
        session.getTransaction().commit();
        session.close();

//
//        SessionFactory sf1 = HibernateUtil.getSessionFactory();
//        Session session1 = sf1.openSession();
//        session1.beginTransaction();
//        Type type1 = new Type();
//        type1.setTitle(title);
//        session1.save(type1);
//        session1.getTransaction().commit();
//        session1.close();

    }

}
