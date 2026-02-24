package com.lpu.StudentManagement.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        } catch (Exception e) {
            throw new RuntimeException("Session Factory creation failed");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
