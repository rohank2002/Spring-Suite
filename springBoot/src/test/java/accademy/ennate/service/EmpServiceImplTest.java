package accademy.ennate.service;

import accademy.ennate.Repository.EmployeeRepo;
import accademy.ennate.entity.Employee;
import accademy.ennate.exception.EmployeeNotFound;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class EmpServiceImplTest {

    @TestConfiguration
    static class EmpServiceImplTestConfig{
        @Bean
        public EmployeeService getService(){
            return new EmpServiceImpl();
        }

    }
    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepo employeeRepo;

    private List<Employee>employees;
    @Before
    public void setup(){
    Employee emp = new Employee();
    emp.setFisrstName("rohan");
    emp.setLastName("kamat");
    emp.setEmail("rohan.kamat@ymail.com");
    employees = Collections.singletonList(emp);
        Mockito.when(employeeRepo.findAll())
                .thenReturn(employees);

        Mockito.when(employeeRepo.findById(emp.getId()))
                .thenReturn(Optional.of(emp));
        }
    @After
    public void after(){
        System.out.println("after");
    }


    @Test
    public void findAll() {
        List<Employee> result = employeeService.findAll();
        Assert.assertEquals("employee list should match", employees,result);
    }

    @Test
    public void findOne() {
        Employee result = employeeService.findOne(employees.get(0).getId());
        Assert.assertEquals("Employee should match",employees.get(0),result);
    }
    @Test(expected = EmployeeNotFound.class)
    public void findOneNotFound() throws  Exception {
        Employee result = employeeService.findOne("absbsas");
    }

    @Test
    public void create() {

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByEmail() {
    }
}