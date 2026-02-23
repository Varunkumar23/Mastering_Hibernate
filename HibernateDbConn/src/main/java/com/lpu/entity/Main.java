package com.lpu.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {

        Transaction transaction = null;

        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {

            transaction = session.beginTransaction();

            Address address = new Address(
                    "Model Town",
                    "Jalandhar",
                    "Punjab",
                    "144001"
            );

            User user = new User(3, "Varun", 70000, address);

            session.persist(user);

            transaction.commit();

            System.out.println("User with address inserted successful!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




        try (Session session = HibernateUtil
                .getSessionFactory()
                .openSession()) {

            User user = session.load(User.class, 3);

            if (user != null) {
                System.out.println(user);
                System.out.print("{ "+user.getAddress().getStreet()+", ");
                System.out.print(user.getAddress().getCity()+", ");
                System.out.print(user.getAddress().getState()+", ");
                System.out.print(user.getAddress().getZipCode()+" }");


            } else {
                System.out.println("User not found");
            }
        }



    }
}
