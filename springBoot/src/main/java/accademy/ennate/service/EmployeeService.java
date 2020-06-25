package accademy.ennate.service;

import accademy.ennate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee employee);
    Employee update(String id, Employee employee);
    Employee findByEmail(String email);
    void delete(String id);

}
