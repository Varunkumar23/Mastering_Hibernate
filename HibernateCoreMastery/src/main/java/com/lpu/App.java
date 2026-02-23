package com.lpu;

import com.lpu.hibernate.config.HibernateUtil;
import org.hibernate.SessionFactory;
import com.lpu.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        User u1 = new User("Varun Kumar", "sarabuvarunkumar@gmail.com");
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(u1);
            tx.commit();
            session.close();
            System.out.println("User saved successfully!");
        }

    }
}
