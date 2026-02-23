package com.lpu.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session1.beginTransaction();

        Product product = new Product(
                3L,
                "Tablet",
                "Android Tablet",
                "Electronics",
                15,
                25000.0,
                "SKU333",
                true
        );

        session1.persist(product);
        tx1.commit();
        session1.close();
        System.out.println("CREATE: Product inserted successfully");


        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Product readingProduct = session2.get(Product.class, 3L);
        System.out.println("READ: Product Name: " + readingProduct.getName());
        System.out.println("READ: Product Category: " + readingProduct.getCategory());
        System.out.println("READ: Product Price: " + readingProduct.getPrice());

        session2.close();


        Session session3 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx3 = session3.beginTransaction();

        Product updateProduct = session3.get(Product.class, 3L);
        updateProduct.setPrice(23000.0);

        session3.merge(updateProduct);
        tx3.commit();
        session3.close();
        System.out.println("UPDATE: Product price updated");


        Session session4 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx4 = session4.beginTransaction();

        Product deleteProduct = session4.get(Product.class, 3L);
        session4.remove(deleteProduct);

        tx4.commit();
        session4.close();
        System.out.println("DELETE: Product deleted successfully");
    }
}
