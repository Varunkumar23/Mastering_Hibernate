package com.lpu.hibernate.dao;

import com.lpu.hibernate.config.HibernateUtil;
import com.lpu.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.descriptor.java.spi.JsonJavaType;

import java.util.List;

public class UserDao {
    public void createUser(User user) {
        try (
                Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
            System.out.println("User Created successfully!");
        }


    }

    public void getUserById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User user = session.get(User.class, id);
            if (user != null) {
                System.out.println(user);
            } else {
                System.out.println("User not found");
            }

        }
    }

    public List<User> getALlUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    public void updateUser(int id, String newName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                user.setName(newName);
                tx.commit();
                System.out.println("User updated successfully");

            } else {
                System.out.println("User not found");

            }

        }
    }

    public void deleteUser(int id){
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Transaction tx=session.beginTransaction();
            User user=session.get(User.class,id);
            if(user!=null){
                session.remove(user);
                tx.commit();
                System.out.println("User deleted successfully!");
            }else{
                System.out.println("User not found");
            }
        }
    }
}

