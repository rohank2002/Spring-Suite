package accademy.ennate.Repository;

import accademy.ennate.entity.Employee;

import java.util.List;

public interface EmployeeRepo {
    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee employee);
    Employee update(String id,Employee employee);
    void delete(Employee employee);
    Employee findByEmail(String email);

}
