package accademy.ennate.service;

import accademy.ennate.entity.Employee;
import accademy.ennate.Repository.EmployeeRepo;
import accademy.ennate.exception.DuplicateEmail;
import accademy.ennate.exception.EmployeeNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo repo;
    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        Iterable<Employee> emps = repo.findAll();
        List<Employee> result = new ArrayList<>();
        for (Employee emp : emps) {
            result.add(emp);
        }
    return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne(String id) {
    Optional<Employee> employee= repo.findById(id);


    if(!employee.isPresent()){
        throw new EmployeeNotFound("Employee with " +id+" not found");
    }else{
        return employee.get();
    }

    }

    @Override
    @Transactional
    public Employee create(Employee employee) {
        repo.save(employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee update(String id, Employee employee) {

        Optional<Employee> emp = repo.findById(id);
        if (!emp.isPresent()){
            throw new EmployeeNotFound("Could not find employee with email: "+id+".");
        }
        else {
            emp.get().setId(id);
            emp.get().setEmail(employee.getEmail().toString());
            emp.get().setLastName(employee.getLastName().toString());
            emp.get().setFisrstName(employee.getFisrstName().toString());
        }
        return repo.save(emp.get());


    }

    @Override
    @Transactional
    public void delete(String id) {
    Optional<Employee> employee = repo.findById(id);
    if(!employee.isPresent()){
        throw new EmployeeNotFound("No employee with id " +id+ " found, cannot delete");
    }
    else{
        repo.deleteById(id);
    }
    }
    @Override
    @Transactional(readOnly = true)
    public Employee findByEmail(String email){
        Optional<Employee> emp = repo.findByEmail(email);
        if (!emp.isPresent()){
            throw new EmployeeNotFound("Could not find employee with email: "+email+".");
        }
        else{
            return emp.get();
        }
    }
}
