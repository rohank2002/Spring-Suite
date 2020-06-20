package accademy.ennate.service;

import accademy.ennate.entity.Employee;
import accademy.ennate.Repository.EmployeeRepo;
import accademy.ennate.exception.DuplicateEmail;
import accademy.ennate.exception.EmployeeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmpServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo repo;
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
    return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne(String id) {
    Employee employee= repo.findOne(id);


    if(employee == null){
        throw new EmployeeNotFound("Employee with " +id+" not found");
    }else{
        return employee;
    }

    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        repo.create(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee update(String id, Employee employee) {
        Employee emp = repo.findOne(id);
        emp.setId(id);
        emp.setEmail(employee.getEmail().toString());
        emp.setLastName(employee.getLastName().toString());
        emp.setFisrstName(employee.getFisrstName().toString());

        repo.update(id,emp);

        return employee;
    }

    @Override
    @Transactional
    public void delete(String id) {
    Employee employee = repo.findOne(id);
    if(employee==null){
        throw new EmployeeNotFound("No employee with id " +id+ " found, cannot delete");
    }
    else{
        repo.delete(employee);
    }
    }
    @Override
    @Transactional(readOnly = true)
    public Employee findByEmail(String email){
        Employee emp = repo.findByEmail(email);
        if (emp == null){
            throw new EmployeeNotFound("Could not find employee with email: "+email+".");
        }
        else{
            return emp;
        }
    }
}
