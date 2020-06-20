package accademy.ennate.Repository;

import accademy.ennate.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findAll",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findOne(String id) {
    return entityManager.find(Employee.class,id);
    }

    public Employee findByEmail(String email){
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.findByEmail",Employee.class);
        query.setParameter("paramEmail",email);
        List<Employee> resultList = query.getResultList();
        if(resultList!=null && resultList.size()==1){
            return resultList.get(0);
        }
        else{
            return null;
        }
    }
    public Employee create(Employee employee){
        entityManager.persist(employee);
        return employee;
    }

    public Employee update(String id, Employee employee){

        entityManager.merge(employee);
        Employee emp = findOne(id);
        return  emp;
    }
    public void delete(Employee employee){
        entityManager.remove(employee);
    }
}
