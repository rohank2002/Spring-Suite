package io.example;

import io.example.entity.Address;
import io.example.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

public class TesterWithRelationalEntity {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        //INSERT
//        User user = new User();
//        user.setEmail("rohan@gmail.com");
//        user.setFisrstName("rohan");
//        user.setLastName("kamat");
//        Address address = new Address();
//        address.setCity("san jose");
//        address.setState("CA");
//        address.setStreet("abccc");
//        entityManager.getTransaction().begin();
//        entityManager.persist(address);
//        user.setAddress(address);
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
        //FIND
//        User user = entityManager.find(User.class,"fc6d03f5-5d34-4a10-a32c-a8db2dff8bd7");
//        System.out.println(user);
        entityManager.close();
        entityManagerFactory.close();
    }
}
