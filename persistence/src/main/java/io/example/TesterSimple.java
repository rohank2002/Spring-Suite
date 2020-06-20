package io.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesterSimple {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        //INSERT
//        Employee employee =  new Employee();
//        employee.setEmail("rohan.kamay@imail.com");
//        employee.setFisrstName("rohan");
//        employee.setLastName("kamat");
//        entityManager.getTransaction().begin();
//        entityManager.persist(employee);
//        entityManager.getTransaction().commit();
        //FIND BY ID
//        Employee emp = entityManager.find(Employee.class,"89ad616f-02ca-4cf4-b92d-20f94fa7acf7");
//        System.out.println(emp);
        // UPDATE
//        entityManager.getTransaction().begin();
//        Employee emp = entityManager.find(Employee.class,"89ad616f-02ca-4cf4-b92d-20f94fa7acf7");
//        emp.setFisrstName("abc");
//        entityManager.merge(emp);
//        entityManager.getTransaction().commit();
        // DELETE
//        entityManager.getTransaction().begin();
//        Employee emp = entityManager.find(Employee.class,"89ad616f-02ca-4cf4-b92d-20f94fa7acf7");
//        entityManager.remove(emp);
//        entityManager.getTransaction().commit();
        // FINDALL

//        TypedQuery<Employee> query = entityManager.createQuery("SELECT emp FROM Employee emp ORDER BY  emp.email DESC ",Employee.class);
//        List<Employee> resilt = query.getResultList();
//        for(Employee emp : resilt){
//            System.out.println(emp);
//        }
        // Find by email
//        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByEmail",Employee.class);
//        query.setParameter("paramEmail","rohan.kamay@imail.com");
//        List<Employee> result = query.getResultList();
//        for(Employee emp : result){
//            System.out.println(emp);
//        }

        entityManagerFactory.close();
    }
}
