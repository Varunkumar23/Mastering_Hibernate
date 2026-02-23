package com.lpu;

import com.lpu.hibernate.config.HibernateUtil;
import com.lpu.hibernate.dao.UserDao;
import org.hibernate.SessionFactory;
import com.lpu.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLOutput;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User u1 = new User("Varun Kumar", "sarabuvarunkumar@gmail.com");
        User u2 = new User("Tharun Kumar", "sarabutharunkumar@gmail.com");
        User u3 = new User("Akhil Kumar", "akkineniakhil@gmail.com");

//        userDao.createUser(u1);
//        userDao.createUser(u2);
//        userDao.createUser(u3);

//        userDao.getUserById(1);
//        userDao.getUserById(2);

//        System.out.println(userDao.getALlUsers());

//        userDao.getUserById(3);
//        userDao.updateUser(3, "Akkineni Akhil");
//        userDao.getUserById(3);
//        userDao.deleteUser(3);
//        System.out.println(userDao.getALlUsers());

        Scanner sc=new Scanner(System.in);
        System.out.println("Hello Darling! \n Can you please enter for whom you want to update and what you want to update?");
        System.out.println("Enter user id:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter field to update (name/email):");
        String field = sc.nextLine();

        System.out.println("Enter new value:");
        String newValue = sc.nextLine();

        userDao.dynamicUpdate(id, field, newValue);
        userDao.dynamicUpdate(id,field,newValue);

        userDao.getUserById(1);



    }
}
